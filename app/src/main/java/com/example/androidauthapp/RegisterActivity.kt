package com.example.androidauthapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class RegisterActivity : AppCompatActivity() {

    private lateinit var dbHelper: DatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        // Khởi tạo DatabaseHelper
        dbHelper = DatabaseHelper(this)

        val etUsername = findViewById<EditText>(R.id.etRegisterUsername)
        val etPassword = findViewById<EditText>(R.id.etRegisterPassword)
        val btnRegister = findViewById<Button>(R.id.btnRegister)
        val tvLoginPrompt = findViewById<TextView>(R.id.tvLoginPrompt)

        // Xử lý sự kiện Đăng ký
        btnRegister.setOnClickListener {
            val username = etUsername.text.toString().trim()
            val password = etPassword.text.toString().trim()

            if (username.isNotEmpty() && password.isNotEmpty()) {
                // Thêm người dùng vào SQLite
                val isInserted = dbHelper.addUser(username, password)
                if (isInserted) {
                    Toast.makeText(this, "Đăng ký thành công!", Toast.LENGTH_SHORT).show()
                    // Chuyển về màn hình đăng nhập sau khi đăng ký thành công
                    val intent = Intent(this, LoginActivity::class.java)
                    startActivity(intent)
                    finish() // Đóng màn hình đăng ký
                } else {
                    Toast.makeText(this, "Đăng ký thất bại. Tên đăng nhập đã tồn tại.", Toast.LENGTH_LONG).show()
                }
            } else {
                Toast.makeText(this, "Vui lòng nhập đầy đủ thông tin.", Toast.LENGTH_SHORT).show()
            }
        }

        // Xử lý sự kiện chuyển về màn hình Đăng nhập
        tvLoginPrompt.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish() // Đóng màn hình đăng ký
        }
    }
}
