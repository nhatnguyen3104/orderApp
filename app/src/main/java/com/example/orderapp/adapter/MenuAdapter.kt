package com.example.orderapp.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View.OnClickListener
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.orderapp.activity.DetailActivity
import com.example.orderapp.databinding.MenuItemBinding

class MenuAdapter(private val menuName:MutableList<String>,private val menuImage:MutableList<Int>,private val menuPrice:MutableList<String>, private val requireContext: Context) : RecyclerView.Adapter<MenuAdapter.MenuViewHolder>() {

    private val itemClickListener: OnClickListener? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuAdapter.MenuViewHolder {
        val binding = MenuItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MenuViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MenuAdapter.MenuViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int = menuName.size
    inner class MenuViewHolder(private val binding: MenuItemBinding):RecyclerView.ViewHolder(binding.root) {
        init {
            binding.root.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION){
                    itemClickListener?.onItemClick(position)
                }
                // setonclick listener to open details
                val intent = Intent(requireContext, DetailActivity::class.java)
                intent.putExtra("menuName", menuName.get(position))
                intent.putExtra("menuImage", menuImage.get(position))

                requireContext.startActivity(intent)
            }
        }

        fun bind(position: Int) {
            binding.apply {

                tvMenuName.text = menuName[position]
                imgItemMenu.setImageResource(menuImage[position])
                tvMenuPrice.text = menuPrice[position]


            }
        }

    }
    interface OnClickListener {
        fun onItemClick(position: Int)
    }
}


