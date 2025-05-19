package com.example.nit3213finalapp_s8138209

import android.content.Intent
import android.os.Bundle
import android.os.StrictMode
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import org.json.JSONObject
import java.io.OutputStreamWriter
import java.net.HttpURLConnection
import java.net.URL

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // ✅ Allow network call on main thread (simple setup)
        StrictMode.setThreadPolicy(
            StrictMode.ThreadPolicy.Builder().permitAll().build()
        )

        // ✅ Setup Spinner (Location Dropdown)
        val locationSpinner = findViewById<Spinner>(R.id.spinner_location)
        val adapter = ArrayAdapter.createFromResource(
            this,
            R.array.location_array,
            android.R.layout.simple_spinner_item
        )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        locationSpinner.adapter = adapter

        // ✅ Setup login button click
        val loginBtn = findViewById<Button>(R.id.btn_login)
        val usernameInput = findViewById<EditText>(R.id.et_username)
        val passwordInput = findViewById<EditText>(R.id.et_password)

        loginBtn.setOnClickListener {
            val username = usernameInput.text.toString().trim()
            val password = passwordInput.text.toString().trim()
            val location = locationSpinner.selectedItem.toString().lowercase()

            if (username.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Please enter all fields", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val apiUrl = "https://nit3213api.onrender.com/$location/auth"

            try {
                val url = URL(apiUrl)
                val conn = url.openConnection() as HttpURLConnection
                conn.requestMethod = "POST"
                conn.setRequestProperty("Content-Type", "application/json; charset=UTF-8")
                conn.doOutput = true

                val requestJson = JSONObject()
                requestJson.put("username", username)
                requestJson.put("password", password)

                val writer = OutputStreamWriter(conn.outputStream)
                writer.write(requestJson.toString())
                writer.flush()

                if (conn.responseCode == 200) {
                    val responseText = conn.inputStream.bufferedReader().readText()
                    val responseJson = JSONObject(responseText)
                    val keypass = responseJson.getString("keypass")

                    // ✅ Send keypass to DashboardActivity
                    val intent = Intent(this, DashboardActivity::class.java)
                    intent.putExtra("keypass", keypass)
                    startActivity(intent)
                    finish()
                } else {
                    Toast.makeText(this, "Login failed: ${conn.responseCode}", Toast.LENGTH_SHORT).show()
                }

            } catch (e: Exception) {
                Toast.makeText(this, "Error: ${e.message}", Toast.LENGTH_LONG).show()
            }
        }
    }
}
