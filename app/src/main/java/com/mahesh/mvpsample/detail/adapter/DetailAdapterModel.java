package com.mahesh.mvpsample.detail.adapter;

public class DetailAdapterModel {
    private String text;

    public DetailAdapterModel(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    @Override
    public String toString() {
        return "DetailAdapterModel{" +
                "text='" + text + '\'' +
                '}';
    }
}
