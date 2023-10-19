package com.example.firestorerestapisample.data.remote

import com.example.firestorerestapisample.data.models.UserDetails
import okhttp3.Response
import okhttp3.ResponseBody
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface FireStoreApi {
    @POST("user_details/{param1}")
    suspend fun addUser(@Path("param1") param1: String,):List<UserDetails>

    @GET("user")
    suspend fun getAllUser(): Response

}