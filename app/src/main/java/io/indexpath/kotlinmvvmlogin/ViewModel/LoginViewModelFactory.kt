package io.indexpath.kotlinmvvmlogin.ViewModel

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import io.indexpath.kotlinmvvmlogin.Interface.LoginResultCallBacks

class LoginViewModelFactory(private val listener: LoginResultCallBacks): ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return LoginViewModel(listener) as T
    }
}