package com.example.testapplication.mvp.view.base;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleTagStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

public interface BaseView extends MvpView {

    @StateStrategyType(value = AddToEndSingleTagStrategy.class, tag = "error")
    void showError(int stringResId);

    @StateStrategyType(value = AddToEndSingleTagStrategy.class, tag = "error")
    void hideError();
}
