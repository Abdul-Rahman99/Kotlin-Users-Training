package com.example.myapplicationkotlin.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.myapplicationkotlin.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    //Global variables
    private val userName : String = "Abdelrahman"
    private val passWord : String = "12345"

    private lateinit var binding: FragmentLoginBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnLogin.setOnClickListener {

            if (binding.edtUsername.text.toString().isNotEmpty() && binding.edtPassword.text.toString()
                    .isNotEmpty()) {
                if (binding.edtUsername.text.toString() == userName && binding.edtPassword.text.toString() == passWord
                ) {
                    Toast.makeText(context, "Login Successful", Toast.LENGTH_SHORT).show()


                    val action = LoginFragmentDirections.actionLoginFragmentToListFragment(userName)
                    findNavController().navigate(action)

                }
            }
        }
    }
}