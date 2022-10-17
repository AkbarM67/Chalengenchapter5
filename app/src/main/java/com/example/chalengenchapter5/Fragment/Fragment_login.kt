package com.example.chalengenchapter5.Fragment

import android.content.ContentValues.TAG
import android.content.Context
import android.content.SharedPreferences
import android.nfc.Tag
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.chalengenchapter5.R
import com.example.chalengenchapter5.databinding.FragmentHomeBinding
import com.example.chalengenchapter5.databinding.FragmentLoginBinding
import com.example.chalengenchapter5.network.RetrofitClient
import com.example.chalengenchapter5.viewmodelUser.ResponDataUserItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class Fragment_login : Fragment() {
    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!
    var user: ResponDataUserItem? = null
    lateinit var dataUserShared: SharedPreferences
    var status : Boolean = false
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dataUserShared = requireActivity().getSharedPreferences("datauser", Context.MODE_PRIVATE)

        binding.btnlogin.setOnClickListener {
            if(auth(binding.editNama.text.toString(),binding.editPassword.text.toString())) {
                Toast.makeText(context, "username anda berhasil", Toast.LENGTH_SHORT).show()
                gotoHome()
            } else {
                
            }
        }
        binding.Registrasi.setOnClickListener {
            findNavController().navigate(R.id.action_fragment_login_to_fragment_Registrasi)
        }
    }

    fun auth(username : String, password : String) : Boolean{
        RetrofitClient.instance.getAllUser()
            .enqueue(object : Callback<List<ResponDataUserItem>> {
                override fun onResponse(
                    call: Call<List<ResponDataUserItem>>,
                    response: Response<List<ResponDataUserItem>>
                ) {
                    if (response.isSuccessful){
                        var responseBody = response.body()
                        if (responseBody != null) {
                            Log.d(TAG, "onResponse: ${responseBody.toString()}")
                            for (i in 0 until responseBody.size) {
                                if(responseBody[i].username.equals(username) && responseBody[i].password.equals(password)) {
                                    status = true
                                } else {
                                    status = false
                                }
                            }
                        }
                    }else{
                        Toast.makeText(context, "Failed to Load Data", Toast.LENGTH_SHORT).show()
                    }
                }

                override fun onFailure(call: Call<List<ResponDataUserItem>>, t: Throwable) {
                    Toast.makeText(context, "Something Wrong", Toast.LENGTH_SHORT).show()
                }

            })
        return status
    }
    fun gotoHome(){
       Navigation.findNavController(requireView()).navigate(R.id.action_fragment_login_to_fragment_home)
    }


}