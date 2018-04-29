package io.indexpath.kotlinmvvmlogin.ViewModel

import android.arch.lifecycle.ViewModel
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import io.indexpath.kotlinmvvmlogin.Interface.LoginResultCallBacks
import io.indexpath.kotlinmvvmlogin.Model.User

class LoginViewModel (private val listener: LoginResultCallBacks) : ViewModel() {
    private val user:User

    init {
        this.user = User("", "")
    }

    //
    val emailTextWatcher:TextWatcher
        get() = object:TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                user.setEmail(s.toString())
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }

        }


    //
    val passwordTextWatcher:TextWatcher
        get() = object:TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                user.setPasseord(s.toString())
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }

        }


    // 로그인 클릭
    fun onLoginClicked(v: View) {
        if (user.isDataValid)
            listener.onSuccess("Login Success")
        else
            listener.onError("Login error")
    }
}