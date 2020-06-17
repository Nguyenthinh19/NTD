package com.example.ntd.lovecandidate;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.daimajia.swipe.SwipeLayout;
import com.daimajia.swipe.adapters.RecyclerSwipeAdapter;
import com.example.ntd.R;
import com.example.ntd.objects.Candidate;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class LoveCandidateAdapter extends RecyclerSwipeAdapter<> {
    private ArrayList<Candidate> mList;
    private LoveCandidateInterface.Listener mListener;
    private LoveCandidateInterface.Datasource mDatasoure;
    LayoutInflater inflater;

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    @Override
    public int getSwipeLayoutResourceId(int position) {
        return 0;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView txtName, txtHistory,txtLuong;
        public SwipeLayout itemJob;
        public RelativeLayout rlLeftLayout1, rlLeftLayout2;
        public CircleImageView imgAvatar;
        public LinearLayout lnAction1, lnAction2, lnAction3;
        public TextView txtAction1, txtAction2, txtAction3;
        public ImageView imgAction1, imgAction2, imgAction3;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            txtName = (TextView) itemView.findViewById(R.id.skip_candidate_name);
            txtHistory = (TextView) itemView.findViewById(R.id.skip_candidate_jobhistory);
            txtLuong = (TextView) itemView.findViewById(R.id.skip_candidate_salary);
            itemJob = (SwipeLayout) itemView.findViewById(R.id.item_skip_candidate_swipeLayout);
            imgAvatar = (CircleImageView) itemView.findViewById(R.id.skip_candidate_avatar);
            rlLeftLayout1 = (RelativeLayout) itemView.findViewById(R.id.item_skip_candidateflLeftLayout1);
            rlLeftLayout2 = (RelativeLayout) itemView.findViewById(R.id.item_skip_candidateflLeftLayout2);
            lnAction1 = (LinearLayout) itemView.findViewById(R.id.item_skip_candidate_action1);
            lnAction2 = (LinearLayout) itemView.findViewById(R.id.item_skip_candidate_action2);
            lnAction3 = (LinearLayout) itemView.findViewById(R.id.item_skip_candidate_action3);
            txtAction1 = (TextView) itemView.findViewById(R.id.item_skip_candidate_txtaction1);
            txtAction2 = (TextView) itemView.findViewById(R.id.item_skip_candidate_txtaction2);
            txtAction3 = (TextView) itemView.findViewById(R.id.item_skip_candidate_txtaction3);
            imgAction1 = (ImageView) itemView.findViewById(R.id.item_skip_candidate_imgaction1);
            imgAction2 = (ImageView) itemView.findViewById(R.id.item_skip_candidate_imgaction2);
            imgAction3 = (ImageView) itemView.findViewById(R.id.item_skip_candidate_imgaction3);
        }


    }


}
