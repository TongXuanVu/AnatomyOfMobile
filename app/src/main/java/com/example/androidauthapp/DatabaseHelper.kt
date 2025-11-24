package com.example.androidauthapp

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log

class DatabaseHelper(context: Context) :
    SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        private const val DATABASE_VERSION = 1
        private const val DATABASE_NAME = "UserManager.db"
        private const val TABLE_USERS = "users"
        private const val KEY_ID = "id"
        private const val KEY_USERNAME = "username"
        private const val KEY_PASSWORD = "password"
    }

    override fun onCreate(db: SQLiteDatabase) {
        val CREATE_USERS_TABLE = ("CREATE TABLE " + TABLE_USERS + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_USERNAME + " TEXT UNIQUE,"
                + KEY_PASSWORD + " TEXT" + ")")
        db.execSQL(CREATE_USERS_TABLE)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS $TABLE_USERS")
        onCreate(db)
    }

    /**
     * Thêm người dùng mới vào cơ sở dữ liệu.
     * Trả về true nếu thêm thành công, false nếu tên đăng nhập đã tồn tại.
     */
    fun addUser(username: String, password: String): Boolean {
        val db = this.writableDatabase
        val values = ContentValues()
        values.put(KEY_USERNAME, username)
        values.put(KEY_PASSWORD, password)

        // Kiểm tra xem tên đăng nhập đã tồn tại chưa
        if (checkUserExists(username)) {
            db.close()
            return false
        }

        // Thêm hàng mới
        val success = db.insert(TABLE_USERS, null, values)
        db.close()

        return success != -1L
    }

    /**
     * Kiểm tra người dùng có tồn tại và mật khẩu có đúng không.
     * Trả về đối tượng User nếu đăng nhập thành công, null nếu thất bại.
     */
    fun checkUser(username: String, password: String): User? {
        val db = this.readableDatabase
        val selectQuery = "SELECT * FROM $TABLE_USERS WHERE $KEY_USERNAME = ? AND $KEY_PASSWORD = ?"
        val cursor = db.rawQuery(selectQuery, arrayOf(username, password))

        var user: User? = null
        if (cursor.moveToFirst()) {
            val idIndex = cursor.getColumnIndex(KEY_ID)
            val usernameIndex = cursor.getColumnIndex(KEY_USERNAME)
            val passwordIndex = cursor.getColumnIndex(KEY_PASSWORD)

            if (idIndex != -1 && usernameIndex != -1 && passwordIndex != -1) {
                val id = cursor.getInt(idIndex)
                val uname = cursor.getString(usernameIndex)
                val pass = cursor.getString(passwordIndex)
                user = User(id, uname, pass)
            }
        }
        cursor.close()
        db.close()
        return user
    }

    /**
     * Kiểm tra xem tên đăng nhập đã tồn tại chưa.
     */
    private fun checkUserExists(username: String): Boolean {
        val db = this.readableDatabase
        val selectQuery = "SELECT * FROM $TABLE_USERS WHERE $KEY_USERNAME = ?"
        val cursor = db.rawQuery(selectQuery, arrayOf(username))
        val exists = cursor.count > 0
        cursor.close()
        return exists
    }
}
