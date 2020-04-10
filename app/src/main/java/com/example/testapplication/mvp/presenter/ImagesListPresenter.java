package com.example.testapplication.mvp.presenter;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.testapplication.mvp.model.ImagesListModel;
import com.example.testapplication.mvp.view.ImagesListView;

@InjectViewState
public class ImagesListPresenter extends MvpPresenter<ImagesListView> {

    private ImagesListModel model;

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
        model = new ImagesListModel();
    }
}
