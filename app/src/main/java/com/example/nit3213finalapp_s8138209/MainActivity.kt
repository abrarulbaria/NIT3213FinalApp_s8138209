package com.example.nit3213finalapp_s8138209

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val keypass = intent.getStringExtra("keypass") ?: "No topic"

        val welcomeMessage = "Welcome! Your topic is:\n\n$keypass"

        val textView = findViewById<TextView>(R.id.tv_topic)
        textView.text = welcomeMessage
    }
}
