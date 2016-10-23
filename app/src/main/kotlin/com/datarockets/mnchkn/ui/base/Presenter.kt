package com.datarockets.mnchkn.ui.base

interface Presenter<V : BaseView> {
    fun attachView(mvpView: V)
    fun detachView()
}