package com.example.chalengenchapter5.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.bumptech.glide.Glide
import com.example.chalengenchapter5.R
import com.example.chalengenchapter5.databinding.FragmentDetailBinding

class Fragment_detail : Fragment() {

    lateinit var binding: FragmentDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
       binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var judul = arguments?.getString("judul")
        var date = arguments?.getString("date")
        var deskripsi = arguments?.getString("dekripsi")
        var gambar = arguments?.getString("gambar")
        var id = arguments?.getInt("id")

        Glide.with(this).load(gambar).into(binding.tvgambar)
        binding.tvjudul.text = judul
        binding.tvtahun.text = date
        binding.tvdekt.text = deskripsi


        binding.btnEdit.setOnClickListener {
            val bundle = Bundle()
            bundle.putInt("update",id!!.toInt())
            Navigation.findNavController(it).navigate(R.id.action_fragment_detail_to_fragment_update, bundle)
        }

        binding.btnDelete.setOnClickListener {
            val bundle = Bundle()
            bundle.putInt("delete",id!!.toInt())
            Navigation.findNavController(it).navigate(R.id.action_fragment_detail_to_fragment_delete_dialog,bundle)
        }

        binding.Btnback.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_fragment_detail_to_fragment_home)
        }
    }
}