package com.example.testapplication.network.handler;

public interface NetworkCallback<T> {

    void onSuccess(T data);
    void onError(int stringResId);
}
