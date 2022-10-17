package com.example.chalengenchapter5.network

import com.example.chalengenchapter5.viewmodelUser.DataBuku
import com.example.chalengenchapter5.viewmodelUser.ResponDataBukuItem
import com.example.chalengenchapter5.viewmodelUser.ResponDataUserItem
import com.example.chalengenchapter5.viewmodelUser.putResponseBuku
import retrofit2.Call
import retrofit2.http.*

interface RetrofitService {

    @GET("buku")
    fun getAll() : Call<List<ResponDataBukuItem>>

    @POST("buku")
    fun addData(@Body Buku : ResponDataBukuItem) : Call<ResponDataBukuItem>

    @GET("user")
    fun getAllUser() : Call<List<ResponDataUserItem>>

    @POST("user")
    fun postUser(@Body user : ResponDataUserItem) : Call<ResponDataUserItem>

    @PUT("buku/{id}")
    fun updateBuku(@Path("id") id: Int, @Body request: DataBuku) : Call<List<putResponseBuku>>

    @DELETE("buku/{id}")
    fun deleteBuku(@Path("id") id : Int) : Call<Int>
}