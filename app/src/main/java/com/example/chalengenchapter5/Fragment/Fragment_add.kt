package com.example.chalengenchapter5.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.chalengenchapter5.R
import com.example.chalengenchapter5.databinding.FragmentAddBinding
import com.example.chalengenchapter5.viewmodel.ViewModelBuku

class Fragment_add : Fragment() {
    
    lateinit var binding : FragmentAddBinding
    lateinit var modelBuku: ViewModelBuku

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentAddBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.tvuplod.setOnClickListener {
            var name = binding.etAddNameBuku.text.toString()
            var tahun = binding.etAddTahun.text.toString()
            var desc = binding.etAddDescBuku.text.toString()
            var image = binding.etAddNImageBuku.text.toString()
            addItemData(desc,tahun,image,name)
            findNavController().navigate(R.id.action_fragment_add_to_fragment_Home)
        }
    }


    fun addItemData(desc:String,tahun:String,image:String,name:String){
        modelBuku = ViewModelProvider(this).get(ViewModelBuku::class.java)
        modelBuku.postData(desc, tahun,image,name)
        modelBuku.addLiveData().observe(viewLifecycleOwner, Observer {
            if (it != null){
                Toast.makeText(context, "add Data berhasil",Toast.LENGTH_LONG).show()
            }
        })
    }


}