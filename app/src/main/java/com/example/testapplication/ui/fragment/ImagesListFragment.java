package com.example.testapplication.ui.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.example.testapplication.R;
import com.example.testapplication.mvp.presenter.ImagesListPresenter;
import com.example.testapplication.mvp.view.ImagesListView;
import com.example.testapplication.ui.adapter.ImagesListAdapter;
import com.example.testapplication.ui.adapter.handler.ImagesListAdapterCallback;

import java.util.List;

public class ImagesListFragment extends BaseFragment implements ImagesListView, ImagesListAdapterCallback {

    @InjectPresenter
    ImagesListPresenter presenter;
    private RecyclerView imagesRecyclerView;
    private ImagesListAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_images_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        imagesRecyclerView = view.findViewById(R.id.images_recyclerview);
        imagesRecyclerView.setLayoutManager(getLayoutManager());
        adapter = new ImagesListAdapter(getContext(), this);
        imagesRecyclerView.setAdapter(adapter);
    }

    @Override
    public void showImages(List<String> images) {
        adapter.setImagesList(images);
    }

    @Override
    public void onClickImage(String url) {
        //TODO set imageUrl
    }

    private LayoutManager getLayoutManager(){
        return new GridLayoutManager(getContext(), 2);
    }
}
