package com.mahesh.mvpsample.main

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.mahesh.mvpsample.R
import com.mahesh.mvpsample.databinding.ActivityMainBinding
import com.mahesh.mvpsample.detail.DetailActivity

class MainActivity : AppCompatActivity(), MainContract.View {
    private lateinit var binding: ActivityMainBinding
    private lateinit var presenter: MainContract.Presenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        presenter = MainPresenter(this)
        binding.btnClickMe.setOnClickListener { presenter.clickMeButtonClicked() }
    }

    override fun onResume() {
        super.onResume()
        presenter.resume(this)
    }

    override fun onPause() {
        presenter.pause()
        super.onPause()
    }

    override fun openDetailScreen() {
        startActivity(Intent(this, DetailActivity::class.java))
    }
}
