package com.example.chalengenchapter5.Fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.example.chalengenchapter5.R
import com.example.chalengenchapter5.databinding.FragmentUpdateBinding
import com.example.chalengenchapter5.viewmodel.ViewModelBuku

class Fragment_update : Fragment() {

    lateinit var binding: FragmentUpdateBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentUpdateBinding.inflate(layoutInflater)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnUpdate.setOnClickListener {
            requireActivity().run {
                var fetID = arguments?.getInt("update",0)
                var judul = binding.etNameBuku.text.toString()
                var img = binding.etImageBuku.text.toString()
                var dekripsi = binding.etDescBuku.text.toString()
                var tahun = binding.ettahun.text.toString()
                Log.d("infoid",fetID.toString())

                updateBuku(fetID.toString().toInt(),judul,dekripsi,img,tahun)

                Navigation.findNavController(it).navigate(R.id.action_fragment_update_to_fragment_Home)


            }
        }
    }


    fun updateBuku(id:Int ,judul: String, dekripsi: String, img:String,tahun:String){
        var viewModel = ViewModelProvider(this).get(ViewModelBuku::class.java)
        viewModel.updateApiBuku( id,judul,dekripsi,img,tahun)
        viewModel.updateLiveDataBuku().observe(viewLifecycleOwner, Observer {
            if (it != null){
                Toast.makeText(context,"update Data berhasil", Toast.LENGTH_SHORT).show()
            }
        })
    }



}