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
        fun newInstance(fragConent: String): RegisterFragment {
            val args = Bundle()
            args.putString("ARGS_NAVI_BTN_NAME", fragConent)
            val fragment = RegisterFragment()
            fragment.arguments=args
            return fragment

        }
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.fragment_register, container, false)
        val but = v.findViewById(R.id.button9) as Button
        but.setOnClickListener { fragmentManager.popBackStack() }
        return v
    }
}