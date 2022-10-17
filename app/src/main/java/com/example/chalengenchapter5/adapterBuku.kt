package com.example.chalengenchapter5

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.chalengenchapter5.databinding.ItemListBinding
import com.example.chalengenchapter5.viewmodelUser.ResponDataBuku
import com.example.chalengenchapter5.viewmodelUser.ResponDataBukuItem
import com.example.chalengenchapter5.viewmodelUser.ResponDataUserItem
import com.example.chalengenchapter5.viewmodelUser.putResponseBuku

class adapterbuku (var itemBuku : List<ResponDataBukuItem>): RecyclerView.Adapter<adapterbuku.ViewHolder>() {
    var onEdit :((putResponseBuku)->Unit)? =null
    class ViewHolder(val binding : ItemListBinding): RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = ItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Glide.with(holder.itemView).load(itemBuku[position].image).into(holder.binding.image)
        holder.binding.name.text = itemBuku[position].judul
        holder.binding.tahun.text = itemBuku[position].tahun

        holder.binding.btnDetail.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("date", itemBuku[position].tahun.toString())
            bundle.putString("judul",itemBuku[position].judul)
            bundle.putString("gambar",itemBuku[position].image)
            bundle.putString("dekripsi",itemBuku[position].deskripsi)
            bundle.putInt("id",itemBuku[position].id.toInt())
            Navigation.findNavController(it).navigate(R.id.action_fragment_Home_to_fragment_detail,bundle)
        }
    }


    override fun getItemCount(): Int {
        return itemBuku.size
    }
    fun setData(data: ArrayList<ResponDataBukuItem>){
        this.itemBuku = data
    }
}