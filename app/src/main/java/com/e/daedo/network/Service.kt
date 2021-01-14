package com.e.daedo.network

import com.e.daedo.data.request.LoginBody
import com.e.daedo.data.response.StatusInfo
import okhttp3.MultipartBody
import com.e.daedo.data.response.LoginResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part

interface Service {

    //로그인
    @POST("/auth/login")

    fun login(@Body loginBody: LoginBody): Call<LoginResponse>

    //회원가입
    @Multipart
    @POST("/auth/sign-up")
    fun requestSignUp(
        //INPUT 정의
        @Part("email") email: String,
        @Part("password") password: String,
        @Part("username") userName: String,
        @Part image: MultipartBody.Part
    ): Call<StatusInfo> //OUTPUT 정의
}