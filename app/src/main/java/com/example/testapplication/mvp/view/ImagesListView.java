package com.example.testapplication.mvp.view;

import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;
import com.example.testapplication.mvp.view.base.BaseView;

import java.util.List;

public interface ImagesListView extends BaseView {

    @StateStrategyType(AddToEndSingleStrategy.class)
    void showImages(List<String> images);
}
