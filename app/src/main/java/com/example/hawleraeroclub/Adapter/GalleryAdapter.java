package com.example.hawleraeroclub.Adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.example.hawleraeroclub.R;

public class GalleryAdapter extends BaseAdapter {
    private Context context;


    public Integer [] images={
            R.drawable.g01,R.drawable.g02,
            R.drawable.g03,R.drawable.g04,
            R.drawable.g05,R.drawable.g06,
            R.drawable.g07,R.drawable.g08,
            R.drawable.g09,R.drawable.g10,
            R.drawable.g11,R.drawable.g12,
            R.drawable.g13,R.drawable.g14,
            R.drawable.g15,R.drawable.g16
    };

    public GalleryAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public Object getItem(int position) {
        return images[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView=new ImageView(context);
        imageView.setImageResource(images[position]);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        imageView.setLayoutParams(new GridView.LayoutParams(220,240));
        return imageView;
    }
}
