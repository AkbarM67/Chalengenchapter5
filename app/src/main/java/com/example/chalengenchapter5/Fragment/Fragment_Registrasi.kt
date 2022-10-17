package com.example.chalengenchapter5.Fragment

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.chalengenchapter5.R
import com.example.chalengenchapter5.databinding.FragmentRegistrasiBinding
import com.example.chalengenchapter5.viewmodel.ViewModelUser

class Fragment_Registrasi : Fragment() {

    lateinit var binding: FragmentRegistrasiBinding
    lateinit var shared : SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentRegistrasiBinding.inflate(layoutInflater)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        shared = requireContext().getSharedPreferences("datauser", Context.MODE_PRIVATE)

        binding.btnRegistrasi.setOnClickListener {
            postUSer()
            Toast.makeText(context,"Terimakasih Anda Telah Registrasi", Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_fragment_Registrasi_to_fragment_login)
        }
        binding.btnlogin.setOnClickListener {
            findNavController().navigate(R.id.action_fragment_Registrasi_to_fragment_login)
        }
    }

    fun postUSer(){
        var Username = binding.UserName.text.toString()
        var fullName = binding.UName.text.toString()
        var pw = binding.UPassword.text.toString()
        var Upw = binding.URPassword.text.toString()

        var addDataUser = shared.edit()
        addDataUser.putString("UserName",Username)
        addDataUser.putString("UName",fullName)
        addDataUser.putString("Upassword",pw)
        addDataUser.putString("URPassword",Upw)
        addDataUser.apply()
    }
}