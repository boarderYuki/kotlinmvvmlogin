package io.indexpath.kotlinmvvmlogin.Interface

interface LoginResultCallBacks {
    fun onSuccess(message: String)
    fun onError(message: String)
}