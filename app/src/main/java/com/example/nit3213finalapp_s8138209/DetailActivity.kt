package com.example.nit3213finalapp_s8138209

import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        // ✅ Back arrow (TextView version)
        val backArrow = findViewById<TextView>(R.id.back_arrow)
        backArrow.setOnClickListener {
            finish()
        }

        // ✅ Container to hold dynamic key-value pairs
        val container = findViewById<LinearLayout>(R.id.detail_content_container)

        // ✅ Extract all extras from the intent
        val extras = intent.extras
        if (extras != null) {
            for (key in extras.keySet()) {
                val value = extras.getString(key)

                val labelView = TextView(this).apply {
                    text = "$key:"
                    textSize = 16f
                    setPadding(0, 16, 0, 0)
                    setTypeface(null, android.graphics.Typeface.BOLD)
                }

                val valueView = TextView(this).apply {
                    text = value ?: ""
                    textSize = 16f
                    setPadding(0, 4, 0, 0)
                }

                container.addView(labelView)
                container.addView(valueView)
            }
        }
    }
}
