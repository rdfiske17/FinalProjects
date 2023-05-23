package com.example.cobbersecure

import android.media.MediaPlayer
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.cobbersecure.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!! //double !! allows null values
    private lateinit var mediaPlayer : MediaPlayer
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val view = binding.root

        //Notification Button Click Listener
        binding.homeNotifications.setOnClickListener() {
            view.findNavController()
                .navigate(R.id.action_homeFragment_to_notificationsFragment)
        }
        //Settings Button Click Listener
        binding.homeSettings.setOnClickListener() {
            view.findNavController()
                .navigate(R.id.action_homeFragment_to_settingsFragment)
        }
        //Friend List Button Click Listener
        binding.homeFriendpage.setOnClickListener() {
            findNavController()
                .navigate(R.id.action_homeFragment_to_friendListFragment)
        }

        //Profile Button Click Listener
        binding.homeProfile.setOnClickListener() {
            findNavController()
                .navigate(R.id.action_homeFragment_to_profileFragment)
        }

        //Map Button Click Listener
        binding.homeMap.setOnClickListener() {
            findNavController()
                .navigate(R.id.action_homeFragment_to_mapFragment)
        }
        
        //Settings Button Click Listener
        binding.homeSettings.setOnClickListener() {
            view.findNavController()
                .navigate(R.id.action_homeFragment_to_settingsFragment)
        }
        
        //Report Incident Button Click Listener
        binding.homeReportIncident.setOnClickListener() {
            view.findNavController()
                .navigate(R.id.action_homeFragment_to_reportIncidentFragment)
        }
        //Resources Button Click Listener
        binding.homeResources.setOnClickListener() {
            view.findNavController()
                .navigate(R.id.action_homeFragment_to_resourcesFragment2)
        }

        //Login Button Click Listener
        binding.homeLogin.setOnClickListener() {
            view.findNavController()
                .navigate(R.id.action_homeFragment_to_loginFragment)
        }

        binding.home911.setOnClickListener() {
            Toast.makeText(activity,"This would pop up a confirmation dialog box before calling 911", Toast.LENGTH_SHORT).show()
        }

        binding.homeCampusSecurity.setOnClickListener() {
            Toast.makeText(activity,"This would pop up a confirmation dialog box before calling Campus Security", Toast.LENGTH_SHORT).show()
        }

        binding.homeFireDept.setOnClickListener() {
            Toast.makeText(activity,"This would pop up a confirmation dialog box before calling the Moorhead Fire Department", Toast.LENGTH_SHORT).show()
        }

        //All the code with the alarm came from this video:https://www.youtube.com/watch?v=EJfy3B63p94
        //by DBTechProjects on YouTube
        binding.homeAlarm.setOnClickListener(){
            //Creates the alarm
            if(!this::mediaPlayer.isInitialized){
                mediaPlayer = MediaPlayer.create(requireContext(), R.raw.alarm)
            }
            //If the media player is playing, then stop the alarm when someone clicks the button again
            if (mediaPlayer.isPlaying){
                mediaPlayer.pause()
                mediaPlayer.seekTo(0)
                return@setOnClickListener
            }
            //start the alarm
            mediaPlayer.start()
        }
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null

        //destroys the media player when we are done
        //if(this::mediaPlayer.isInitialized){
          //  mediaPlayer.stop()
            //mediaPlayer.release()
        //}
    }
}
