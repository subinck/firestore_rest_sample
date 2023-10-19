package com.example.firestorerestapisample.di

import com.example.firestorerestapisample.common.Constants
import com.example.firestorerestapisample.data.remote.FireStoreApi
import com.example.firestorerestapisample.data.repository.UserRepository
import com.example.firestorerestapisample.data.repository.UserRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providesCoinApi():FireStoreApi{
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(FireStoreApi::class.java)
    }

    @Provides
    @Singleton
    fun providesUserRepository(api: FireStoreApi):UserRepository{
        return UserRepositoryImpl(api = api)
    }
}