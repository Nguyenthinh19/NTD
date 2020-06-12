package com.example.ntd.home.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ntd.R;
import com.example.ntd.home.ui.flingswipe.SwipeFlingAdapterView;
import com.github.ybq.android.spinkit.SpinKitView;

public class HomeFragment extends Fragment {

    private View view;
    private SwipeFlingAdapterView swipeFlingAdapterView;
    private SpinKitView mSpinKitView;
    private View noMoreView;
    private View noCardView;
    private View errorView;
    private View mCardAction;
    private TextView mTextNew;
    private ImageView mAvatar;
    private FrameLayout btnProgram;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_home, container, false);
        findView();
        return view;
    }

    private void findView() {
        mAvatar = (ImageView) view.findViewById(R.id.imageView_home_top_menu);
        noMoreView = view.findViewById(R.id.home_no_more_card);
        noCardView = view.findViewById(R.id.home_no_card);
        errorView = view.findViewById(R.id.home_no_connect);
        mCardAction = view.findViewById(R.id.layout_list_action);
        mSpinKitView = (SpinKitView) view.findViewById(R.id.spin_kit);
        swipeFlingAdapterView = (SwipeFlingAdapterView) view.findViewById(R.id.swipecard);

    }
}
