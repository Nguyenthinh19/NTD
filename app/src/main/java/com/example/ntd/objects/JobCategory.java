package com.example.ntd.objects;

/**
 * Created by vietn on 27/07/2016.
 */
public class JobCategory {
    String job_category_assoc_id;
    String job_category_name;
    String job_category_parent_id;
    String job_category_image;
    String experiment_duration;

    public String getExperiment_duration() {
        return experiment_duration;
    }

    public void setExperiment_duration(String experiment_duration) {
        this.experiment_duration = experiment_duration;
    }

    public String getJob_category_assoc_id() {
        return job_category_assoc_id;
    }

    public void setJob_category_assoc_id(String job_category_assoc_id) {
        this.job_category_assoc_id = job_category_assoc_id;
    }

    public String getJob_category_name() {
        return job_category_name;
    }

    public void setJob_category_name(String job_category_name) {
        this.job_category_name = job_category_name;
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
}
