package io.indexpath.kotlinmvvmlogin.View

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import es.dmoral.toasty.Toasty
import io.indexpath.kotlinmvvmlogin.Interface.LoginResultCallBacks
import io.indexpath.kotlinmvvmlogin.R
import io.indexpath.kotlinmvvmlogin.ViewModel.LoginViewModel
import io.indexpath.kotlinmvvmlogin.ViewModel.LoginViewModelFactory
import io.indexpath.kotlinmvvmlogin.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity(), LoginResultCallBacks {
    override fun onSuccess(message: String) {
        Toasty.success(this,message, Toast.LENGTH_SHORT).show()
    }

    override fun onError(message: String) {
        Toasty.error(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val activityMainBinding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        activityMainBinding.viewModel = ViewModelProviders.of(this, LoginViewModelFactory(this)).get(LoginViewModel::class.java)

    }
}
