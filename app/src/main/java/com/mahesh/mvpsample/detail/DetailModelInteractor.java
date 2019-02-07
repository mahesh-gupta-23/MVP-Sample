package com.mahesh.mvpsample.detail;

import com.mahesh.mvpsample.detail.adapter.DetailAdapterModel;

import java.util.ArrayList;
import java.util.List;

public class DetailModelInteractor implements DetailContract.ModelInteractor {

    private List<DetailAdapterModel> adapterModelList;

    DetailModelInteractor() {
        this.adapterModelList = new ArrayList<>();
    }

    @Override
    public void createAdapterEntityList(DetailContract.CreateDataCallback callback) {
        adapterModelList.clear();
        for (int i = 0; i < 50; i++) {
            adapterModelList.add(new DetailAdapterModel("Dummy Text " + i));
        }
        callback.onDataCreated();
    }

    @Override
    public List<DetailAdapterModel> getAdapterEntityList() {
        return adapterModelList;
    }
}
