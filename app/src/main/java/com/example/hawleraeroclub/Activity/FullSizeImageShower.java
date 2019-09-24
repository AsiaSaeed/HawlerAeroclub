package com.example.hawleraeroclub.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import com.example.hawleraeroclub.Adapter.GalleryAdapter;
import com.example.hawleraeroclub.R;

public class FullSizeImageShower extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_size_image_shower);
        Intent i=getIntent();
        int postion=i.getExtras().getInt("id",0);
        GalleryAdapter galleryAdapter=new GalleryAdapter(this);
        ImageView imageView=(ImageView)findViewById(R.id.iv);
        imageView.setImageResource(galleryAdapter.images[postion]);
    }
}
