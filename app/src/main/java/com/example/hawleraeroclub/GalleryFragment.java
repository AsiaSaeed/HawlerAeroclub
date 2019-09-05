package com.example.hawleraeroclub;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hawleraeroclub.Adapter.GalleryAdapter;

import java.util.ArrayList;

public class GalleryFragment extends Fragment {
    ArrayList<Integer> images;
    Context context;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_gallery, container, false);
        RecyclerView recyclerView=view.findViewById(R.id.gallery_rv);
        recyclerView.setAdapter(new GalleryAdapter(context,images));
        recyclerView.setLayoutManager(new GridLayoutManager(context,3));

        return view;
    }

    public GalleryFragment(ArrayList<Integer> images, Context context) {
        this.images=images;
        this.context=context;
    }

}
