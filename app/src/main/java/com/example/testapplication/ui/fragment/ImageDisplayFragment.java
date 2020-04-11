package com.example.testapplication.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.testapplication.mvp.view.ImageDisplayView;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.example.testapplication.R;
import com.example.testapplication.description.BundleConst;
import com.example.testapplication.mvp.presenter.ImageDisplayPresenter;
import com.example.testapplication.ui.fragment.base.BaseFragment;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;


public class ImageDisplayFragment extends BaseFragment implements ImageDisplayView {

    @InjectPresenter
    ImageDisplayPresenter presenter;
    private ImageView imageView;


    @ProvidePresenter
    ImageDisplayPresenter providePresenter() {
        String imageUrl = getArguments().getString(BundleConst.IMAGE_URL);
        return new ImageDisplayPresenter(imageUrl);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_image, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        imageView = view.findViewById(R.id.fragment_image_view);
    }

    @Override
    public void showImage(String imageUrl) {
        Picasso.get()
                .load(imageUrl)
                .into(imageView, new Callback() {
                    @Override
                    public void onSuccess() {

                    }

                    @Override
                    public void onError(Exception e) {
                        presenter.onImageLoadError();
                    }
                });
    }

    @Override
    public void showDefaultImage() {
        imageView.setImageDrawable(getResources().getDrawable(R.drawable.ic_error_image));
    }
}
