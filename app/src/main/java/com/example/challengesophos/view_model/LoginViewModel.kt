package com.example.challengesophos.view_model

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavHostController
import com.example.challengesophos.core.RetrofilHelper
import com.example.challengesophos.login.mToast
import com.example.challengesophos.model.LoginClient
import com.example.challengesophos.model.LoginResponse
import kotlinx.coroutines.Dispatchers
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

    fun doLogin(
        navigationController: NavHostController,
        loginViewModel: LoginViewModel,
        context: Context
    ) {
        viewModelScope.launch(Dispatchers.Main) {

            val response = RetrofilHelper.getRetrofit().create(LoginClient::class.java).doLogin(
                loginViewModel.email.value.toString(),
                loginViewModel.password.value.toString()
            )

            if (response.isSuccessful) {
                val loginResponse = response.body()
                if (loginResponse != null) {
                    if (loginResponse.acceso) {
                        navigationController.navigate("screenMain/${loginResponse.nombre}")
                    } else {
                        Log.d(
                            "Response",
                            "" + loginViewModel.email.value.toString() + " " + loginViewModel.password.value.toString()
                        )
                        mToast(context)
                    }
                } else {
                    Log.d("Response", "null")
                }
            } else {
                Log.d("Response", "weerr" + response.errorBody())
            }
        }

    }
}

