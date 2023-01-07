package com.example.challengesophos.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.challengesophos.core.RetrofilHelper
import com.example.challengesophos.model.LoginClient
import com.example.challengesophos.model.LoginResponse
import kotlinx.coroutines.launch
import retrofit2.Response


class LoginViewModel : ViewModel() {
    private val _email = MutableLiveData<String>()
    val email: LiveData<String> = _email

    private val _password = MutableLiveData<String>()
    val password: LiveData<String> = _password

    fun onLoginChanged(email: String, password: String) {
        _email.value = email
        _password.value = password
    }

    private val _loginResponseVm: MutableLiveData<Response<LoginResponse>> = MutableLiveData()
    val loginApiResponse: LiveData<Response<LoginResponse>>
        get() = _loginResponseVm


    fun getLoginViewModel(email: String, password: String) =
        viewModelScope.launch {
            _loginResponseVm.value =
                RetrofilHelper.getRetrofit().create(LoginClient::class.java)
                    .doLogin(email, password)
        }


}



