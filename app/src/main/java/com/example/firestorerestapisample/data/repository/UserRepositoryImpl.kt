package com.example.firestorerestapisample.data.repository


import com.example.firestorerestapisample.data.models.UserDetails
import com.example.firestorerestapisample.data.remote.FireStoreApi
import okhttp3.Response
import okhttp3.ResponseBody
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(private val api: FireStoreApi):UserRepository  {

    override suspend fun addAllUsers(document: String): List<UserDetails> {
        return api.addUser(document)
    }

    override suspend fun getAllUsers(): Response {
        return api.getAllUser()
    }
}