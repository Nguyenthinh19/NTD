package com.example.ntd.objects;

import org.json.JSONObject;

public class JobCategoryObj extends BaseObject {

    private String job_category_id;
    private String job_category_name;
    private String job_category_name_vn;
    private String status;
    private String job_category_parent_id;
    private String job_category_image;
    private String experiment_duration;

    public String getJob_category_id() {
        return job_category_id;
    }

    public void setJob_category_id(String job_category_id) {
        this.job_category_id = job_category_id;
    }

    public String getJob_category_name() {
        return job_category_name;
    }

    public void setJob_category_name(String job_category_name) {
        this.job_category_name = job_category_name;
    }

    public String getJob_category_name_vn() {
        return job_category_name_vn;
    }

    public void setJob_category_name_vn(String job_category_name_vn) {
        this.job_category_name_vn = job_category_name_vn;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getJob_category_parent_id() {
        return job_category_parent_id;
    }

    public void setJob_category_parent_id(String job_category_parent_id) {
        this.job_category_parent_id = job_category_parent_id;
    }

    public String getJob_category_image() {
        return job_category_image;
    }

    public void setJob_category_image(String job_category_image) {
        this.job_category_image = job_category_image;
    }

    public String getExperiment_duration() {
        return experiment_duration;
    }

    public void setExperiment_duration(String experiment_duration) {
        this.experiment_duration = experiment_duration;
    }

    @Override
    public void parseJsonToObject(JSONObject jsonObject) {
        try {
            setJob_category_id(jsonObject.getString("job_category_id"));
            setJob_category_name(jsonObject.getString("job_category_name"));
            setJob_category_name_vn(jsonObject.getString("job_category_name_vn"));
            setStatus(jsonObject.getString("status"));
            setJob_category_parent_id(jsonObject.getString("job_category_parent_id"));
            setJob_category_image(jsonObject.getString("job_category_image"));
            setExperiment_duration(jsonObject.getString("experiment_duration"));
        } catch (Exception e) {
          //  HopeLog.e(e);
        }
    }

}
