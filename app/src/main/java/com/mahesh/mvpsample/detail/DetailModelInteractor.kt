package com.mahesh.mvpsample.detail

import com.mahesh.mvpsample.detail.adapter.DetailAdapterModel

class DetailModelInteractor internal constructor() : DetailContract.ModelInteractor {
    private val adapterModelList: MutableList<DetailAdapterModel>

    init {
        adapterModelList = ArrayList()
    }

    override fun createAdapterEntityList(callback: () -> Unit) {
        adapterModelList.clear()
        for (i in 0..49) {
            adapterModelList.add(DetailAdapterModel("Dummy Text $i"))
        }
        callback.invoke()
    }

    override val adapterEntityList: List<DetailAdapterModel>
        get() = adapterModelList
}
