package com.example.cobbersecure

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.example.cobbersecure.databinding.FragmentProfileBinding

class ProfileFragment : Fragment() {
    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!! //double !! allows null values
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        val view = binding.root

        //Notification Button Click Listener
        binding.profileNotifButton.setOnClickListener() {
            view.findNavController()
                .navigate(R.id.action_profileFragment_to_notificationsFragment)
        }

        //Friend List Button Click Listener
        binding.profileToFriendlistButton.setOnClickListener() {
            view.findNavController()
                .navigate(R.id.action_profileFragment_to_friendListFragment)
        }

        //Edit Profile Button Click Listener
        binding.profileToEditprofileButton.setOnClickListener() {
            view.findNavController()
                .navigate(R.id.action_profileFragment_to_profileEditFragment)
        }

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}