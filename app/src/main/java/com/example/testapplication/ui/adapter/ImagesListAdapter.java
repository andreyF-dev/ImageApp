package com.example.testapplication.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.testapplication.R;
import com.example.testapplication.ui.adapter.handler.ImagesListAdapterCallback;
import com.example.testapplication.ui.holder.handler.ImageHolderCallback;
import com.example.testapplication.ui.holder.ImageHolder;

import java.util.List;

public class ImagesListAdapter extends RecyclerView.Adapter<ImageHolder> implements ImageHolderCallback {

    private List<String> imagesList;
    private Context context;
    private ImagesListAdapterCallback callback;

    public ImagesListAdapter(Context context, ImagesListAdapterCallback callback) {
        this.context = context;
        this.callback = callback;
    }

    public void setImagesList(List<String> imagesList) {
        this.imagesList = imagesList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ImageHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_image, parent, false);
        return new ImageHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageHolder holder, int position) {
        holder.onBind(imagesList.get(position), this);
    }

    @Override
    public int getItemCount() {
        if (imagesList != null) {
            return imagesList.size();
        }
        return 0;
    }

    @Override
    public void onClickImageHolder(String imageUrl) {
        callback.onClickImage(imageUrl);
    }
}
