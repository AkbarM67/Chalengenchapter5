package com.example.chalengenchapter5.viewmodelUser


import com.google.gson.annotations.SerializedName

data class ResponDataUserItem(
    @SerializedName("createdAt")
    val createdAt: String,
    @SerializedName("image")
    val image: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("password")
    val password: String,
    @SerializedName("username")
    val username: String
)