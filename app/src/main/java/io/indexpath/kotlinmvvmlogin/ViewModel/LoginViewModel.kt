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

        var loginCode : Int = user.isDataValid()

        if (loginCode == 0)
            listener.onError("이메일을 입력하세요.")
        else if (loginCode == 1)
            listener.onError("올바른 이메일이 아닙니다.")
        else if (loginCode == 2)
            listener.onError("패스워드는 6글자 이상이어야 합니다.")
        else
            listener.onSuccess("로그인 성공")
    }
}