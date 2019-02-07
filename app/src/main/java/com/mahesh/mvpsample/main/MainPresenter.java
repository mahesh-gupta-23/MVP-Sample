package com.mahesh.mvpsample.main;

public class MainPresenter implements MainContract.Presenter {
    private MainContract.View view;

    public MainPresenter(MainContract.View view) {
        this.view = view;
    }

    @Override
    public void create() {

    }

    @Override
    public Boolean isViewAvailable() {
        return view != null;
    }

    @Override
    public void resume(MainContract.View view) {
        this.view = view;
    }

    @Override
    public void pause() {
        view = null;
    }

    @Override
    public void clickMeButtonClicked() {
        if (isViewAvailable()) {
            view.openDetailScreen();
        }
    }
}
