package com.example.ntd.objects;

/**
 * Created by TuanLA on 12/29/2016.
 */
public class CandidateJobDetail {
    private String candidate_job_history_detail_id;
    private String candidate_job_history_id;
    private String job_title;
    private String job_description;
    private String date_start;
    private String date_end;
    private String job_type;
    private String candidate_id;

    public String getCandidate_job_history_detail_id() {
        return candidate_job_history_detail_id;
    }

    public void setCandidate_job_history_detail_id(String candidate_job_history_detail_id) {
        this.candidate_job_history_detail_id = candidate_job_history_detail_id;
    }

    public String getCandidate_job_history_id() {
        return candidate_job_history_id;
    }

    public void setCandidate_job_history_id(String candidate_job_history_id) {
        this.candidate_job_history_id = candidate_job_history_id;
    }

    public String getJob_description() {
        return job_description;
    }

    public void setJob_description(String job_description) {
        this.job_description = job_description;
    }

    public String getJob_title() {
        return job_title;
    }

    public void setJob_title(String job_title) {
        this.job_title = job_title;
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

    public String getJob_type() {
        return job_type;
    }

    public void setJob_type(String job_type) {
        this.job_type = job_type;
    }

    public String getCandidate_id() {
        return candidate_id;
    }

    public void setCandidate_id(String candidate_id) {
        this.candidate_id = candidate_id;
    }

}
