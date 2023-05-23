package com.example.cobbersecure

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.cobbersecure.databinding.FragmentFriendListBinding
import com.example.cobbersecure.databinding.FragmentResourcesBinding

class ResourcesFragment : Fragment() {
    private var _binding: FragmentResourcesBinding? = null
    private val binding get() = _binding!! //double !! allows null values
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?


    ): View? {
        _binding = FragmentResourcesBinding.inflate(inflater, container, false)
        val view = binding.root
        // Inflate the layout for this fragment
        binding.carrercenterButton.setOnClickListener() {
            val openURL = Intent(android.content.Intent.ACTION_VIEW)
            openURL.data = Uri.parse("https://www.concordiacollege.edu/academics/career-center/")
            startActivity(openURL)
        }

        binding.handbookButton.setOnClickListener(){
            val openURL = Intent(android.content.Intent.ACTION_VIEW)
            openURL.data = Uri.parse("https://catalog.concordiacollege.edu/academic-student-life-policies/")
            startActivity(openURL)
        }
        binding.cssButton.setOnClickListener(){
            val openURL = Intent(android.content.Intent.ACTION_VIEW)
            openURL.data = Uri.parse("https://www.concordiacollege.edu/student-life/student-success/")
            startActivity(openURL)
        }
        binding.title9Button.setOnClickListener(){
            val openURL = Intent(android.content.Intent.ACTION_VIEW)
            openURL.data = Uri.parse("https://www.concordiacollege.edu/directories/offices-departments-directory/human-resources/title-ix/")
            startActivity(openURL)
        }
        binding.cobbernetButton.setOnClickListener(){
            val openURL = Intent(android.content.Intent.ACTION_VIEW)
            openURL.data = Uri.parse("https://cobbernet.cord.edu/")
            startActivity(openURL)
        }

        return view



    }
}