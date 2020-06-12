package com.example.ntd.objects;

import java.util.List;

/**
 * Created by vietn on 08/08/2016.
 */
public class JobHistory {
    String candidate_job_history_id;
    String candidate_id;
    String job_type;
    String job_title;
    String job_description;
    String date_start;
    String date_end;
    String is_current;
    String job_company;
    List<CandidateJobDetail> candidate_job_detail;

    public List<CandidateJobDetail> getCandidate_job_detail() {
        return candidate_job_detail;
    }

    public void setCandidate_job_detail(List<CandidateJobDetail> candidate_job_detail) {
        this.candidate_job_detail = candidate_job_detail;
    }

    public String getJob_company() {
        return job_company;
    }

    public void setJob_company(String job_company) {
        this.job_company = job_company;
    }

    public String getCandidate_job_history_id() {
        return candidate_job_history_id;
    }

    public void setCandidate_job_history_id(String candidate_job_history_id) {
        this.candidate_job_history_id = candidate_job_history_id;
    }

    public String getCandidate_id() {
        return candidate_id;
    }

    public void setCandidate_id(String candidate_id) {
        this.candidate_id = candidate_id;
    }

    public String getJob_type() {
        return job_type;
    }

    public void setJob_type(String job_type) {
        this.job_type = job_type;
    }

    public String getJob_title() {
        return job_title;
    }

    public void setJob_title(String job_title) {
        this.job_title = job_title;
    }

    public String getJob_description() {
        return job_description;
    }

    public void setJob_description(String job_description) {
        this.job_description = job_description;
    }

    public String getDate_start() {
        return date_start;
    }

    public void setDate_start(String date_start) {
        this.date_start = date_start;
    }

    public String getDate_end() {
        return date_end;
    }

    public void setDate_end(String date_end) {
        this.date_end = date_end;
    }

    public String getIs_current() {
        return is_current;
    }

    public void setIs_current(String is_current) {
        this.is_current = is_current;
    }

}
