package com.dqs.kotlinnote.login

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import com.dqs.kotlinnote.R
import kotterknife.bindView
import java.util.*

//登录注册流程
class LoginRegistrationActivity : AppCompatActivity() {
    object cont {
        var fragments: MutableMap<String, Fragment> = HashMap()
        var Fragment: FragmentManager? = null
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_registration)
        setDefaultFragment()
        cont.Fragment = supportFragmentManager
    }



    /**
     * 设置默认显示的fragment
     */
    private fun setDefaultFragment() {
        val fragmentManager = supportFragmentManager
        val transaction = fragmentManager.beginTransaction()
        val fragment = LogOnFragment.newInstance()
        cont.fragments.put(fragment.javaClass.name, fragment)
        transaction.add(R.id.fragment, cont.fragments[fragment.javaClass.name])
        transaction.commit()
    }

    companion object {
        fun getFragment(name: String, key: String) {
            var transaction = cont.Fragment!!.beginTransaction()
            var frag: Fragment? = null

            if (!cont.fragments.containsKey(key)) {
                if (key.equals(SetupFragment.newInstance().javaClass.name)) {
                    frag = SetupFragment.newInstance()
                    cont.fragments.put(frag.javaClass.name, frag)
                } else if (key.equals(LogOnFragment.newInstance().javaClass.name)) {
                    frag = LogOnFragment.newInstance()
                    cont.fragments.put(frag.javaClass.name, frag)
                } else if (key.equals(RegisterFragment.newInstance().javaClass.name)) {
                    frag = RegisterFragment.newInstance()
                    cont.fragments.put(frag.javaClass.name, frag)
                }
            }

            if (!cont.fragments.containsKey(key)) {
                return
            }
            if (frag == null) {
                transaction.show(cont.fragments[key])
            } else {
                transaction.add(R.id.fragment, cont.fragments[key])
            }

            if (cont.fragments.containsKey(name)) {
                transaction.hide(cont.fragments[name])
            }
            transaction.commit()
        }
    }
}
