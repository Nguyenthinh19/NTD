package com.example.ntd.home.adapters;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.ntd.R;
import com.example.ntd.base.BaseActivity;
import com.example.ntd.login.interfaces.LoginIdInterface;
import com.example.ntd.login.interfaces.LoginSuccessInterface;
import com.example.ntd.objects.Candidate;
import com.example.ntd.objects.JobApplied;
import com.example.ntd.objects.JobCategory;
import com.example.ntd.objects.UserPlaceObj;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class SwipeCardAdapter extends BaseAdapter {
    public static final String KEY_TIP = "cardtippass";
    List<Candidate> list = new ArrayList<>();
    BaseActivity mActivity;
    LayoutInflater inflater;
    SharedPreferences sharedPreferences;
    Listener mListener;

    public SwipeCardAdapter(List<Candidate> list, BaseActivity mActivity) {
        this.list = list;
        this.mActivity = mActivity;
        inflater = (LayoutInflater) mActivity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        sharedPreferences = mActivity.getSharedPreferences("HINT", Context.MODE_PRIVATE);

    }

    public void setmListener(Listener mListener) {
        this.mListener = mListener;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;

        try {
            ViewHolder viewHolder;
            if (view == null) {
                view =inflater.inflate(R.layout.item_home_card,parent,false);
                viewHolder = new ViewHolder(view);
                view.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder)view.getTag();
            }
            viewHolder.build(position);

        }catch (Exception e) {
            e.printStackTrace();
        }
        return view;
    }

    private class ViewHolder{

        private View mView;
        private CircleImageView avatar;
        private TextView name, city, jobCategory, desc, currentJob, lvl, salary, place, applied;
        private View buttonFilter;
        View tipView;
        ImageView soureIconImageView;
        View textViewFileTip;

        public ViewHolder(View view) {
            mView = view;
            avatar = (CircleImageView) mView.findViewById(R.id.imageView_home_card_avatar);
            name = (TextView) mView.findViewById(R.id.textView_home_card_name);
            city = (TextView) mView.findViewById(R.id.textView_home_card_city);
            jobCategory = (TextView) mView.findViewById(R.id.textView_home_card_job_catagory);
            desc = (TextView) mView.findViewById(R.id.textView_home_card_desc);
            currentJob = (TextView) mView.findViewById(R.id.textView_home_card_current_job);
            lvl = (TextView) mView.findViewById(R.id.textView_home_card_lvl);
            salary = (TextView) mView.findViewById(R.id.textView_home_card_salary);
            place = (TextView) mView.findViewById(R.id.textView_home_card_location);
            applied = (TextView) mView.findViewById(R.id.textView_home_card_applied);
            tipView = view.findViewById(R.id.imageView_card_tip_v2);
            buttonFilter = (View) mView.findViewById(R.id.button_home_card_filter);
            soureIconImageView = (ImageView) mView.findViewById(R.id.imageView_home_card_source_icon);
            textViewFileTip =mView.findViewById(R.id.textView_view_file_tip);
        }

        public void build(int position) {
            boolean b = sharedPreferences.getBoolean(KEY_TIP, false);
            if (position == 0 && !b) {
                tipView.setVisibility(View.VISIBLE);
                tipView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        tipView.setVisibility(View.GONE);
                        sharedPreferences.edit().putBoolean(KEY_TIP,true).apply();
                    }
                });
            }

            Candidate candidate = list.get(position);
            mActivity.imageLoader.displayImage(candidate.getAvatar(),avatar,mActivity.defaultDisplayImageOptions);
            name.setText(candidate.getName());
            salary.setText(candidate.getMin_expect_salary()+ " - " + candidate.getMax_expect_salary());
            desc.setText(candidate.getShort_bio());
            city.setText(buildInfo(candidate));
            jobCategory.setText(buildJobCategory(candidate));
            place.setText(buildJobPlace(candidate));
            applied.setText(buildJobApplied(candidate));
            lvl.setText(buildEducation(candidate));
            buildHistory(candidate);
            if (candidate.isFrom_headhunter()) {
                soureIconImageView.setVisibility(View.VISIBLE);
                mActivity.imageLoader.displayImage(candidate.getHeadhunter_icon(),soureIconImageView,mActivity.defaultDisplayImageOptions);
            } else {
                soureIconImageView.setVisibility(View.GONE);
            }
            if (candidate.isHighlight_file()) {
                textViewFileTip.setVisibility(View.VISIBLE);
            } else {
                textViewFileTip.setVisibility(View.GONE);
            }
        }

        private String buildEducation(Candidate candidate) {
            String text1 = "...";
            String text2 = "...";
            try{
                text1 = candidate.getEducation().get(0).getSpecialization();
                text2 = candidate.getEducation().get(0).getSchool_name();
            }catch (Exception e){
                e.printStackTrace();
            }
            return String.format(mActivity.getString(R.string.home_card_lvl), text1, text2);
        }

        private String buildJobApplied(Candidate candidate) {
            String text = "";
            try{
                List<JobApplied> applied = candidate.getJob_apply();
                text = applied.get(0).getJob_title();
                String point = applied.get(0).getTotalPoint();
                if(point != null && !point.equals("null") && !point.equals("")){
                    String pointText = String.format(mActivity.getString(R.string.total_point), applied.get(0).getTotalPoint() + "%");
                    text = pointText + text;
                }

            }catch (Exception e){
                e.printStackTrace();
            }
            return text;
        }

        private String buildJobPlace(Candidate candidate) {

            String text = "";
            try{
                List<UserPlaceObj> jobPlaces = candidate.getJob_place();
                for (int i = 0; i < jobPlaces.size(); i++) {
                    text = text + jobPlaces.get(i).getPlace_name() + ", ";
                }
                text = text.substring(0, text.length() - 2);
            }catch (Exception e){
                e.printStackTrace();
            }
            return text;
        }

        private String buildJobCategory(Candidate candidate) {
            String text = "";
            try {
                List<JobCategory> categories = candidate.getJob_category();
                for (int i = 0; i < categories.size();i++) {
                    text = text + categories.get(i).getJob_category_name() + ",";
                }
                text = text.substring(0,text.length() -2 );
            } catch (Exception e) {
                e.printStackTrace();
            }
            return text;
        }


        private String buildInfo(Candidate candidate) {
            String userInfo = " ";
            try {
                List<String> list = new ArrayList<>();
                String[] array = candidate.getCurrent_city().split(",");
                list = Arrays.asList(array);
                if (list.size() > 2) {
                    userInfo = String.format(mActivity.getString(R.string.login_display_user_info), buildGender(candidate), buildAge(candidate.getDate_of_birth()),list.get((list.size()-2)));
                } else {
                    userInfo = String.format(mActivity.getString(R.string.login_display_user_info), buildGender(candidate), buildAge(candidate.getDate_of_birth()),candidate.getCurrent_city());

                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return userInfo;
        }

        private String buildGender(Candidate candidate) {
            String userGender = "";
            try {
                if (candidate.getGender().equals(Candidate.MALE)) {
                    return mActivity.getString(R.string.male);
                } else if (candidate.getGender().equals(Candidate.FEMALE)) {
                    return mActivity.getString(R.string.female);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return userGender;
        }
        private String buildAge(String date_of_birth) {

            try {
                DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
                Date date = dateFormat.parse(date_of_birth);

                Calendar now = Calendar.getInstance();
                Calendar dob = Calendar.getInstance();
                dob.setTime(date);
                if (dob.after(now)) {
                    throw new IllegalArgumentException("Can't be born in the future");
                }
                int year1 = now.get(Calendar.YEAR);
                int year2 = now .get(Calendar.YEAR);
                int age = year1 - year2;
                int month1 = now.get(Calendar.MONTH);
                int month2 = now.get(Calendar.MONTH);
                if (month2 > month1) {
                    age--;
                } else if (month1 == month2) {
                    int day1 = now.get(Calendar.DAY_OF_MONTH);
                    int day2 = dob.get(Calendar.DAY_OF_MONTH);
                    if (day2 > day1) {
                        age--;
                    }

                }
                return String.valueOf(age);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return "...";
        }
        private void buildHistory(Candidate candidate) {
            try {
                String s1= "...";
                try {
                    if (candidate.getNo_job_history() != null && candidate.getNo_job_history().equals("1")) {
                        currentJob.setText(mActivity.getText(R.string.preview_profile_no_current_job_html));
                        return;
                    }
                } catch (Exception e) {

                }
                try {
                    s1 = candidate.getJob_history().get(0).getCandidate_job_detail().get(0).getJob_title();

                } catch (Exception e) {

                }
                String s2 = candidate.getJob_history().get(0).getJob_company();
                if (s1 != null && s2 != null) {
                    if (candidate.getJob_history().get(0).getIs_current().equals("0")) {
                        String text = String.format(mActivity.getString(R.string.preview_profile_current_job_html2),s1,s2);
                        currentJob.setText(Html.fromHtml(text));
                    }
                    if (candidate.getJob_history().get(0).getIs_current().equals("1")) {
                        String text = String.format(mActivity.getString(R.string.preview_profile_current_job_html),s1,s2);
                        currentJob.setText(Html.fromHtml(text));
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                currentJob.setText("...");
            }
        }


    }
    public interface Listener {
        void onTopShowed(Candidate candidate);
    }





}
