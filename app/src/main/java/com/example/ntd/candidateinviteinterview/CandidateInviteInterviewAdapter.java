package com.example.ntd.candidateinviteinterview;

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
import com.example.ntd.objects.CandidateInviteInterviewObj;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class CandidateInviteInterviewAdapter extends RecyclerSwipeAdapter<RecyclerView.ViewHolder> {

    private ArrayList<CandidateInviteInterviewObj> mList;
    private BaseActivity mContext;
    private CandidateInviteInterviewInterface.Listener mListener;
    private CandidateInviteInterviewInterface.Datasource mDatasource;
    LayoutInflater layoutInflater;
    private static int TYPE_ITEM = 0;
    private static int TYPE_LOADING_VIEW = 1;

    public CandidateInviteInterviewAdapter(BaseActivity context, ArrayList<CandidateInviteInterviewObj> list, CandidateInviteInterviewInterface.Listener listener, CandidateInviteInterviewInterface.Datasource datasource) {
        this.mContext = context;
        this.mList = list;
        this.mListener = listener;
        this.mDatasource = datasource;
        layoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        setHasStableIds(true);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = layoutInflater.inflate(R.layout.item_candidate_reject
        ,parent,false);
        return new MyViewHolder(view);

    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
        try {
            build( (MyViewHolder ) viewHolder,position);
        } catch (Exception e) {

        }

    }

    private void build(final CandidateInviteInterviewAdapter.MyViewHolder viewHolder, final int position) {
        mItemManger.bindView(viewHolder.itemView,position);
        final CandidateInviteInterviewObj candidate = mList.get(position);

        viewHolder.lnAction1.setVisibility(View.VISIBLE);
        viewHolder.txtAction1.setText("Gửi Email");
        viewHolder.imgAction1.setImageDrawable(mContext.getResources().getDrawable(R.drawable.ic_email));
        viewHolder.lnAction2.setVisibility(View.VISIBLE);
        viewHolder.txtAction2.setText("Đặt lịch");
        viewHolder.imgAction2.setImageDrawable(mContext.getResources().getDrawable(R.drawable.ic_calendar_w));

        viewHolder.lnAction3.setVisibility(View.VISIBLE);
        viewHolder.txtAction3.setText("Xóa");
        viewHolder.imgAction3.setImageDrawable(mContext.getResources().getDrawable(R.drawable.ic_action_action_xoa));

        viewHolder.lnAction4.setVisibility(View.VISIBLE);
        viewHolder.txtAction4.setText("Gửi thông báo");
        viewHolder.imgAction4.setImageDrawable(mContext.getResources().getDrawable(R.drawable.ic_menu_notification));

        try {
            if (candidate.getName() == null) {
                viewHolder.txtName.setText("...");
            } else {
                viewHolder.txtName.setText(candidate.getName());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            if (candidate.getNo_job_history().equals("0")) {
                if (candidate.getJob_history().isEmpty() || candidate.getJob_history().size() == 0 ) {
                    try {
                        if (!candidate.getEducation().isEmpty()) {
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

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    try {
                        String company = candidate.getJob_history().get(0).getJob_company();
                        String vitri = candidate.getJob_history().get(0).getCandidate_job_detail().get(0).getJob_title();
                        if (candidate.getJob_history().get(0).getIs_current().equals("1")) {
                            String html = "<b><font color=\"#333333\">" + mContext.getString(R.string.danglam) + "</font></b><font color=\"#343434\"> " + vitri + "</font><br><b><font color=\"#343434\">" + mContext.getString(R.string.tai) + "</font></b><font color=\"#343434\"> " + company + "</font>";
                            viewHolder.txtHistory.setText(Html.fromHtml(html));
                        } else {
                            String html = "<b><font color=\"#333333\">" + mContext.getString(R.string.tunglam) + "</font></b><font color=\"#343434\"> "
                                    + vitri + "</font><br><b><font color=\"#343434\">" + mContext.getString(R.string.tai) + "</font></b><font color=\"#343434\"> " + company + "</font>";
                            viewHolder.txtHistory.setText(Html.fromHtml(html));
                        }
                    } catch (Exception e) {
                        viewHolder.txtHistory.setText("...");
                        e.printStackTrace();
                    }
                }
            } else if (candidate.getNo_job_history().equals("1")) {
                viewHolder.txtHistory.setText("Chưa có kinh nghiệm làm việc");

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            if (candidate.getMin_expect_salary() == null ||
                    candidate.getMax_expect_salary() == null) {
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
            if (candidate.getJob_invite_interview().isEmpty() || candidate.getJob_invite_interview().size() == 0) {
                viewHolder.txtJobs.setVisibility(View.GONE);
            } else {
                String html = "<b><font color=\"#333333\">" + mContext.getString(R.string.congviec) + "</font></b><font color=\"#343434\"> "
                        + " " + candidate.getJob_invite_interview().get(0).getJob_title() + "</font>";
                viewHolder.txtJobs.setText(Html.fromHtml(html));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            viewHolder.r1LeftLayout2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    try {
                        if (viewHolder.itemJob.getOpenStatus() == SwipeLayout.Status.Open) {
                            viewHolder.itemJob.close();
                        } else {
                            viewHolder.itemJob.open();
                        }
                    } catch (Exception e) {
                      //  HopeLog.e(e);
                    }
                }
            });
            viewHolder.r1LeftLayout1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mDatasource.setCandidateID(candidate.getCandidate_id());
                    mDatasource.setTxtCongviec(candidate.getJob_invite_interview().get(0).getJob_title());
                    mDatasource.setIDCongviec(candidate.getJob_invite_interview().get(0).getJob_id());
                    mDatasource.setPosition(position);
                    mListener.onItemClick();
                }
            });
            viewHolder.lnAction3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
      //              mDatasource.setCandidateID(candidate.getCandidate_id());
     //               mDatasource.setIDCongviec(candidate.getJob_invite_interview().get(0).getJob_id());
      //              mDatasource.setPosition(position);
         //           mListener.onItemButtonXoaClick();

                }
            });
            viewHolder.lnAction2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mDatasource.setCandidateID(candidate.getCandidate_id());
                    mListener.onDatLichClick();

                }
            });
            viewHolder.lnAction1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mDatasource.setCandidateID(candidate.getCandidate_id());
                    mListener.onSendEmailClick();
                }
            });

            viewHolder.lnAction4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mDatasource.setCandidateID(candidate.getCandidate_id());
                    mListener.onSendNotification();
                }
            });
        } catch (Exception e) {

        }

    }

    @Override
    public int getItemCount() {
        return mList.size() +1;
    }

    @Override
    public int getSwipeLayoutResourceId(int position) {
        return R.id.item_reject_candidate_swipeLayout;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView txtName, txtHistory, txtLuong;
        public SwipeLayout itemJob;
        public RelativeLayout r1LeftLayout1,r1LeftLayout2;
        public CircleImageView imgAvatar;
        public TextView txtJobs;
        public LinearLayout lnAction1, lnAction2,lnAction3,lnAction4;
        public TextView txtAction1, txtAction2, txtAction3, txtAction4;
        public ImageView imgAction1, imgAction2, imgAction3, imgAction4;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            txtName = (TextView) itemView.findViewById(R.id.reject_candidate_name);
            txtHistory = (TextView) itemView.findViewById(R.id.reject_candidate_jobhistory);
            txtLuong = (TextView) itemView.findViewById(R.id.reject_candidate_salary);
            itemJob = (SwipeLayout) itemView.findViewById(R.id.item_reject_candidate_swipeLayout);
            imgAvatar = (CircleImageView) itemView.findViewById(R.id.reject_candidate_avatar);
            r1LeftLayout1 = (RelativeLayout) itemView.findViewById(R.id.item_reject_candidateLeftLayout);
            r1LeftLayout2 = (RelativeLayout) itemView.findViewById(R.id.item_reject_candidateLeftLayout2);
            txtJobs =  (TextView) itemView.findViewById(R.id.reject_candidate_job);
            lnAction1 = (LinearLayout) itemView.findViewById(R.id.item_reject_candidate_action1);
            lnAction2 = (LinearLayout) itemView.findViewById(R.id.item_reject_candidate_action2);
            lnAction3 = (LinearLayout) itemView.findViewById(R.id.item_reject_candidate_action3);
            txtAction1 = (TextView) itemView.findViewById(R.id.item_reject_candidate_txtaction1);
            txtAction2 = (TextView) itemView.findViewById(R.id.item_reject_candidate_txtaction2);
            txtAction3 = (TextView) itemView.findViewById(R.id.item_reject_candidate_txtaction3);
            imgAction1 = (ImageView) itemView.findViewById(R.id.item_reject_candidate_imgaction1);
            imgAction2 = (ImageView) itemView.findViewById(R.id.item_reject_candidate_imgaction2);
            imgAction3 = (ImageView) itemView.findViewById(R.id.item_reject_candidate_imgaction3);
            lnAction4 = (LinearLayout) itemView.findViewById(R.id.item_reject_candidate_action4);
            txtAction4 = (TextView) itemView.findViewById(R.id.item_reject_candidate_txtaction4);
            imgAction4 = (ImageView) itemView.findViewById(R.id.item_reject_candidate_imgaction4);
        }
    }

    public void deleteItem(int pos) {
        try {
            mItemManger.closeAllItems();
            mList.remove(pos);
            notifyDataSetChanged();
        } catch (Exception e) {

        }
    }

}
