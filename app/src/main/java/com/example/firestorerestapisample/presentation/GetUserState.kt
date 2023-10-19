package com.example.firestorerestapisample.presentation

import com.example.firestorerestapisample.data.models.UserDetails

data class GetUserState(
    var isLoading:Boolean?=false,
    var data:UserDetails?=null,
    var error:String?=""
)
