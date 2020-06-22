package com.example.ntd.lovecandidate;

import android.content.Context;
import android.os.AsyncTask;

import com.example.ntd.objects.Candidate;
import com.example.ntd.objects.JobDetailObj;
import com.example.ntd.objects.User;
import com.example.ntd.urlconnection.PostCandidate;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class LoveCandidateModel implements LoveCandidateInterface.Datasource {

    private ArrayList<Candidate> mListLove;
    private String mCandidateID;
    private boolean loadMore;
    private int mNextPage, mNextPageJob, mPageFilter;
    private ArrayList<Candidate> mListSearch;
    private ArrayList<Candidate> mListFilter;
    private String mSearch;
    private ArrayList<JobDetailObj> mListJob;
    private String mChatroomID;
    private int mPosition;
    private String mIDGioithieuviec;
    private String mName;

    public interface onExcuteFinish{
        void Success();

        void Error();
    }

    @Override
    public void setListLoveCandidate(ArrayList<Candidate> list) {
        this.mListLove = list;
    }

    @Override
    public ArrayList<Candidate> getListLoveCandidate() {
        return mListLove;
    }

    @Override
    public void setListLoveCandidateSearch(ArrayList<Candidate> list) {
        this.mListSearch = list;
    }

    @Override
    public ArrayList<Candidate> getListLoveCandidatesearch() {
        return mListSearch;
    }

    @Override
    public void setCandidateid(String candidateid) {
        this.mCandidateID = candidateid;
    }

    @Override
    public String getCandidateid() {
        return mCandidateID;
    }

    @Override
    public void setLoadMore(boolean loadMore) {
        this.loadMore =loadMore;
    }

    @Override
    public boolean getLoadMore() {
        return loadMore;
    }

    @Override
    public void setNextPage(int page) {
        this.mNextPage = page;
    }

    @Override
    public int getNextPage() {
        return mNextPage;
    }

    @Override
    public void setNextPageJob(int page) {
        this.mNextPageJob = page;
    }

    @Override
    public int getNextPageJob() {
        return mNextPageJob;
    }

    @Override
    public void setNextPageFilter(int page) {
        this.mPageFilter = page;
    }

    @Override
    public int getNextPageFilter() {
        return mPageFilter;
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
    public void setListJob(ArrayList<JobDetailObj> list) {
        this.mListJob = list;
    }

    @Override
    public ArrayList<JobDetailObj> getListJob() {
        return mListJob;
    }

    @Override
    public void setChatroomID(String id) {
        this.mChatroomID = id;
    }

    @Override
    public String getChatroomID() {
        return mChatroomID;
    }

    @Override
    public void setPosition(int pos) {
        this.mPosition = pos;
    }

    @Override
    public int getPosition() {
        return mPosition;
    }

    @Override
    public void setIDJobGioithieu(String ids) {
        this.mIDGioithieuviec = ids;
    }

    @Override
    public String getIDJobGioithieu() {
        return mIDGioithieuviec;
    }

    @Override
    public void setListFilter(ArrayList<Candidate> list) {
        this.mListFilter = list;
    }

    @Override
    public ArrayList<Candidate> getListFilter() {
        return mListFilter;
    }

    @Override
    public void setCandidateName(String name) {
        this.mName = name;
    }

    @Override
    public String getCandidateName() {
        return mName;
    }

    public void loadLoveCandidate(final Context context, final onExcuteFinish finish) {
        mListLove = new ArrayList<>();
        class HopeRequest extends AsyncTask {
            User tempUser = null;
            String subemployer_id = "";
            private String API_GET_LIST_CANDIDATE = "https://dev-admin.jobsgo.vn/employerapi/employer-ref/list-candidate-by-status";

            private String mHopeToken = "hopejob2017702725";
            @Override
            protected void onPreExecute() {
                setLoadMore(true);
            }

            @Override
            protected Object doInBackground(Object[] objects) {
                try {
                    tempUser = User.getLocalUser(context);
                    if (tempUser != null) {
                        subemployer_id = tempUser.getSubemployer_id();
                    }
                    PostCandidate postCandidate = new PostCandidate(context);
                    String data = postCandidate.post(mHopeToken, API_GET_LIST_CANDIDATE, "love", 0, subemployer_id);
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
                    if (status ==1){
                        JSONArray data = jsonObject.getJSONArray("data");
                        for (int i =0; i <data.length(); i++){
                            Candidate candidate = new Gson().fromJson(data.get(i).toString(), Candidate.class);
                            mListLove.add(candidate);
                        }
                        setNextPage(jsonObject.getInt("nextPage"));
                        setListLoveCandidate(mListLove);
                        return true;
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
                return false;
            }

            @Override
            protected void onPostExecute(Object o) {
                try{
                    Boolean b = (Boolean)o;
                    if (b.equals(Boolean.TRUE)) {
                        try {
                            finish.Success();
                            setLoadMore(false);
                        }catch (Exception e){
                            e.printStackTrace();
                        }
                        return;
                    }else if(b.equals(Boolean.FALSE)){
                        //trường hợp api yêu cầu login lại
                    //    restartApp();
                        return;
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
                try {
                    setLoadMore(false);
                    finish.Error();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        new HopeRequest().execute();

    }
}
