package com.example.orderapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.orderapp.databinding.CartItemBinding

class CartAdapter(private val images: MutableList<Int>, private val titles: MutableList<String>, private val prices: MutableList<String>) : RecyclerView.Adapter<CartAdapter.CartViewHolder>() {

    private val itemCount = IntArray(titles.size){1}
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartAdapter.CartViewHolder {
        val binding =CartItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return CartViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CartAdapter.CartViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int = titles.size
    inner class CartViewHolder(private val binding: CartItemBinding):RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int){
            binding.apply {
                val count = itemCount[position]
                imgCart.setImageResource(images[position])
                tvTitle.text = titles[position]
                tvPrice.text = prices[position]
                tvCount.text = count.toString()

                btnMinus.setOnClickListener {
                    deceaseCount(position)

                }
                btnPlus.setOnClickListener {
                    increaseCount(position)
                }
                btnDelete.setOnClickListener{
                    val itemPosition = adapterPosition
                    if(itemPosition != RecyclerView.NO_POSITION)
                    deleteCount(itemPosition)
                }

            }
        }
        fun deceaseCount(position: Int){
            if(itemCount[position] > 1){
                itemCount[position]--
                binding.tvCount.text = itemCount[position].toString()
            }
        }
        private fun increaseCount(position: Int){
            if(itemCount[position] < 10){
                itemCount[position]++
                binding.tvCount.text = itemCount[position].toString()
            }
        }
        private fun deleteCount(position: Int){
            titles.removeAt(position)
            images.removeAt(position)
            prices.removeAt(position)
            notifyItemRemoved(position)
            notifyItemRangeChanged(position, titles.size)
        }
    }
}