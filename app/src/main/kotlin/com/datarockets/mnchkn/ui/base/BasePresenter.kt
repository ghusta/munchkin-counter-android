package com.datarockets.mnchkn.ui.base

class BasePresenter<T : BaseView> : Presenter<T> {

    private var mBaseView: T? = null

    override fun attachView(mvpView: T) {
        mBaseView = mvpView
    }

    override fun detachView() {
        mBaseView = null
    }

    fun isViewAttached(): Boolean = mBaseView != null

    fun getView(): T? = mBaseView

    fun checkViewAttached() {
        if (!isViewAttached()) throw MvpViewNotAttachedException()
    }

    class MvpViewNotAttachedException : RuntimeException
    ("Please call Presenter.attachView(MvpView) before" + " requesting data to the Presenter")

}