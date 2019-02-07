package com.mahesh.mvpsample.main;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.mahesh.mvpsample.R;
import com.mahesh.mvpsample.databinding.ActivityMainBinding;
import com.mahesh.mvpsample.detail.DetailActivity;

public class MainActivity extends AppCompatActivity implements MainContract.View {

    private ActivityMainBinding binding;
    private MainContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        presenter = new MainPresenter(this);

        binding.btnClickMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.clickMeButtonClicked();
            }
        });
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
    public void openDetailScreen() {
        startActivity(new Intent(this, DetailActivity.class));
    }
}
