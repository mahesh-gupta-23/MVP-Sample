package com.mahesh.mvpsample.detail;

import com.mahesh.mvpsample.BasePresenter;
import com.mahesh.mvpsample.detail.adapter.DetailAdapterModel;

import java.util.List;

public class DetailContract {

    interface View {
        void notifyAdapterEntityChanged();

        void showToast(String text);
    }

    public interface AdapterPresenter {
        DetailAdapterModel getAdapterEntity(int position);

        int getAdapterEntityCount();

        void adapterEntityClicked(int position);
    }

    interface Presenter extends BasePresenter {

        void resume(View view);

        void pause();
    }

    interface ModelInteractor {
        void createAdapterEntityList(CreateDataCallback callback);

        List<DetailAdapterModel> getAdapterEntityList();
    }

    interface CreateDataCallback {
        void onDataCreated();
    }
}
