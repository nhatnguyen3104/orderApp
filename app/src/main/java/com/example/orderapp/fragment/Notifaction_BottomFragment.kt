package com.example.orderapp.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.orderapp.R
import com.example.orderapp.adapter.NotificationAdapter
import com.example.orderapp.databinding.FragmentNotifactionBottomBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class Notifaction_BottomFragment : BottomSheetDialogFragment() {
    private lateinit var binding: FragmentNotifactionBottomBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentNotifactionBottomBinding.inflate(layoutInflater,container,false)
        val notifications = listOf("Your order has been Canceled Successfully","Order has been taken by the driver","Congrats Your Order Placed")
        val notificationImages = listOf(R.drawable.iconsad,R.drawable.iconshipping,R.drawable.icondone)
        val adapter = NotificationAdapter(
            ArrayList(notifications),ArrayList(notificationImages)
        )
        binding.rvNotifiaction.layoutManager= LinearLayoutManager(requireContext())
        binding.rvNotifiaction.adapter = adapter
        binding.btnBack.setOnClickListener {
            dismiss()
        }
        return binding.root
    }

    companion object {

    }
}