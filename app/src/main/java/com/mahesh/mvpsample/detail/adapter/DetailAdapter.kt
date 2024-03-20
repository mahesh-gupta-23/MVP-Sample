package com.mahesh.mvpsample.detail.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.mahesh.mvpsample.R
import com.mahesh.mvpsample.databinding.DetailRowBinding
import com.mahesh.mvpsample.detail.DetailContract.AdapterPresenter
import com.mahesh.mvpsample.detail.adapter.DetailAdapter.MyViewHolder

class DetailAdapter(private val context: Context, private val presenter: AdapterPresenter) :
    RecyclerView.Adapter<MyViewHolder>() {
    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): MyViewHolder {
        val binding = DataBindingUtil.inflate<DetailRowBinding>(
            LayoutInflater.from(
                context
            ),
            R.layout.detail_row, viewGroup, false
        )
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(viewHolder: MyViewHolder, position: Int) {
        viewHolder.bind(presenter.getAdapterEntity(position))
    }

    override fun getItemCount(): Int {
        return presenter.adapterEntityCount
    }

    inner class MyViewHolder(private val binding: DetailRowBinding) :
        RecyclerView.ViewHolder(
            binding.root
        ) {
        init {
            binding.tvText.setOnClickListener {
                val position = adapterPosition
                if (position >= 0) presenter.adapterEntityClicked(position)
            }
        }

        fun bind(current: DetailAdapterModel) {
            binding.tvText.text = current.text
        }
    }
}
