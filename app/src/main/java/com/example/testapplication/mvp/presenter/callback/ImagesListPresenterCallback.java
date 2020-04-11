package com.example.testapplication.mvp.presenter.callback;

import java.util.List;

public interface ImagesListPresenterCallback {

    void setImagesList(List<String> images);

    void onError(int stringResId);
}
