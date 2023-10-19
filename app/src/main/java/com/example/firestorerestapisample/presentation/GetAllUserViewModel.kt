package com.example.firestorerestapisample.presentation

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.firestorerestapisample.common.Resource
import com.example.firestorerestapisample.data.models.UserDetails
import com.example.firestorerestapisample.domain.GetUserUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class GetAllUserViewModel @Inject constructor(
    val userUseCase: GetUserUseCase
):ViewModel() {

    private val _state= mutableStateOf(GetUserState())
    val state: State<GetUserState> =_state

    init {

        getAllUsers()
    }

    private fun getAllUsers(){
        userUseCase.invoke().onEach {result->
            when(result){
                is Resource.Success->{
                    _state.value= GetUserState(data = result.data?: UserDetails())
                }
                is Resource.Error->{
                    _state.value=GetUserState(error = result.message?:"Error Occurred")
                }
                is Resource.Loading->{
                    _state.value= GetUserState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}