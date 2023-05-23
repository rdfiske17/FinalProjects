package com.example.cobbersecure

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.findNavController
import com.example.cobbersecure.databinding.FragmentFriendListBinding

class FriendListFragment : Fragment() {
    private var _binding: FragmentFriendListBinding? = null
    private val binding get() = _binding!! //double !! allows null values
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFriendListBinding.inflate(inflater, container, false)
        val view = binding.root


        // Click Listener takes in different friendNumber arg depending on which friend is clicked on
        binding.friend1Img.setOnClickListener() {
            val friendNumber = 1
            val action = FriendListFragmentDirections
                .actionFriendListFragmentToEditFriendFragment(friendNumber)
            view.findNavController()
                .navigate(action)
        }
        binding.friend2Img.setOnClickListener() {
            val friendNumber = 2
            val action = FriendListFragmentDirections
                .actionFriendListFragmentToEditFriendFragment(friendNumber)
            view.findNavController()
                .navigate(action)
        }
        binding.friend3Img.setOnClickListener() {
            val friendNumber = 3
            val action = FriendListFragmentDirections
                .actionFriendListFragmentToEditFriendFragment(friendNumber)
            view.findNavController()
                .navigate(action)
        }
        binding.friend4Img.setOnClickListener() {
            val friendNumber = 4
            val action = FriendListFragmentDirections
                .actionFriendListFragmentToEditFriendFragment(friendNumber)
            view.findNavController()
                .navigate(action)
        }
        binding.friend5Img.setOnClickListener() {
            val friendNumber = 5
            val action = FriendListFragmentDirections
                .actionFriendListFragmentToEditFriendFragment(friendNumber)
            view.findNavController()
                .navigate(action)
        }

        binding.friend1Ping.setOnClickListener() {
            Toast.makeText(activity,"Ping!",Toast.LENGTH_SHORT).show()
        }
        binding.friend2Ping.setOnClickListener() {
            Toast.makeText(activity,"Ping!",Toast.LENGTH_SHORT).show()
        }
        binding.friend3Ping.setOnClickListener() {
            Toast.makeText(activity,"Ping!",Toast.LENGTH_SHORT).show()
        }
        binding.friend4Ping.setOnClickListener() {
            Toast.makeText(activity,"Ping!",Toast.LENGTH_SHORT).show()
        }
        binding.friend5Ping.setOnClickListener() {
            Toast.makeText(activity,"Ping!",Toast.LENGTH_SHORT).show()
        }

        return view
    }
}