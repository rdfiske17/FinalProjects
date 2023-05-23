package com.example.cobbersecure

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CompoundButton
import androidx.appcompat.app.AppCompatDelegate
import com.example.cobbersecure.databinding.FragmentHomeBinding
import com.example.cobbersecure.databinding.FragmentSettingsBinding
import android.content.SharedPreferences
import android.widget.SeekBar
import android.widget.Toast
import androidx.navigation.findNavController

class SettingsFragment : Fragment() {

    private var _binding: FragmentSettingsBinding? = null
    private val binding get() = _binding!!

    var nightMODE = false
    //var editor = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSettingsBinding.inflate(inflater, container, false)
        val view = binding.root

        //navigate to login
        binding.settingsLogin.setOnClickListener(){
            view.findNavController()
                .navigate(R.id.action_settingsFragment_to_loginFragment)
        }

        //set night mode
        binding.darkModeSwitch.setOnClickListener( ){
            //if night mode is on and the switch is flicked, turn off night mode
            if(binding.darkModeSwitch.isChecked){
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                nightMODE = true
            }
            //if night mode is off and the switch is flicked, turn on night mode
            else{
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                nightMODE = false
            }
        }

        binding.alarmVolumeSeekBar.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seek: SeekBar,
                                           progress: Int, fromUser: Boolean) {
                Toast.makeText(activity,"Adjusting Volume", Toast.LENGTH_SHORT).show()
            }

            override fun onStartTrackingTouch(seek: SeekBar) {
            }

            override fun onStopTrackingTouch(seek: SeekBar) {

            }
        })
        return view
    }
}