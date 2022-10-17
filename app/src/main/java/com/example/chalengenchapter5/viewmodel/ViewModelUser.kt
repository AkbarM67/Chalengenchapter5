package com.example.chalengenchapter5.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.chalengenchapter5.network.RetrofitClient
import com.example.chalengenchapter5.viewmodelUser.ResponDataUserItem
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class ViewModelUser:ViewModel() {

    lateinit var addLiveDataUSer: MutableLiveData<ResponDataUserItem?>

    init {
        addLiveDataUSer = MutableLiveData()
    }

    fun postLiveDataUser() : MutableLiveData<ResponDataUserItem?> {
        return addLiveDataUSer
    }

    fun postApiUser(username: String, name: String, password:String,){
        RetrofitClient.instance.postUser(ResponDataUserItem("","","" ,name,password,username))
            .enqueue(object : retrofit2.Callback<ResponDataUserItem>{
                override fun onResponse(
                    call: Call<ResponDataUserItem>,
                    response: Response<ResponDataUserItem>
                ) {
                    if (response.isSuccessful){
                        addLiveDataUSer.postValue(response.body())
                    }else{
                        addLiveDataUSer.postValue(null)
                    }
                }

                override fun onFailure(call: Call<ResponDataUserItem>, t: Throwable) {
                    addLiveDataUSer.postValue(null)
                }

            })
    }
}