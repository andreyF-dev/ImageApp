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
import com.example.testapplication.mvp.presenter.ImagePresenter;
import com.example.testapplication.ui.fragment.base.BaseFragment;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;


public class ImageDisplayFragment extends BaseFragment implements ImageDisplayView {

    @InjectPresenter
    ImagePresenter presenter;
    private ImageView imageView;


    @ProvidePresenter
    ImagePresenter providePresenter() {
        String imageUrl = getArguments().getString(BundleConst.IMAGE_URL);
        return new ImagePresenter(imageUrl);
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
                .error(R.drawable.ic_error_image)
                .into(imageView, new Callback() {
                    @Override
                    public void onSuccess() {

                    }

                    @Override
                    public void onError(Exception e) {
                        showError(R.string.parse_error, () -> presenter.setImage());
                    }
                });
    }
}
