package com.example.testapplication.ui.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.example.testapplication.R;
import com.example.testapplication.description.BundleConst;
import com.example.testapplication.description.LayoutId;
import com.example.testapplication.mvp.presenter.ImagesListPresenter;
import com.example.testapplication.mvp.view.ImagesListView;
import com.example.testapplication.ui.adapter.ImagesListAdapter;
import com.example.testapplication.ui.adapter.handler.ImagesListAdapterCallback;
import com.example.testapplication.ui.fragment.base.BaseFragment;

import java.util.List;

public class ImagesListFragment extends BaseFragment implements
        ImagesListView, ImagesListAdapterCallback, SwipeRefreshLayout.OnRefreshListener {

    @InjectPresenter
    ImagesListPresenter presenter;
    private SwipeRefreshLayout swipeRefreshLayout;
    private ImagesListAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_images_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        swipeRefreshLayout = view.findViewById(R.id.swipe_refresh_layout);
        swipeRefreshLayout.setOnRefreshListener(this);
        RecyclerView imagesRecyclerView = view.findViewById(R.id.images_recyclerview);
        adapter = new ImagesListAdapter(getContext(), this);
        imagesRecyclerView.setAdapter(adapter);
    }

    @Override
    public void showImages(List<String> images) {
        swipeRefreshLayout.setRefreshing(false);
        adapter.setImagesList(images);
    }

    @Override
    public void showPreviewScreen() {
        swipeRefreshLayout.setRefreshing(true);
    }

    @Override
    public void onClickImage(String url) {
        View view = getView();
        if (view == null){
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString(BundleConst.IMAGE_URL, url);
        Navigation.findNavController(view).navigate(LayoutId.IMAGE_FRAGMENT, bundle);
    }

    @Override
    public void onRefresh() {
        presenter.updateImages();
    }
}
