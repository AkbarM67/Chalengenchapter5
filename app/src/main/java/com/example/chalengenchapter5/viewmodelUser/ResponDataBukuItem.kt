package com.example.chalengenchapter5.viewmodelUser


import com.google.gson.annotations.SerializedName

data class ResponDataBukuItem(
    @SerializedName("createdAt")
    val createdAt: String?,
    @SerializedName("deskripsi")
    val deskripsi: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("image")
    val image: String,
    @SerializedName("judul")
    val judul: String,
    @SerializedName("tahun")
    val tahun: String
)