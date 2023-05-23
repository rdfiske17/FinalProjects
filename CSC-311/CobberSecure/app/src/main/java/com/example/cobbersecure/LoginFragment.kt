package com.example.cobbersecure

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.*
import androidx.navigation.findNavController
import com.example.cobbersecure.databinding.FragmentLoginBinding
import kotlinx.coroutines.launch
class LoginFragment : Fragment() {


    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!! //double !! allows null values
    private var user_id = 0
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        val view = binding.root

        //Notification Button Click Listener
        binding.loginButton.setOnClickListener() {
            var email: String = binding.usernameTextBox.text.toString()
            var password: String = binding.passwordTextBox.text.toString()
            login(email,password)
            Toast.makeText(activity,"$user_id",Toast.LENGTH_SHORT).show()
            val action = LoginFragmentDirections
                .actionLoginFragmentToProfileFragment(user_id)
            view.findNavController()
                .navigate(action)
        }
        return view
    }

    @SuppressLint("SuspiciousIndentation")
    private fun login(email: String, password: String){
        val application = requireNotNull(this.activity).application
        val dao = UserDatabase.getInstance(application).userDao()
        val launch = viewLifecycleOwner.lifecycleScope.launch {
        val user_id_query = dao.loginQuery(email, password)
        val query_user_id  = user_id_query.value
            if (query_user_id != null) {
                user_id = query_user_id
            }
            //set variable to user_id

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}