package com.example.orderapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.orderapp.databinding.NotifactionItemBinding

class NotificationAdapter(private val notificationName: ArrayList<String>,private val notificationImage: ArrayList<Int>): RecyclerView.Adapter<NotificationAdapter.NotificationViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotificationViewHolder {
        val binding: NotifactionItemBinding = NotifactionItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return NotificationViewHolder(binding)
    }

    override fun getItemCount(): Int = notificationName.size

    override fun onBindViewHolder(holder: NotificationViewHolder, position: Int) {
        holder.bind(position)
    }

    inner class NotificationViewHolder(private val binding: NotifactionItemBinding):RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int) {
            binding.apply {
                tvNotifaction.text = notificationName[position]
                imgNotifaction.setImageResource(notificationImage[position])
            }
        }

    }
}