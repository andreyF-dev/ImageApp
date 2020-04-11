package com.example.testapplication.mvp.view;

import com.arellomobile.mvp.viewstate.strategy.SingleStateStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;
import com.example.testapplication.mvp.view.base.BaseView;

public interface ImageDisplayView extends BaseView {

    @StateStrategyType(SingleStateStrategy.class)
    void showImage(String imageUrl);
}
