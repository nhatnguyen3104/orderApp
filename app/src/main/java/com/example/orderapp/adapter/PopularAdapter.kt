package com.example.orderapp.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.orderapp.activity.DetailActivity
import com.example.orderapp.databinding.PopularItemBinding

class PopularAdapter(private val items:List<String>,private val images:List<Int>,private val prices:List<String>, private val requireContext: Context) : RecyclerView.Adapter<PopularAdapter.PopularViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PopularAdapter.PopularViewHolder {
        return PopularViewHolder(PopularItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder:PopularAdapter.PopularViewHolder, position: Int) {
        val item=items[position]
        val image=images[position]
        val price=prices[position]
        holder.bind(item,image,price)

        holder.itemView.setOnClickListener{
            val intent = Intent(requireContext, DetailActivity::class.java)
            intent.putExtra("menuName", item)
            intent.putExtra("menuImage", image)

            requireContext.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return items.size

    }
    class PopularViewHolder(private val binding:PopularItemBinding):RecyclerView.ViewHolder(binding.root) {
        private val imageView = binding.imageView
        fun bind(item: String,image: Int,price:String) {
            binding.tvTitle.text = item
            binding.tvPrice.text = price
            imageView.setImageResource(image)
        }

    }
}