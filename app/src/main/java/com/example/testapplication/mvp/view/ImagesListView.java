package com.example.testapplication.mvp.view;

import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.SingleStateStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;
import com.example.testapplication.mvp.view.base.BaseView;

import java.util.List;

public interface ImagesListView extends BaseView {

    @StateStrategyType(SingleStateStrategy.class)
    void showImages(List<String> images);

    @StateStrategyType(SingleStateStrategy.class)
    void showPreviewScreen();
}
