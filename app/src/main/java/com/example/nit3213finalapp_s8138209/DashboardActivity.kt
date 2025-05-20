package com.example.nit3213finalapp_s8138209

import android.content.Intent
import android.os.Bundle
import android.os.StrictMode
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.json.JSONObject
import java.net.HttpURLConnection
import java.net.URL

class DashboardActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        // ✅ Allow network access on main thread for this simple example
        StrictMode.setThreadPolicy(StrictMode.ThreadPolicy.Builder().permitAll().build())

        val keypass = intent.getStringExtra("keypass") ?: "unknown"
        val apiUrl = "https://nit3213api.onrender.com/dashboard/$keypass"

        val topicList = fetchTopicsFromApi(apiUrl)

        // ✅ Set up RecyclerView
        val recyclerView = findViewById<RecyclerView>(R.id.recycler_dashboard)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = TopicAdapter(topicList)

        // ✅ Logout button
        findViewById<Button>(R.id.btn_logout).setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
            finish()
        }
    }

    private fun fetchTopicsFromApi(apiUrl: String): List<TopicItem> {
        val topics = mutableListOf<TopicItem>()

        try {
            val connection = URL(apiUrl).openConnection() as HttpURLConnection
            connection.requestMethod = "GET"

            if (connection.responseCode == 200) {
                val response = connection.inputStream.bufferedReader().readText()
                val jsonObject = JSONObject(response)
                val jsonArray = jsonObject.getJSONArray("entities")

                for (i in 0 until jsonArray.length()) {
                    val itemObject = jsonArray.getJSONObject(i)
                    val map = mutableMapOf<String, String>()
                    for (key in itemObject.keys()) {
                        map[key] = itemObject.getString(key)
                    }
                    topics.add(TopicItem(data = map))
                }
            } else {
                Toast.makeText(this, "Failed to load data", Toast.LENGTH_SHORT).show()
            }
        } catch (e: Exception) {
            Toast.makeText(this, "Error: ${e.message}", Toast.LENGTH_LONG).show()
        }

        return topics
    }
}
