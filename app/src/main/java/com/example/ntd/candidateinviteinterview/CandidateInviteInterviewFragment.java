package com.example.ntd.candidateinviteinterview;

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
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.ntd.R;
import com.example.ntd.base.BaseActivity;
import com.example.ntd.objects.CandidateInviteInterviewObj;

import java.util.ArrayList;


public class CandidateInviteInterviewFragment extends Fragment {

    CandidateInviteInterviewInterface.Listener listener;
    CandidateInviteInterviewInterface.Datasource datasource;

    private RecyclerView recyclerView;
    private LinearLayout btnDatLich, btnGuiMail, btnThongbao;
    private ImageView imgBack;
    private TextView title;
    private ArrayList<CandidateInviteInterviewObj> mList;
    private CandidateInviteInterviewAdapter adapter;
    private BaseActivity baseActivity;

    public void setListener(CandidateInviteInterviewInterface.Listener listener) {
        this.listener = listener;
    }

    public void setDatasource(CandidateInviteInterviewInterface.Datasource datasource) {
        this.datasource = datasource;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_candidate_invite_interview,container,false);
        baseActivity = (BaseActivity) getActivity();
        imgBack = (ImageView) view.findViewById(R.id.phongvan_candidate_btnBack);
        title = (TextView) view.findViewById(R.id.phongvan_candidate_txtTitle);
        btnDatLich = (LinearLayout) view.findViewById(R.id.phongvan_candidate_btnDatlich);
        btnGuiMail = (LinearLayout) view.findViewById(R.id.phongvan_candidate_btnEmail);
        btnThongbao = (LinearLayout) view.findViewById(R.id.phongvan_candidate_btnThongbao);
        recyclerView = (RecyclerView) view.findViewById(R.id.phongvan_candidate_list);

        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);
        listener.onLoadCandidateInterview();
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onButtonBackClick();
            }
        });

        return view;

    }

    public void loadView() {
        if (datasource.getListInterviewCandidate().size() > 0) {
            mList = datasource.getListInterviewCandidate();
            adapter = new CandidateInviteInterviewAdapter(baseActivity,mList,listener,datasource);
            recyclerView.setAdapter(adapter);
        } else {
            mList = new ArrayList<>();
            adapter = new CandidateInviteInterviewAdapter(baseActivity,mList,listener,datasource);
            recyclerView.setAdapter(adapter);
        }
    }
    public  void deleteItem(int pos) {
        adapter.deleteItem(pos);
    }



}
