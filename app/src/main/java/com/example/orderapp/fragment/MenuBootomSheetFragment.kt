package com.example.orderapp.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.orderapp.R
import com.example.orderapp.adapter.MenuAdapter
import com.example.orderapp.databinding.FragmentMenuBootomSheetBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class MenuBootomSheetFragment : BottomSheetDialogFragment() {

    private lateinit var binding: FragmentMenuBootomSheetBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMenuBootomSheetBinding.inflate(inflater,container,false)

        binding.btnBack.setOnClickListener {
            dismiss()
        }

        val menuFoodname = listOf("Burger", "Pizza", "Hotdog","Momo","Burger", "Pizza", "Hotdog","Momo")
        val menuPrice = listOf("$ 5", "$ 6", "$ 7","$ 8","$ 5", "$ 6", "$ 7","$ 8")
        val menuImages = listOf(R.drawable.burger,
            R.drawable.pizza,
            R.drawable.hotdog,
            R.drawable.momo,
            R.drawable.burger,
            R.drawable.pizza,
            R.drawable.hotdog,
            R.drawable.momo)
        val adapter = MenuAdapter(ArrayList(menuFoodname),
            ArrayList(menuImages),
            ArrayList(menuPrice),requireContext())
        binding.rvMenuBootom.layoutManager = LinearLayoutManager(requireContext())
        binding.rvMenuBootom.adapter = adapter
        return binding.root
    }

    companion object {
    }
}