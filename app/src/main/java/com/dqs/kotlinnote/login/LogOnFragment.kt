package com.dqs.kotlinnote.login

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.dqs.kotlinnote.R
import kotterknife.bindView

/**
 *作者：Denqs on 2017/5/23.
 */
class LogOnFragment : Fragment() {
    companion object {
        fun newInstance(): LogOnFragment {
            val fragment = LogOnFragment()
            return fragment

        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.fragment_logon, container, false)
        val but = v.findViewById(R.id.button9) as Button
        but.setOnClickListener { LoginRegistrationActivity.getFragment(this.javaClass.name, SetupFragment.newInstance().javaClass.name) }
        return v
    }
}