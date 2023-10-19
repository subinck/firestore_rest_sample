package com.example.firestorerestapisample.domain

import com.example.firestorerestapisample.common.Resource
import com.example.firestorerestapisample.data.models.UserDetails
import com.example.firestorerestapisample.data.repository.UserRepository
import com.google.gson.Gson
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetUserUseCase @Inject constructor(private val repository: UserRepository) {

    operator fun invoke(): Flow<Resource<UserDetails>> = flow {
        try {
            emit(Resource.Loading<UserDetails>())
            val users=repository.getAllUsers().body?.toString()
            val gson = Gson()
            val myDataModel = gson.fromJson(users, UserDetails::class.java)
            emit(Resource.Success<UserDetails>(myDataModel))
        }catch (e: HttpException){
            emit(Resource.Error<UserDetails>(e.localizedMessage?:"Unexpected Error Occurred"))
        }
        catch (e: IOException){
            emit(Resource.Error<UserDetails>(e.localizedMessage?:"Unexpected Error Occurred"))
        }



    }
}