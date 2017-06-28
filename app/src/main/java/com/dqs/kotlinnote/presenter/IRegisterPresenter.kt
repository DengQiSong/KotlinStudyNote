package com.dqs.kotlinnote.presenter

/**
 *作者：Denqs on 2017/6/28.
 */
interface IRegisterPresenter {
    fun  saveAccount (user:String,passWord:String)
    fun  loadAccount (user:String,passWord:String)
}