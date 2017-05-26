package com.dqs.kotlinnote.login

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.dqs.kotlinnote.R

//登录注册流程
class LoginRegistrationActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_registration)
        setDefaultFragment()
    }

    /**
     * 设置默认显示的fragment
     */
    private fun setDefaultFragment() {
        val fragmentManager = supportFragmentManager
        val transaction = fragmentManager.beginTransaction()
        val fragment = SetupFragment.newInstance("设置")
        transaction.add(R.id.fragment, fragment)
        transaction.commit()
    }
}
