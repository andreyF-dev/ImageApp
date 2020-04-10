package com.example.testapplication.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.testapplication.R;
import com.example.testapplication.description.BundleConst;
import com.example.testapplication.ui.fragment.base.BaseFragment;
import com.squareup.picasso.Picasso;


public class ImageFragment extends BaseFragment {

    private ImageView imageView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_image, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        imageView = view.findViewById(R.id.fragment_image_view);
        setImageView(getArguments().getString(BundleConst.IMAGE_URL));
    }

    private void setImageView(String imageUrl) {
        Picasso.get()
                .load(imageUrl)
                .into(imageView);
    }
}
