package com.example.androidauthapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tvWelcome: TextView = findViewById(R.id.tvWelcome)
        val btnLogout: Button = findViewById(R.id.btnLogout)

        // Lấy tên người dùng từ Intent (giả sử đã đăng nhập thành công)
        val username = intent.getStringExtra("USERNAME")
        tvWelcome.text = "Chào mừng, $username!"

        btnLogout.setOnClickListener {
            // Chuyển về màn hình đăng nhập
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish() // Đóng MainActivity
        }
    }
}
