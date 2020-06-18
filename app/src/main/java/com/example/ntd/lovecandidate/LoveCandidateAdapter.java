package com.example.ntd.lovecandidate;

import android.content.Context;
import android.text.Html;
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
import com.example.ntd.base.BaseActivity;
import com.example.ntd.objects.Candidate;
import com.nostra13.universalimageloader.utils.L;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class LoveCandidateAdapter extends RecyclerSwipeAdapter<RecyclerView.ViewHolder> {

    private ArrayList<Candidate> mList;
    private BaseActivity mContext;
    private LoveCandidateInterface.Listener mListener;
    private LoveCandidateInterface.Datasource mDatasoure;
    LayoutInflater inflater;

    public LoveCandidateAdapter(ArrayList<Candidate> list, BaseActivity mContext, LoveCandidateInterface.Listener mListener, LoveCandidateInterface.Datasource mDatasoure) {
        this.mList = list;
        this.mContext = mContext;
        this.mListener = mListener;
        this.mDatasoure = mDatasoure;
        inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        setHasStableIds(true);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_skip_candidate,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder viewHolder, int i) {
        try {
            build((MyViewHolder) viewHolder, i);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void build(final LoveCandidateAdapter.MyViewHolder viewHolder, final int i) {
        mItemManger.bindView(viewHolder.itemView,i);
        final Candidate candidate = mList.get(i);
        viewHolder.lnAction1.setVisibility(View.VISIBLE);
        viewHolder.lnAction2.setVisibility(View.VISIBLE);
        viewHolder.lnAction3.setVisibility(View.VISIBLE);
        viewHolder.txtAction1.setText("Giới thiệu việc");
        viewHolder.txtAction2.setText("Mời chat");
        viewHolder.txtAction3.setText("Xóa");
        viewHolder.imgAction1.setImageDrawable(mContext.getResources().getDrawable(R.drawable.ic_action_ic_gioithieuviec));
        viewHolder.imgAction2.setImageDrawable(mContext.getResources().getDrawable(R.drawable.ic_action_action_chat));
        viewHolder.imgAction3.setImageDrawable(mContext.getResources().getDrawable(R.drawable.ic_action_action_xoa));
        try {
            if (candidate.getName() == null) {
                viewHolder.txtName.setText("...");
            } else {
                viewHolder.txtName.setText(candidate.getName());
            }
        } catch ( Exception e) {
            e.printStackTrace();
        }
        try {
            if (candidate.getNo_job_history().equals("0")){
                if (candidate.getJob_history().isEmpty() || candidate.getJob_history().size() == 0) {
                    try {
                        if (!candidate.getEducation().isEmpty()){
                            String truong = candidate.getEducation().get(0).getSchool_name();
                            String khoa = candidate.getEducation().get(0).getSpecialization();
                            if (candidate.getEducation().get(0).getIs_current().equals("0")) {
                                String html = "<b><font color=\"#333333\">" + mContext.getString(R.string.tunghoc) + "</font></b><font color=\"#343434\"> "
                                        + khoa + "</font><br><b><font color=\"#343434\">" + mContext.getString(R.string.tai) + "</font></b><font color=\"#343434\"> " + truong + "</font>";
                                viewHolder.txtHistory.setText(Html.fromHtml(html));
                            } else {
                                String html = "<b><font color=\"#333333\">" + mContext.getString(R.string.danghoc) + "</font></b><font color=\"#343434\"> "
                                        + khoa + "</font><br><b><font color=\"#343434\">" + mContext.getString(R.string.tai) + "</font></b><font color=\"#343434\"> " + truong + "</font>";
                                viewHolder.txtHistory.setText(Html.fromHtml(html));
                            }
                        }else {
                            viewHolder.txtHistory.setText("...");
                        }
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                } else {
                    try {
                        String company =candidate.getJob_history().get(0).getJob_company();
                        String vitri = candidate.getJob_history().get(0).getCandidate_job_detail().get(0).getJob_title();
                        if (candidate.getJob_history().get(0).getIs_current().equals("1")) {
                            String html = "<b><font color=\"#333333\">" + mContext.getString(R.string.danglam) + "</font></b><font color=\"#343434\"> " + vitri + "</font><br><b><font color=\"#343434\">" + mContext.getString(R.string.tai) + "</font></b><font color=\"#343434\"> " + company + "</font>";
                            viewHolder.txtHistory.setText(Html.fromHtml(html));
                        } else {
                            String html = "<b><font color=\"#333333\">" + mContext.getString(R.string.tunglam) + "</font></b><font color=\"#343434\"> "
                                    + vitri + "</font><br><b><font color=\"#343434\">" + mContext.getString(R.string.tai) + "</font></b><font color=\"#343434\"> " + company + "</font>";
                            viewHolder.txtHistory.setText(Html.fromHtml(html));
                        }
                    }catch (Exception e){
                        viewHolder.txtHistory.setText("...");
                        e.printStackTrace();
                    }
                }
            }else if(candidate.getNo_job_history().equals("1")){
                viewHolder.txtHistory.setText(mContext.getString(R.string.preview_profile_no_current_job_html));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            if (candidate.getMin_expect_salary()== null ||
                    candidate.getMax_expect_salary()== null) {
                viewHolder.txtLuong.setText("...");
            } else {
                viewHolder.txtLuong.setText(candidate.getMin_expect_salary() + "-" + candidate.getMax_expect_salary() + " " + mContext.getString(R.string.trieuVND));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            if (candidate.getAvatar() == null) {
                viewHolder.imgAvatar.setImageDrawable(mContext.getResources().getDrawable(R.drawable.ic_avatar));
            } else {
                mContext.imageLoader.displayImage(candidate.getAvatar(), viewHolder.imgAvatar, mContext.avatarDisplayImageOptions);
            }
        } catch (Exception e) {

        }

        try {
            viewHolder.rlLeftLayout2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    try {
                        if (viewHolder.itemJob.getOpenStatus() == SwipeLayout.Status.Open) {
                            viewHolder.itemJob.close();
                        } else {
                            viewHolder.itemJob.open();
                        }
                    } catch (Exception e) {
                        //HopeLog.e(e);
                    }
                }
            });
            viewHolder.rlLeftLayout1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mDatasoure.setCandidateid(candidate.getCandidate_id());
                    mDatasoure.setPosition(i);
                    mListener.onItemCLick();
                }
            });

            viewHolder.lnAction3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mDatasoure.setCandidateid(candidate.getCandidate_id());
                    mDatasoure.setPosition(i);
                    mListener.onXoaClick();
                }
            });

            viewHolder.lnAction2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mDatasoure.setCandidateid(candidate.getCandidate_id());
                    mDatasoure.setCandidateName(candidate.getName());
                    mListener.onMoiChatClick();
                }
            });

            viewHolder.lnAction1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mDatasoure.setCandidateid(candidate.getCandidate_id());
                    mDatasoure.setPosition(i);
                    mListener.onGioithieuClick();
                }
            });
        } catch (Exception e) {

        }

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

    @Override
    public int getItemCount() {
        return mList.size() + 1;
    }

    @Override
    public int getSwipeLayoutResourceId(int position) {
        return R.id.item_skip_candidate_swipeLayout;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


}
