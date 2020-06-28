package com.example.ntd.candidateinviteinterview;

import android.content.Context;
import android.os.AsyncTask;

import com.example.ntd.objects.CandidateInviteInterviewObj;
import com.example.ntd.objects.User;
import com.example.ntd.urlconnection.PostCandidate;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;

public class CandidateInviteInterviewModel implements CandidateInviteInterviewInterface.Datasource {

    private ArrayList<CandidateInviteInterviewObj> mListCandidate;
    private String mCandidateID;
    private String mSearch;
    private int mPage, mPageJob;
    private int mPosition;
    private String mIDCongviec;
    private String mCongviec;
    private boolean mLoad;
    private ArrayList<CandidateInviteInterviewObj> mListFilter;

    @Override
    public void setIsLoading(boolean load) {
        this.mLoad = load;
    }

    @Override
    public boolean getIsLoading() {
        return mLoad;
    }

    @Override
    public void setPosition(int position) {
        this.mPosition = position;
    }

    @Override
    public int getPosition() {
        return mPosition;
    }

    @Override
    public ArrayList<CandidateInviteInterviewObj> getListInterviewCandidate() {
        return mListCandidate;
    }

    @Override
    public void setListInterviewCandidate(ArrayList<CandidateInviteInterviewObj> list) {
        this.mListCandidate = list;
    }

    @Override
    public void setNextPage(int page) {
        this.mPage = page;
    }

    @Override
    public int getNextPage() {
        return mPage;
    }

    @Override
    public void setNextPageJob(int page) {
        this.mPageJob = page;

    }

    @Override
    public int getNextPageJob() {
        return mPageJob;
    }

    @Override
    public void setTextSearch(String search) {
        this.mSearch = search;
    }

    @Override
    public String getTextSearch() {
        return mSearch;
    }

    @Override
    public void setIDCongviec(String id) {
        this.mIDCongviec = id;
    }

    @Override
    public String getIDCongviec() {
        return mIDCongviec;
    }

    @Override
    public void setCandidateID(String candidateID) {
        this.mCandidateID = candidateID;
    }

    @Override
    public String getCandidateID() {
        return mCandidateID;
    }

    @Override
    public void setTxtCongviec(String congviec) {
        this.mCongviec = congviec;
    }

    @Override
    public String getTxtCongviec() {
        return mCongviec;
    }

    @Override
    public void setListFilter(ArrayList<CandidateInviteInterviewObj> list) {
        this.mListFilter = list;
    }

    @Override
    public ArrayList<CandidateInviteInterviewObj> getListFilter() {
        return mListFilter;
    }

    public void loadDSMoiPhongvan(final Context context, final onExcuteFinish finish) {
        mListCandidate = new ArrayList<>();
        class HopeRequest2  extends AsyncTask {
            User tempUser = null;
            String subemployer_id = "";
            private String API_GET_LIST_CANDIDATE = "https://dev-admin.jobsgo.vn/employerapi/employer-ref/list-candidate-by-status";

            private String mHopeToken = "hopejob2017702725";
            @Override
            protected void onPreExecute() {
                setIsLoading(true);
            }

            @Override
            protected Boolean doInBackground(Object[] objects) {
                try {
                tempUser = User.getLocalUser(context);
                if (tempUser != null) {
                    subemployer_id = tempUser.getSubemployer_id();
                }
                PostCandidate postCandidate = new PostCandidate(context);
                String data = postCandidate.post(mHopeToken, API_GET_LIST_CANDIDATE, "invite_interview", 0, subemployer_id);
                JSONObject jsonObject = new JSONObject(data);
                    if(jsonObject.getInt("status") == -1){
                        return Boolean.FALSE;
                    }else if (onSuccessful(jsonObject)) {
                        return Boolean.TRUE;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return null;
            }
            public boolean onSuccessful(JSONObject jsonObject) {
                try {
                    int status = jsonObject.getInt("status");
                    if (status == 1) {
                        JSONArray data = jsonObject.getJSONArray("data");
                        for (int i = 0; i < data.length(); i++) {
                            CandidateInviteInterviewObj candidate = new Gson().fromJson(data.get(i).toString(), CandidateInviteInterviewObj.class);
                            mListCandidate.add(candidate);
                        }
                        setNextPage(jsonObject.getInt("nextPage"));
                        setListInterviewCandidate(mListCandidate);
                        return true;
                    }
                } catch (Exception e) {
                  //  HopeLog.e(e);
                }
                return false;
            }

            @Override
            protected void onPostExecute(Object o) {
                try{
                    Boolean b = (Boolean)o;
                    if (b.equals(Boolean.TRUE)) {

                        finish.onSuccess();

                        return;
                    }else if(b.equals(Boolean.FALSE)){
                        //trường hợp api yêu cầu login lại
                     //   restartApp();
                        return;
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
                finish.onError();
            }
        }
        new HopeRequest2().execute();
    }
    public interface onExcuteFinish {
        void onSuccess();

        void onError();
    }

}
