package com.example.nit3213finalapp_s8138209

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TopicAdapter(private val topicList: List<TopicItem>) :
    RecyclerView.Adapter<TopicAdapter.TopicViewHolder>() {

    class TopicViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val titleText: TextView = itemView.findViewById(R.id.topic_title)
        val subtitleText: TextView = itemView.findViewById(R.id.topic_subtitle)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopicViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_topic, parent, false)
        return TopicViewHolder(view)
    }

    override fun onBindViewHolder(holder: TopicViewHolder, position: Int) {
        val item = topicList[position]
        val data = item.data

        // ✅ Show first two fields as title and subtitle
        val keys = data.keys.toList()
        holder.titleText.text = data[keys.getOrNull(0)] ?: ""
        holder.subtitleText.text = data[keys.getOrNull(1)] ?: ""

        // ✅ Send all data to detail screen
        holder.itemView.setOnClickListener {
            val context = holder.itemView.context
            val intent = Intent(context, DetailActivity::class.java)
            for ((key, value) in data) {
                intent.putExtra(key, value)
            }
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int = topicList.size
}
