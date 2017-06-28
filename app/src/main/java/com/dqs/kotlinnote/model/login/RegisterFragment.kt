package com.dqs.kotlinnote.model.login

import android.support.v7.widget.Toolbar
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.dqs.kotlinnote.R
import com.dqs.kotlinnote.app.BaseFragment
import com.dqs.kotlinnote.model.view.IRegisterView

/**
 *作者：Denqs on 2017/5/23.
 * 注册
 */
class RegisterFragment : BaseFragment(), IRegisterView {
    override fun layoutRes(): Int {
        return R.layout.fragment_register
    }

    companion object {
        fun newInstance(): RegisterFragment {
            val fragment = RegisterFragment()
            return fragment

        }
    }

    private var mRegisterPresenter: RegisterPresenter? = null
    var et_user: EditText? = null
    var et_pwd: EditText? = null
    var bt_register: Button? = null
    override fun onStart() {
        super.onStart()
        et_user = findView<EditText>(R.id.et_user)
        et_pwd = findView<EditText>(R.id.et_pwd_01)
        bt_register = findView<Button>(R.id.btn_register)
        mRegisterPresenter = RegisterPresenter(this)
        bt_register?.setOnClickListener {
            _Register() }
    }

    fun _Register() {
        if (TextUtils.isEmpty(et_user?.text.toString()) || TextUtils.isEmpty(et_pwd?.text.toString())) {
            showToast("帐号密码不能为空")
            return
        }
        mRegisterPresenter?.saveAccount(et_user?.text.toString(), et_pwd?.text.toString())
    }

    override fun onSaveSuccess() {
        showToast("注册成功")
        LoginRegistrationActivity.getFragment(this.javaClass.name, LogOnFragment.newInstance().javaClass.name)
    }

    override fun onLoadError() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onLoadSuccess() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun initToolBar(toolbar: Toolbar, tv_title: TextView) {
        super.initToolBar(toolbar, tv_title)
        tv_title.text = "注册"
        toolbar.setNavigationOnClickListener {
            LoginRegistrationActivity.getFragment(this.javaClass.name, LogOnFragment.newInstance().javaClass.name)
        }
    }
}