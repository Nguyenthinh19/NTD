package com.example.ntd.lovecandidate;

import com.example.ntd.objects.Candidate;
import com.example.ntd.objects.JobDetailObj;

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

}
