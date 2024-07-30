package com.example.orderapp.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.orderapp.R
import com.example.orderapp.adapter.BuyAgainAdapter
import com.example.orderapp.databinding.FragmentHistoryBinding

class HistoryFragment : Fragment() {

    private lateinit var binding: FragmentHistoryBinding
    private lateinit var buyAgainAdapter: BuyAgainAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHistoryBinding.inflate(layoutInflater,container,false)
        setupRecyclerView()
        return binding.root
    }
    private fun setupRecyclerView() {
        val buyAgainFoodname = arrayListOf("Burger", "Pizza", "Hotdog","Momo")
        val buyAgainImage = arrayListOf(R.drawable.burger,
                                        R.drawable.pizza,
                                        R.drawable.hotdog,
                                        R.drawable.momo)
        val buyAgainPrice = arrayListOf("$ 5", "$ 6", "$ 7","$ 8")
        buyAgainAdapter = BuyAgainAdapter(buyAgainFoodname,buyAgainImage,buyAgainPrice)
        binding.rvHistory.adapter = buyAgainAdapter
        binding.rvHistory.layoutManager = LinearLayoutManager(requireContext())
    }

    companion object {
    }
}