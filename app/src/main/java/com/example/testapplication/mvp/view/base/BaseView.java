package com.example.testapplication.mvp.view.base;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndStrategy;
import com.arellomobile.mvp.viewstate.strategy.SingleStateStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;
import com.example.testapplication.mvp.view.base.handler.ErrorHandlerCallback;

public interface BaseView extends MvpView {

    @StateStrategyType(SingleStateStrategy.class)
    void showError(int stringResId, ErrorHandlerCallback callback);

    @StateStrategyType(AddToEndStrategy.class)
    void hideError();
}
