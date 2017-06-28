package com.dqs.kotlinnote.model.login

import android.content.SharedPreferences
import com.dqs.kotlinnote.app.BaseApplication
import com.dqs.kotlinnote.model.view.IRegisterView
import com.dqs.kotlinnote.presenter.IRegisterPresenter


/**
 *作者：Denqs on 2017/6/28.
 */
class RegisterPresenter(val view:IRegisterView) : IRegisterPresenter {
    val sp: SharedPreferences = BaseApplication.sp
    //注册
    override fun saveAccount(user: String, passWord: String) {
        val editor=sp.edit()
        editor.putString("user",user)
        editor.putString("pwd",passWord)
        editor.commit()
        view.onSaveSuccess()
    }
    //登陆
    override fun loadAccount(user: String, passWord: String) {
        var u_user=sp.getString("user","admin")
        var u_pwd=sp.getString("pwd","123456")
        if(user==u_user&&u_pwd==passWord){
            view.onLoadSuccess()
        }else{
            view.onLoadError()
        }
    }

}