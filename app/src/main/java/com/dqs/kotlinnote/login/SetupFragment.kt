package com.dqs.kotlinnote.login

import android.os.Bundle
import android.preference.PreferenceFragment
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import com.dqs.kotlinnote.R
import kotterknife.bindView
import java.util.*

/**
 *作者：Denqs on 2017/5/23.
 */
class SetupFragment : Fragment() {
    companion object {
        fun newInstance(fragConent: String): SetupFragment {
            val args = Bundle()
            args.putString("ARGS_NAVI_BTN_NAME", fragConent)
            val fragment = SetupFragment()
            fragment.arguments = args
            return fragment

        }
    }

    /*  override fun onCreate(savedInstanceState: Bundle?) {
          super.onCreate(savedInstanceState)
          addPreferencesFromResource(R.xml.preferences);
      }*/

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.fragment_setup, container, false)
        initView(v)
        return v
    }

    fun initView(v: View) {
        val log = v.findViewById(R.id.logon) as Button
        val register = v.findViewById(R.id.register) as Button
        log.setOnClickListener {
            fragmentManager.beginTransaction().addToBackStack(null).replace(R.id.fragment, LogOnFragment()).commit() }
        register.setOnClickListener {
            fragmentManager.beginTransaction().addToBackStack(null).replace(R.id.fragment, RegisterFragment()).commit() }
    }
}