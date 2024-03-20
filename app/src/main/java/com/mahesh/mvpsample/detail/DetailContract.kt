package com.mahesh.mvpsample.detail

import com.mahesh.mvpsample.BasePresenter
import com.mahesh.mvpsample.detail.adapter.DetailAdapterModel

class DetailContract {
    interface View {
        fun notifyAdapterEntityChanged()
        fun showToast(text: String?)
    }

    interface AdapterPresenter {
        fun getAdapterEntity(position: Int): DetailAdapterModel
        val adapterEntityCount: Int
        fun adapterEntityClicked(position: Int)
    }

    internal interface Presenter : BasePresenter {
        fun resume(view: View?)
        fun pause()
    }

    internal interface ModelInteractor {
        fun createAdapterEntityList(callback: () -> Unit)
        val adapterEntityList: List<DetailAdapterModel>
    }
}
