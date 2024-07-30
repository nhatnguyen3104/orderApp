package com.example.orderapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.orderapp.databinding.BuyAgainItemBinding

class BuyAgainAdapter(private val buyAgainFoodname: ArrayList<String>,
                      private val buyAgainImage: ArrayList<Int>,
                      private val buyAgainPrice: ArrayList<String>):RecyclerView.Adapter<BuyAgainAdapter.buyAgainViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): buyAgainViewHolder {
        val binding = BuyAgainItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return buyAgainViewHolder(binding)
    }

    override fun getItemCount(): Int = buyAgainFoodname.size

    override fun onBindViewHolder(holder: buyAgainViewHolder, position: Int) {
        holder.bind(buyAgainFoodname[position],buyAgainImage[position],buyAgainPrice[position])
    }
    class buyAgainViewHolder(private val binding: BuyAgainItemBinding):RecyclerView.ViewHolder(binding.root) {
        fun bind(foodName: String, image: Int, price: String) {
            binding.tvName.text = foodName
            binding.imgBuyAgain.setImageResource(image)
            binding.tvPrice.text = price
        }

    }
}