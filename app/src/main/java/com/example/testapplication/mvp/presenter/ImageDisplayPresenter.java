package com.example.testapplication.mvp.presenter;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.testapplication.R;
import com.example.testapplication.mvp.view.ImageDisplayView;

@InjectViewState
public class ImageDisplayPresenter extends MvpPresenter<ImageDisplayView> {

    private String imageUrl;

    public ImageDisplayPresenter(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
        setImage();
    }

    private void setImage() {
        getViewState().hideError();
        getViewState().showImage(imageUrl);
    }

    public void onImageLoadError(){
        getViewState().showError(R.string.parse_error, () -> setImage());
        getViewState().showDefaultImage();
    }
}
