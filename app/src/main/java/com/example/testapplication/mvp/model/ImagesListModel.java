package com.example.testapplication.mvp.model;

import com.example.testapplication.mvp.presenter.callback.ImagesListPresenterCallback;

import java.util.ArrayList;
import java.util.List;

public class ImagesListModel {

    private List<String> imagesList;

    public void getImages (ImagesListPresenterCallback callback){
        imagesList = new ArrayList<>();
        imagesList.add("http://fototips.ru/wp-content/uploads/2011/12/landscape_03.jpg");
        imagesList.add("http://fototips.ru/wp-content/uploads/2011/12/landscape_02.jpg");
        callback.setImagesList(imagesList);
    }
}
