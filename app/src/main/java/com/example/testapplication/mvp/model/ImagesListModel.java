package com.example.testapplication.mvp.model;

import com.example.testapplication.mvp.presenter.callback.ImagesListPresenterCallback;
import com.example.testapplication.network.NetworkHelper;
import com.example.testapplication.network.handler.NetworkCallback;

import java.util.List;

public class ImagesListModel {

    public void getImages(final ImagesListPresenterCallback callback) {
        new NetworkHelper().downloadImages(new NetworkCallback<List<String>>() {
            @Override
            public void onSuccess(List<String> data) {
                callback.setImagesList(data);
            }

            @Override
            public void onError(int stringResId) {
                callback.onError(stringResId);
            }
        });
    }
}
