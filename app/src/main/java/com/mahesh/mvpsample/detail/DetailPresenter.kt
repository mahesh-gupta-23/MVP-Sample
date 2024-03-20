package com.mahesh.mvpsample.detail

import com.mahesh.mvpsample.detail.DetailContract.AdapterPresenter
import com.mahesh.mvpsample.detail.adapter.DetailAdapterModel

class DetailPresenter(
    view: DetailContract.View
) : DetailContract.Presenter, AdapterPresenter {

    private var view: DetailContract.View? = view
    private val modelInteractor: DetailContract.ModelInteractor


    override val isViewAvailable: Boolean
        get() = view != null

    init {
        modelInteractor = DetailModelInteractor()
    }

    override fun getAdapterEntity(position: Int): DetailAdapterModel {
        return modelInteractor.adapterEntityList[position]
    }

    override val adapterEntityCount: Int
        get() = modelInteractor.adapterEntityList.size

    override fun resume(view: DetailContract.View?) {
        this.view = view
    }

    override fun pause() {
        view = null
    }

    override fun create() {
        modelInteractor.createAdapterEntityList {
            if (isViewAvailable){
                view?.notifyAdapterEntityChanged()
            }
        }
    }


    override fun adapterEntityClicked(position: Int) {
        if (isViewAvailable) {
            view!!.showToast("Clicked " + getAdapterEntity(position)?.text)
        }
    }
}
