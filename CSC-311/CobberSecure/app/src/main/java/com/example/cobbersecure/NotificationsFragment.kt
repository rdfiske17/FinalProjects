package com.example.cobbersecure

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.findNavController
import com.example.cobbersecure.databinding.FragmentNotificationsBinding

class NotificationsFragment : Fragment() {
    private var _binding: FragmentNotificationsBinding? = null
    private val binding get() = _binding!! //double !! allows null values
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentNotificationsBinding.inflate(inflater, container, false)
        val view = binding.root

        binding.notif1Action.setOnClickListener() {
            //get notification type then navigate to Map or Friend Page
            view.findNavController()
                .navigate(R.id.action_notificationsFragment_to_mapFragment)
            Toast.makeText(activity,"Action Taken!",Toast.LENGTH_SHORT).show()
        }

        //repeat process for other notifications

        binding.notif1Img.setOnClickListener() {
            val friendNumber = 1
            val action = NotificationsFragmentDirections
                .actionNotificationsFragmentToEditFriendFragment(friendNumber)
            view.findNavController()
                .navigate(action)
        }
        binding.notif2Img.setOnClickListener() {
            val friendNumber = 2
            val action = NotificationsFragmentDirections
                .actionNotificationsFragmentToEditFriendFragment(friendNumber)
            view.findNavController()
                .navigate(action)
        }
        binding.notif3Img.setOnClickListener() {
            val friendNumber = 3
            val action = NotificationsFragmentDirections
                .actionNotificationsFragmentToEditFriendFragment(friendNumber)
            view.findNavController()
                .navigate(action)
        }
        binding.notif4Img.setOnClickListener() {
            val friendNumber = 4
            val action = NotificationsFragmentDirections
                .actionNotificationsFragmentToEditFriendFragment(friendNumber)
            view.findNavController()
                .navigate(action)
        }
        binding.notif5Img.setOnClickListener() {
            val friendNumber = 5
            val action = NotificationsFragmentDirections
                .actionNotificationsFragmentToEditFriendFragment(friendNumber)
            view.findNavController()
                .navigate(action)
        }

        //repeat process for other notifications

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}