package com.example.garapp.network

import com.example.garapp.models.LoginRequest
import com.example.garapp.models.LoginResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {
    @POST("login/delivery")
    fun login(@Body request: LoginRequest): Call<LoginResponse>

    @POST("logout/delivery")
    fun logout():Call<Void>
}