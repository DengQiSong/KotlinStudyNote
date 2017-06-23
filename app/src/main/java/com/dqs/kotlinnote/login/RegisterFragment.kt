package com.dqs.kotlinnote.login

import android.support.v7.widget.Toolbar
import android.widget.Button
import android.widget.TextView
import com.dqs.kotlinnote.R
import com.dqs.kotlinnote.base.BaseFragment

/**
 *作者：Denqs on 2017/5/23.
 */
class RegisterFragment : BaseFragment() {
    override fun layoutRes(): Int {
        return R.layout.fragment_register
    }

    companion object {
        fun newInstance(): RegisterFragment {
            val fragment = RegisterFragment()
            return fragment

        }
    }

    override fun onStart() {
        super.onStart()
    }

    override fun initToolBar(toolbar: Toolbar, tv_title: TextView) {
        super.initToolBar(toolbar, tv_title)
        tv_title.text="注册"
        toolbar.setNavigationOnClickListener {
            LoginRegistrationActivity.getFragment(this.javaClass.name, LogOnFragment.newInstance().javaClass.name)
        }
    }
}