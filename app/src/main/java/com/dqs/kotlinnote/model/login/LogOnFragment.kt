package com.dqs.kotlinnote.model.login

import android.content.Intent
import android.support.v7.widget.Toolbar
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.dqs.kotlinnote.R
import com.dqs.kotlinnote.app.BaseFragment
import com.dqs.kotlinnote.model.MainActivity
import com.dqs.kotlinnote.model.view.IRegisterView

/**
 *作者：Denqs on 2017/5/23.
 * 登录，注册
 */
class LogOnFragment : BaseFragment(), IRegisterView {

    private var mRegisterPresenter: RegisterPresenter? = null
    override fun layoutRes(): Int {
        return R.layout.fragment_logon
    }

    companion object {
        fun newInstance(): LogOnFragment {
            val fragment = LogOnFragment()
            return fragment

        }
    }

    var user: EditText? = null
    var pwd: EditText? = null
    override fun onStart() {
        super.onStart()
        mRegisterPresenter = RegisterPresenter(this)
        user = findView<EditText>(R.id.et_user)
        pwd = findView<EditText>(R.id.et_pwd)
        val login = findView<Button>(R.id.btn_login)
        login!!.setOnClickListener {
            //登陆
            _LogOn()
        }

        val register = findView<Button>(R.id.btn_register)
        register!!.setOnClickListener {
            //注册
            LoginRegistrationActivity.getFragment(this.javaClass.name, RegisterFragment.newInstance().javaClass.name)
        }
        val password = findView<TextView>(R.id.tv_forget_password)
        password!!.setOnClickListener {
            //找回密码
            LoginRegistrationActivity.getFragment(this.javaClass.name, SetupFragment.newInstance().javaClass.name)
        }
    }

    override fun initToolBar(toolbar: Toolbar, tv_title: TextView) {
        super.initToolBar(toolbar, tv_title)
        toolbar.navigationIcon = null
        tv_title.text = "登陆"
    }

    override fun onSaveSuccess() {

    }

    override fun onLoadSuccess() {
        startActivity(Intent(activity, MainActivity::class.java))
    }

    override fun onLoadError() {
        showToast("帐号或密码不正确")
    }

    fun _LogOn() {
        if (TextUtils.isEmpty(user?.text.toString()) || TextUtils.isEmpty(pwd?.text.toString())) {
            showToast("帐号密码不能为空")
            return
        }
        mRegisterPresenter?.loadAccount(user!!.text.toString(), pwd!!.text.toString())
    }


}