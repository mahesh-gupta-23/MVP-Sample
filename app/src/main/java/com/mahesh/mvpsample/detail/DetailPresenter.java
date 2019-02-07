package com.mahesh.mvpsample.detail;

import com.mahesh.mvpsample.detail.adapter.DetailAdapterModel;

public class DetailPresenter implements DetailContract.Presenter, DetailContract.AdapterPresenter {

    private DetailContract.View view;
    private DetailContract.ModelInteractor modelInteractor;

    DetailPresenter(DetailContract.View view) {
        this.view = view;
        this.modelInteractor = new DetailModelInteractor();
    }

    @Override
    public DetailAdapterModel getAdapterEntity(int position) {
        return modelInteractor.getAdapterEntityList().get(position);
    }

    @Override
    public int getAdapterEntityCount() {
        return modelInteractor.getAdapterEntityList().size();
    }

    @Override
    public void resume(DetailContract.View view) {
        this.view = view;
    }

    @Override
    public void pause() {
        view = null;
    }

    @Override
    public void create() {
        modelInteractor.createAdapterEntityList(new DetailContract.CreateDataCallback() {
            @Override
            public void onDataCreated() {
                if (isViewAvailable())
                    view.notifyAdapterEntityChanged();
            }
        });
    }

    @Override
    public Boolean isViewAvailable() {
        return view != null;
    }

    @Override
    public void adapterEntityClicked(int position) {
        if (isViewAvailable()) {
            view.showToast("Clicked " + getAdapterEntity(position).getText());
        }
    }
}
