package com.example.hawleraeroclub.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hawleraeroclub.R;

import java.util.ArrayList;

public class GalleryAdapter extends RecyclerView.Adapter<GalleryAdapter.GalleryViewHolder> {
    Context context;
    ArrayList<Integer> images;
    LayoutInflater mInflater;
    LayoutInflater layoutInflater;

    public GalleryAdapter(Context context, ArrayList<Integer> images) {
        this.images = images;
        this.context = context;
        mInflater= LayoutInflater.from(this.context);
    }

    @NonNull
    @Override
    public GalleryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mItemView = mInflater.inflate(R.layout.galler_item_design,
                parent, false);
        return new GalleryViewHolder(mItemView);
    }

    @Override
    public void onBindViewHolder(@NonNull GalleryViewHolder holder, int position) {
        holder.galleryIV.setImageResource(images.get(position));
    }

    @Override
    public int getItemCount() {
        return images.size();
    }

    public class GalleryViewHolder extends RecyclerView.ViewHolder {
        ImageView galleryIV;

        public GalleryViewHolder(@NonNull View itemView) {
            super(itemView);
            galleryIV = itemView.findViewById(R.id.gallery_iv_item_design);
        }
    }
}
