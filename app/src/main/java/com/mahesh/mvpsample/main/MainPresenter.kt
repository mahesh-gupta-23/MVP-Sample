package com.mahesh.mvpsample.main

class MainPresenter(private var view: MainContract.View?) : MainContract.Presenter {
    override fun create() {}
    override val isViewAvailable: Boolean
        get() = view != null

    override fun resume(view: MainContract.View?) {
        this.view = view
    }

    override fun pause() {
        view = null
    }

    override fun clickMeButtonClicked() {
        if (isViewAvailable) {
            view!!.openDetailScreen()
        }
    }
}
