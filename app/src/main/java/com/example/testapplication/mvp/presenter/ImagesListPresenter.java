package com.example.testapplication.mvp.presenter;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.testapplication.mvp.model.ImagesListModel;
import com.example.testapplication.mvp.presenter.callback.ImagesListPresenterCallback;
import com.example.testapplication.mvp.view.ImagesListView;
import com.example.testapplication.mvp.view.base.handler.ErrorHandlerCallback;

import java.util.List;

@InjectViewState
public class ImagesListPresenter extends MvpPresenter<ImagesListView> {

    private ImagesListModel model;

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
        model = new ImagesListModel();
        updateImages();
    }

    public void updateImages(){
        getViewState().showPreviewScreen();
        getImages();
    }

    private void getImages(){
        model.getImages(new ImagesListPresenterCallback() {
            @Override
            public void setImagesList(List<String> images) {
                getViewState().showImages(images);
            }

            @Override
            public void onError(int stringResId) {
                getViewState().showError(stringResId, () -> updateImages());
            }
        });
    }
}
