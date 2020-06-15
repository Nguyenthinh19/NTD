package com.example.ntd.lovecandidate;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ntd.R;
import com.example.ntd.base.BaseActivity;


public class LoveCandidateFragment extends Fragment {

    private TextView title;
    private ImageView btnBack;
    private RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_love_candidate,container,false);

        btnBack = (ImageView) view.findViewById(R.id.love_candidate_btnBack);
        recyclerView = (RecyclerView) view.findViewById(R.id.love_candidate_list);
        title = (TextView) view.findViewById(R.id.love_candidate_txtTitle);
           
        return view;
    }

}
