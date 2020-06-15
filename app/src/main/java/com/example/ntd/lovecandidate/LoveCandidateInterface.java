package com.example.ntd.lovecandidate;

import com.example.ntd.objects.Candidate;
import com.example.ntd.objects.JobDetailObj;

import java.util.ArrayList;

public class LoveCandidateInterface {

    public interface Listener{
        void onLoadViewFinish();

        void onButtonBackClick();

        void onItemCLick();

        void onButtonTKClick();

        void onButtonCancel();

        void onLoadMoreLoveCandidate();

        void onLoadMoreSearch();

        void onButtonSearchClick();

        void onLoadJob();

        void onLoadMoreJob();

        void onGioithieuClick();

        void onMoiChatClick();

        void onXoaClick();

        void onDSJobBackClick();

        void onButtonSendClick();
    }
    public interface Datasource{
        void setListLoveCandidate(ArrayList<Candidate> list);

        ArrayList<Candidate> getListLoveCandidate();

        void setListLoveCandidateSearch(ArrayList<Candidate> list);

        ArrayList<Candidate> getListLoveCandidatesearch();

        void setCandidateid(String candidateid);

        String getCandidateid();

        void setLoadMore(boolean loadMore);

        boolean getLoadMore();

        void setNextPage(int page);

        int getNextPage();

        void setNextPageJob(int page);

        int getNextPageJob();

        void setNextPageFilter(int page);

        int getNextPageFilter();

        void setTextSearch(String search);

        String getTextSearch();

        void setListJob(ArrayList<JobDetailObj> list);

        ArrayList<JobDetailObj> getListJob();

        void setChatroomID(String id);

        String getChatroomID();

        void setPosition(int pos);

        int getPosition();

        void setIDJobGioithieu(String ids);

        String getIDJobGioithieu();

        void setListFilter(ArrayList<Candidate> list);

        ArrayList<Candidate> getListFilter();

        void setCandidateName(String name);

        String getCandidateName();

    }
}
