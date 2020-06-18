package com.example.ntd.lovecandidate;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ntd.R;
import com.example.ntd.base.BaseActivity;
import com.example.ntd.candidateinviteinterview.CandidateInviteInterviewInterface;
import com.example.ntd.objects.Candidate;

import java.util.ArrayList;


public class LoveCandidateFragment extends Fragment {

    private LoveCandidateInterface.Listener listener;
    private LoveCandidateInterface.Datasource datasource;
    private TextView title;
    private ImageView btnBack;
    private RecyclerView recyclerView;
    private BaseActivity baseActivity;
    private ArrayList<Candidate> mList;
    private LoveCandidateAdapter adapter;


    public void setListener(LoveCandidateInterface.Listener listener) {
        this.listener = listener;
    }

    public void setDatasource(LoveCandidateInterface.Datasource datasource) {
        this.datasource = datasource;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_love_candidate,container,false);
        baseActivity = (BaseActivity) getActivity();

        btnBack = (ImageView) view.findViewById(R.id.love_candidate_btnBack);
        recyclerView = (RecyclerView) view.findViewById(R.id.love_candidate_list);
        title = (TextView) view.findViewById(R.id.love_candidate_txtTitle);

        listener.onLoadViewFinish();

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onButtonBackClick();
            }
        });
        return view;
    }
    public void loadView() {
        try {
           // hideEditText();
            if (datasource.getListLoveCandidate().size() > 0) {
                mList = datasource.getListLoveCandidate();
                adapter = new LoveCandidateAdapter(mList, baseActivity, listener, datasource);
                recyclerView.setAdapter(adapter);
            } else {
                mList = new ArrayList<>();
                adapter = new LoveCandidateAdapter(mList, baseActivity, listener, datasource);
                recyclerView.setAdapter(adapter);
            }
        } catch (Exception e) {

        }
    }

    private void hideEditText() {
        title.setVisibility(View.VISIBLE);
        btnBack.setVisibility(View.VISIBLE);
    }
}
