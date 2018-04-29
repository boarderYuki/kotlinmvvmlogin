package io.indexpath.kotlinmvvmlogin.Model

import android.databinding.BaseObservable
import android.text.TextUtils
import android.util.Patterns

class User(private var email: String, private var password: String) : BaseObservable() {
    fun isDataValid() : Int {
        if (TextUtils.isEmpty(getEmail()))
            return 0 // 이메일 비었음
        else if (!Patterns.EMAIL_ADDRESS.matcher(getEmail()).matches())
            return 1 // 이메일 패턴이 오류
        else if (getPassword().length < 6)
            return 2 // 패스워드가 짧음
        else
            return -1 // 로그인 성공
    }

//    get() = (!TextUtils.isEmpty(getEmail()))
//            && Patterns.EMAIL_ADDRESS.matcher(getEmail()).matches()
//            && getPassword().length > 6

    fun getPassword(): String {
        return password
    }

    fun getEmail(): String? {
        return email
    }


    fun setEmail(email:String) {
        this.email = email
    }

    fun setPasseord(password: String) {
        this.password = password
    }
}