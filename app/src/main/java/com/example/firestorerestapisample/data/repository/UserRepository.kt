package com.example.firestorerestapisample.data.repository

import com.example.firestorerestapisample.data.models.UserDetails
import okhttp3.Response
import okhttp3.ResponseBody

interface UserRepository {

    suspend fun addAllUsers(document:String):List<UserDetails>
    suspend fun getAllUsers():Response


}