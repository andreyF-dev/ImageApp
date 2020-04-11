package com.example.testapplication.mvp.view.base;

import android.view.View;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleTagStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;
import com.example.testapplication.mvp.view.base.handler.ErrorHandlerCallback;

public interface BaseView extends MvpView {

    @StateStrategyType(value = AddToEndSingleTagStrategy.class, tag = "error")
    void showError(int stringResId, ErrorHandlerCallback callback);

    @StateStrategyType(value = AddToEndSingleTagStrategy.class, tag = "error")
    void hideError();
}
