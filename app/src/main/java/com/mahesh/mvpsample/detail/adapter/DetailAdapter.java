package com.mahesh.mvpsample.detail.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mahesh.mvpsample.R;
import com.mahesh.mvpsample.databinding.DetailRowBinding;
import com.mahesh.mvpsample.detail.DetailContract;

public class DetailAdapter extends RecyclerView.Adapter<DetailAdapter.MyViewHolder> {

    private Context context;
    private DetailContract.AdapterPresenter presenter;

    public DetailAdapter(Context context, DetailContract.AdapterPresenter presenter) {
        this.context = context;
        this.presenter = presenter;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        DetailRowBinding binding = DataBindingUtil.inflate(LayoutInflater.from(context),
                R.layout.detail_row, viewGroup, false);
        return new MyViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder viewHolder, int position) {
        viewHolder.bind(presenter.getAdapterEntity(position));
    }

    @Override
    public int getItemCount() {
        return presenter.getAdapterEntityCount();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        private DetailRowBinding binding;

        MyViewHolder(DetailRowBinding binding) {
            super(binding.getRoot());
            this.binding = binding;

            binding.tvText.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();
                    if (position >= 0)
                        presenter.adapterEntityClicked(position);
                }
            });
        }

        void bind(DetailAdapterModel current) {
            binding.tvText.setText(current.getText());
        }
    }
}
