package com.dqs.kotlinnote.app

import android.os.Bundle
import android.support.annotation.IdRes
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.util.Log
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import com.dqs.kotlinnote.R


/**
 *作者：Denqs on 2017/6/22.
 */
abstract class BaseFragment : Fragment() {

    protected abstract fun layoutRes(): Int

    private var rootView: View? = null


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        if (null == rootView) {
            rootView = inflater.inflate(layoutRes(), null)
        } else {
            val parent = rootView!!.parent as ViewGroup
            parent.removeView(rootView)
        }
        val mToolBar =rootView!!.findViewById(R.id.toolbar) as Toolbar
        val tv =rootView!!.findViewById(R.id.tv_title) as TextView
        initToolBar(mToolBar,tv)
        return rootView
    }


    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    open fun initToolBar(toolbar: Toolbar, tv_title: TextView) {
        (activity as AppCompatActivity).setSupportActionBar(toolbar)
        (activity as AppCompatActivity).supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        (activity as AppCompatActivity).supportActionBar!!.setHomeButtonEnabled(true)
        (activity as AppCompatActivity).supportActionBar!!.setDisplayShowHomeEnabled(true)
        (activity as AppCompatActivity).supportActionBar!!.setDisplayShowTitleEnabled(false)
        setHasOptionsMenu(true)
    }

    fun showToast(content: String) {
        if (activity != null && !activity.isFinishing) {
            val toast = Toast.makeText(activity.applicationContext, content, Toast.LENGTH_SHORT)
            toast.setGravity(Gravity.CENTER, 0, 0)
            toast.show()
        }
    }

    fun <T : View> findView(@IdRes id: Int): T? {
        if (rootView == null) {
            Log.e(TAG, "layoutRes: null ")
            return null
        }
        @Suppress("UNCHECKED_CAST")
        return rootView!!.findViewById(id) as T
    }

    companion object {
        private val TAG = "BaseFragment"
    }
}

