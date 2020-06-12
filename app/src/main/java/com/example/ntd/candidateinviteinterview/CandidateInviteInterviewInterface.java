package com.example.ntd.candidateinviteinterview;

import com.example.ntd.objects.CandidateInviteInterviewObj;

import java.util.ArrayList;

public class CandidateInviteInterviewInterface {
    public interface Listener{
        void onLoadCandidateInterview();

        void onLoadCandidateInterviewMore();

        void onButtonCancelClick();

        void onButtonSearchClick();

        void onItemClick();

        void onLoadMoreSearch();

        void onItemButtonXoaClick();

        void onItemButtonXoaSearchClick();

        void onButtonBackClick();

        void onButtonTKClick();

        void onDatLichClick();

        void onSendEmailClick();

        void onSendNotification();

    }
    public interface Datasource{
        void setIsLoading(boolean load);

        boolean getIsLoading();

        void setPosition(int position);

        int getPosition();

        ArrayList<CandidateInviteInterviewObj> getListInterviewCandidate();

        void setListInterviewCandidate(ArrayList<CandidateInviteInterviewObj> list);

        void setNextPage(int page);

        int getNextPage();

        void setNextPageJob(int page);

        int getNextPageJob();

        void setTextSearch(String search);

        String getTextSearch();

        void setIDCongviec(String id);

        String getIDCongviec();

        void setCandidateID(String candidateID);

        String getCandidateID();

        void setTxtCongviec(String congviec);

        String getTxtCongviec();

        void setListFilter(ArrayList<CandidateInviteInterviewObj> list);

        ArrayList<CandidateInviteInterviewObj> getListFilter();

    }
}