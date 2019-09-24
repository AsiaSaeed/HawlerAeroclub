package com.example.hawleraeroclub.Fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.hawleraeroclub.Activity.FullSizeImageShower;
import com.example.hawleraeroclub.Adapter.GalleryAdapter;
import com.example.hawleraeroclub.R;

public class GalleryFragment extends Fragment  {
    Context context;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_gallery, container, false);


        GridView gridView=view.findViewById(R.id.galleryGridView);
        gridView.setAdapter(new GalleryAdapter(context));
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i=new Intent(context, FullSizeImageShower.class);
                i.putExtra("id",position);
                startActivity(i);
            }
        });
        return view;
    }

    public GalleryFragment(Context context) {
        this.context = context;
    }


}
