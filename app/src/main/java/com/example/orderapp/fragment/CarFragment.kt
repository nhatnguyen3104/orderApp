package com.example.orderapp.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.orderapp.R
import com.example.orderapp.activity.PayOutActivity
import com.example.orderapp.adapter.CartAdapter
import com.example.orderapp.adapter.PopularAdapter
import com.example.orderapp.databinding.FragmentCarBinding

class CarFragment : Fragment() {

    private lateinit var binding: FragmentCarBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCarBinding.inflate(inflater,container,false)

        //listItem
        val cartFoodname = listOf("Burger", "Pizza", "Hotdog","Momo")
        val cartPrice = listOf("$5", "$6", "$7","$8")
        val cartImages = listOf(R.drawable.burger,
            R.drawable.pizza,
            R.drawable.hotdog,
            R.drawable.momo)
        val adapter = CartAdapter(ArrayList(cartImages),
                                    ArrayList(cartFoodname),
                                    ArrayList(cartPrice))
        binding.rvCart.layoutManager = LinearLayoutManager(requireContext())
        binding.rvCart.adapter = adapter

        binding.btnProceed.setOnClickListener {
            val intent = Intent(requireContext(), PayOutActivity::class.java)
            startActivity(intent)
        }

        return binding.root
    }

    companion object {

    }
}