package com.example.orderapp.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.orderapp.R
import com.example.orderapp.adapter.MenuAdapter
import com.example.orderapp.databinding.FragmentSearchBinding

class SearchFragment : Fragment() {
    private lateinit var binding: FragmentSearchBinding
    private lateinit var adapter: MenuAdapter

    private val originMenuFoodname = listOf("Burger", "Pizza", "Hotdog","Momo","Burger", "Pizza", "Hotdog","Momo")
    private val originMenuImages = listOf(R.drawable.burger,
        R.drawable.pizza,
        R.drawable.hotdog,
        R.drawable.momo,
        R.drawable.burger,
        R.drawable.pizza,
        R.drawable.hotdog,
        R.drawable.momo)
    private val orginMenuPrice = listOf("$5", "$6", "$7","$8","$5", "$6", "$7","$8")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    private val filterMenuFoodname = mutableListOf<String>()
    private val filterMenuImages = mutableListOf<Int>()
    private val filterMenuPrice = mutableListOf<String>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSearchBinding.inflate(inflater,container,false)

        adapter = MenuAdapter(filterMenuFoodname, filterMenuImages,filterMenuPrice,requireContext())
        binding.rvSearch.layoutManager = LinearLayoutManager(requireContext())
        binding.rvSearch.adapter = adapter


        //setup for search view
        setupSearchView()
        //show all menuItems
        showAllMenu()

        return binding.root
    }

    private fun showAllMenu() {
        filterMenuFoodname.clear()
        filterMenuImages.clear()
        filterMenuPrice.clear()

        filterMenuFoodname.addAll(originMenuFoodname)
        filterMenuImages.addAll(originMenuImages)
        filterMenuPrice.addAll(orginMenuPrice)

        adapter.notifyDataSetChanged()
    }

    private fun setupSearchView() {
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String): Boolean {
                filterMenuItems(query)
                return true
            }

            override fun onQueryTextChange(newText: String): Boolean {
                filterMenuItems(newText)
                return true
            }
        })

    }

    private fun filterMenuItems(query: String) {
        filterMenuFoodname.clear()
        filterMenuImages.clear()
        filterMenuPrice.clear()

        originMenuFoodname.forEachIndexed { index, foodName ->
            if(foodName.contains(query, ignoreCase = true)){
                filterMenuFoodname.add(foodName)
                filterMenuImages.add(originMenuImages[index])
                filterMenuPrice.add(orginMenuPrice[index])
            }
        }
        adapter.notifyDataSetChanged()
    }

    companion object {

    }
}