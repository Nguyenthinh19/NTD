package com.example.ntd.login.adapters;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.ntd.R;

import java.util.ArrayList;

public class ImgSlideAdapter extends PagerAdapter {
    private Context mContext;
    private ArrayList<ImgSlideObj> mList;

    public ImgSlideAdapter(Context mContext, ArrayList<ImgSlideObj> mList) {
        this.mContext = mContext;
        this.mList = mList;
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.item_slide_image,container,false);
        ImageView imageView = (ImageView)view.findViewById(R.id.image_display);
        TextView textView = (TextView) view.findViewById(R.id.image_title);
        imageView.setImageBitmap(BitmapFactory.decodeResource(mContext.getResources(),mList.get(position).getmImage(),null));
        textView.setText(mList.get(position).getmTitle());
        container.addView(view);
        return view;
    }
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
}
