package com.example.nit3213finalapp_s8138209

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // ✅ Setup Spinner (Location Dropdown)
        val locationSpinner = findViewById<Spinner>(R.id.spinner_location)

        val locationAdapter = ArrayAdapter.createFromResource(
            this,
            R.array.location_array,
            android.R.layout.simple_spinner_item
        )

        locationAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        locationSpinner.adapter = locationAdapter
    }
}
