package com.e.daedo.viewModel

import android.content.Context
import android.graphics.Color
import android.util.Log
import androidx.lifecycle.ViewModel
import cn.pedant.SweetAlert.SweetAlertDialog
import com.e.daedo.base.BaseViewModel
import com.e.daedo.data.request.LoginBody
import com.e.daedo.data.response.LoginResponse
import com.e.daedo.data.response.StatusInfo
import com.e.daedo.network.RetrofitClient
import com.e.daedo.network.Service
import retrofit2.*


class LoginViewModel : BaseViewModel() {
    lateinit var retrofit: Retrofit
    lateinit var myAPI : Service

    fun login(email:String, password:String){

        retrofit = RetrofitClient.getInstance()
        myAPI = retrofit.create(Service::class.java)
        myAPI.login(LoginBody(email,password))
            .enqueue(object : Callback<LoginResponse>{
                override fun onResponse(
                    call: Call<LoginResponse>,
                    response: Response<LoginResponse>
                ) {
                    Log.d("성공","성공 : ${response.code()}")
                }

                override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                    Log.d("실패","실패")
                }

            })
    }
}