package com.dqs.kotlinnote.model.login

import android.support.v7.widget.Toolbar
import android.widget.TextView
import com.dqs.kotlinnote.R
import com.dqs.kotlinnote.app.BaseFragment

/**
 *作者：Denqs on 2017/5/23.
 * 密码找回
 */
class SetupFragment : BaseFragment() {
    override fun layoutRes(): Int {
        return R.layout.fragment_setup
    }

    companion object {
        fun newInstance(): SetupFragment {
            val fragment = SetupFragment()
            return fragment

        }
    }

    override fun onStart() {
        super.onStart()
    }

    override fun initToolBar(toolbar: Toolbar, tv_title: TextView) {
        super.initToolBar(toolbar, tv_title)
        tv_title.text="密码找回"
        toolbar.setNavigationOnClickListener {
            LoginRegistrationActivity.getFragment(this.javaClass.name, LogOnFragment.newInstance().javaClass.name)
        }
    }
}