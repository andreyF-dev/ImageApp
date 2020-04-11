package com.example.testapplication.ui.fragment.base;

import android.view.View;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.example.testapplication.R;
import com.example.testapplication.mvp.view.base.BaseView;
import com.example.testapplication.mvp.view.base.handler.ErrorHandlerCallback;
import com.google.android.material.snackbar.Snackbar;

public class BaseFragment extends MvpAppCompatFragment implements BaseView {

    private Snackbar snackbar;

    @Override
    public void showError(int stringResId, final ErrorHandlerCallback callback) {
        snackbar = Snackbar.make(getView(), getString(stringResId), Snackbar.LENGTH_INDEFINITE);
        snackbar.setAction(R.string.retry, v -> callback.onClickRetry());
        snackbar.show();
    }

    @Override
    public void hideError() {

    }
}
