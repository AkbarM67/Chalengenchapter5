package com.example.chalengenchapter5.viewmodelUser

import com.google.gson.annotations.SerializedName

data class putResponseBuku (
    @SerializedName("description")
    val deskripsi: String,
    @SerializedName("Tahun")
    val Tahun: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("image")
    val image: String,
    @SerializedName("name")
    val name: String
        )
