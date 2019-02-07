package com.mahesh.mvpsample.main;

import com.mahesh.mvpsample.BasePresenter;

public class MainContract {

    interface View {

        void openDetailScreen();
    }

    interface Presenter extends BasePresenter {
        void resume(View view);

        void pause();

        void clickMeButtonClicked();
    }

    interface ModelInteractor {

    }
}
