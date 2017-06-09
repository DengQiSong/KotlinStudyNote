package com.dqs.kotlinnote.login

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.dqs.kotlinnote.R

/**
 *作者：Denqs on 2017/5/23.
 */
class RegisterFragment: Fragment() {
    companion object {
        fun newInstance(): RegisterFragment {
            val fragment = RegisterFragment()
            return fragment

        }
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.fragment_register, container, false)
        val but = v.findViewById(R.id.button9) as Button
        but.setOnClickListener {
            LoginRegistrationActivity.getFragment(this.javaClass.name, LogOnFragment.newInstance().javaClass.name)
        }
        return v
    }
}