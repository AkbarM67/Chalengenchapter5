package com.example.chalengenchapter5.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.chalengenchapter5.network.RetrofitClient
import com.example.chalengenchapter5.viewmodelUser.DataBuku
import com.example.chalengenchapter5.viewmodelUser.ResponDataBukuItem
import com.example.chalengenchapter5.viewmodelUser.putResponseBuku
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ViewModelBuku: ViewModel() {

    lateinit var allData : MutableLiveData<List<ResponDataBukuItem>>
    lateinit var updatebuku : MutableLiveData<List<putResponseBuku>?>
    lateinit var deleteBuku: MutableLiveData<Int?>
    lateinit var postBuku: MutableLiveData<ResponDataBukuItem>

    init {
        allData = MutableLiveData()
        updatebuku= MutableLiveData()
        deleteBuku= MutableLiveData()
        postBuku= MutableLiveData()
    }

    fun allLiveData() : MutableLiveData<List<ResponDataBukuItem>>{
        return allData
    }

    fun updateLiveDataBuku() : MutableLiveData<List<putResponseBuku>?> {
        return updatebuku
    }

    fun deleteLiveDataBuku() : MutableLiveData<Int?> {
        return deleteBuku
    }

    fun addLiveData(): MutableLiveData<ResponDataBukuItem>{
        return postBuku
    }

    fun callAllData(){
        RetrofitClient.instance.getAll()
            .enqueue(object : Callback<List<ResponDataBukuItem>>{
                override fun onResponse(
                    call: Call<List<ResponDataBukuItem>>,
                    response: Response<List<ResponDataBukuItem>>
                ) {
                    if (response.isSuccessful){
                        allData.postValue(response.body())
                    }else{
                        error(response.message())
                    }
                }

                override fun onFailure(call: Call<List<ResponDataBukuItem>>, t: Throwable) {
                    allData.postValue(error(t.message.toString()))
                }

            })
    }

    fun updateApiBuku(id: Int, judul: String, deskripsi: String,img: String,tahun: String){
        RetrofitClient.instance.updateBuku(id , DataBuku(id, judul,deskripsi,img,tahun))
            .enqueue(object : Callback<List<putResponseBuku>>{
                override fun onResponse(
                    call: Call<List<putResponseBuku>>,
                    response: Response<List<putResponseBuku>>
                ) {
                    if (response.isSuccessful){
                        updatebuku.postValue(response.body())
                    }else{
                        updatebuku.postValue(null)
                    }
                }

                override fun onFailure(call: Call<List<putResponseBuku>>, t: Throwable) {
                    updatebuku.postValue(null)
                }

            })

    }



    fun deleteApiBuku(id: Int){
        RetrofitClient.instance.deleteBuku(id)
            .enqueue(object : Callback<Int>{
                override fun onResponse(call: Call<Int>, response: Response<Int>) {
                    if (response.isSuccessful){
                        deleteBuku.postValue(response.body())
                    }else{
                        Log.i("Detele", "onResponse: ")
                    }
                }

                override fun onFailure(call: Call<Int>, t: Throwable) {
                    deleteBuku.postValue(null)
                }

            })
    }

    fun postData(deskripsi: String, judul: String, img: String,tahun: String){
        RetrofitClient.instance.addData(ResponDataBukuItem(null,deskripsi,"",img,tahun,judul))
            .enqueue(object : Callback<ResponDataBukuItem>{
                override fun onResponse(
                    call: Call<ResponDataBukuItem>,
                    response: Response<ResponDataBukuItem>
                ) {
                    if (response.isSuccessful){
                        postBuku.postValue(response.body())
                    }else{
                        //error(response.message())
                        Log.d("onResponse", "onResponse: ${response.body()}")
                    }
                }

                override fun onFailure(call: Call<ResponDataBukuItem>, t: Throwable) {
                    postBuku.postValue(error(t.message.toString()))
                }

            })
    }


}


