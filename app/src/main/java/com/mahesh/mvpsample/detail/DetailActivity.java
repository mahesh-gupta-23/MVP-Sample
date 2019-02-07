package com.mahesh.mvpsample.detail;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.widget.Toast;

import com.mahesh.mvpsample.R;
import com.mahesh.mvpsample.databinding.ActivityDetailBinding;
import com.mahesh.mvpsample.detail.adapter.DetailAdapter;

public class DetailActivity extends AppCompatActivity implements DetailContract.View {

    private ActivityDetailBinding binding;
    private Context context;
    private DetailAdapter adapter;
    private DetailPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_detail);
        context = this;

        presenter = new DetailPresenter(this);
        adapter = new DetailAdapter(context, presenter);

        binding.rvList.setLayoutManager(new LinearLayoutManager(context));
        binding.rvList.setAdapter(adapter);

        presenter.create();
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.resume(this);
    }

    @Override
    protected void onPause() {
        presenter.pause();
        super.onPause();
    }

    @Override
    public void notifyAdapterEntityChanged() {
        adapter.notifyDataSetChanged();
    }

    @Override
    public void showToast(String text) {
        Toast.makeText(context, text, Toast.LENGTH_SHORT).show();
    }
}
