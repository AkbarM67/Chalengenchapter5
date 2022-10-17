package com.example.chalengenchapter5.Fragment

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.chalengenchapter5.R
import com.example.chalengenchapter5.databinding.FragmentPlashBinding

class Fragment_plash : Fragment() {

    lateinit var binding : FragmentPlashBinding
    lateinit var shared : SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentPlashBinding.inflate(layoutInflater)
        val view = binding.root

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

            shared = requireContext().getSharedPreferences("datauser", Context.MODE_PRIVATE)

        android.os.Handler(Looper.myLooper()!!).postDelayed({
            if(shared.getString("id","").equals("")){
                gotoLogin()
            } else {
                gotoHome()
            }
        },5000)

    }
    private fun gotoHome() {
        Navigation.findNavController(requireView()).navigate(R.id.action_fragment_plash_to_fragment_home)
    }

    private fun gotoLogin() {
        Navigation.findNavController(requireView()).navigate(R.id.action_fragment_plash_to_fragment_login)

    }
}