package com.example.ntd.objects;

/**
 * Created by tuanla on 8/7/16.
 */
public class UserPlaceObj {
    private String candidate_job_place_id;
    private String candidate_id;
    private String place_id;
    private String place_name;
    private String place_image;

    public UserPlaceObj(){

    }

    public UserPlaceObj(String place_name, String place_image) {
        this.place_name = place_name;
        this.place_image = place_image;
    }

    public String getPlace_image() {
        return place_image;
    }

    public void setPlace_image(String place_image) {
        this.place_image = place_image;
    }

    public String getPlace_name() {
        return place_name;
    }

    public void setPlace_name(String place_name) {
        this.place_name = place_name;
    }

    public String getPlace_id() {
        return place_id;
    }

    public void setPlace_id(String place_id) {
        this.place_id = place_id;
    }

    public String getCandidate_id() {
        return candidate_id;
    }

    public void setCandidate_id(String candidate_id) {
        this.candidate_id = candidate_id;
    }

    public String getCandidate_job_place_id() {
        return candidate_job_place_id;
    }

    public void setCandidate_job_place_id(String candidate_job_place_id) {
        this.candidate_job_place_id = candidate_job_place_id;
    }


}
