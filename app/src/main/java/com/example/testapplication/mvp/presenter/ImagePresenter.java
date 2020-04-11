package com.example.testapplication.mvp.presenter;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.testapplication.mvp.view.ImageDisplayView;

@InjectViewState
public class ImagePresenter extends MvpPresenter<ImageDisplayView> {

    private String imageUrl;

    public ImagePresenter(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
        setImage();
    }

    public void setImage() {
        getViewState().hideError();
        getViewState().showImage(imageUrl);
    }
}
