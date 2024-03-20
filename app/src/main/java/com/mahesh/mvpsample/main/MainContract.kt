package com.mahesh.mvpsample.main

import com.mahesh.mvpsample.BasePresenter

class MainContract {
    interface View {
        fun openDetailScreen()
    }

    internal interface Presenter : BasePresenter {
        fun resume(view: View?)
        fun pause()
        fun clickMeButtonClicked()
    }

    internal interface ModelInteractor
}
