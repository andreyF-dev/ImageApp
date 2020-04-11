package com.example.testapplication.ui.holder;

import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.testapplication.R;
import com.example.testapplication.ui.holder.handler.ImageHolderCallback;
import com.squareup.picasso.Picasso;

public class ImageHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

    private ImageView imageView;
    private String imageUrl;
    private ImageHolderCallback callback;

    public ImageHolder(@NonNull View itemView) {
        super(itemView);
        imageView = itemView.findViewById(R.id.item_image_view);
        itemView.setOnClickListener(this);
    }

    public void onBind(String imageUrl, ImageHolderCallback callback){
        this.imageUrl = imageUrl;
        this.callback = callback;
        setImageView(imageUrl);
    }

    private void setImageView(String imageUrl) {
        Picasso.get()
                .load(imageUrl)
                .error(R.drawable.ic_error_image)
                .into(imageView);
    }

    @Override
    public void onClick(View v) {
        callback.onClickImageHolder(imageUrl);
    }
}
