package com.dqs.kotlinnote.login

import android.support.v7.widget.Toolbar
import android.widget.Button
import android.widget.TextView
import com.dqs.kotlinnote.R
import com.dqs.kotlinnote.base.BaseFragment

/**
 *作者：Denqs on 2017/5/23.
 */
class LogOnFragment : BaseFragment() {
    override fun layoutRes(): Int {
        return R.layout.fragment_logon
    }

    companion object {
        fun newInstance(): LogOnFragment {
            val fragment = LogOnFragment()
            return fragment

        }
    }

    override fun onStart() {
        super.onStart()
        val login = findView<Button>(R.id.btn_login)
        login!!.setOnClickListener {
            //登陆
        }

        val register = findView<Button>(R.id.btn_register)
        register!!.setOnClickListener {
            //注册
            LoginRegistrationActivity.getFragment(this.javaClass.name, RegisterFragment.newInstance().javaClass.name)
        }
        val password = findView<TextView>(R.id.tv_forget_password)
        password!!.setOnClickListener {
            //注册
            LoginRegistrationActivity.getFragment(this.javaClass.name, SetupFragment.newInstance().javaClass.name)
        }
    }

    override fun initToolBar(toolbar: Toolbar, tv_title: TextView) {
        super.initToolBar(toolbar, tv_title)
        toolbar.navigationIcon = null
        tv_title.text = "登陆"
    }


}