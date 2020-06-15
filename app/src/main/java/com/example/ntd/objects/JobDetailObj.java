package com.example.ntd.objects;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;


public class JobDetailObj extends BaseObject {
    private String job_id;
    private String employer_id;
    private ArrayList<JobPlaceObj> job_place;
    private ArrayList<JobCategoryObj> job_category;
    private String degree_id;
    private String degree;
    private String min_expect_salary;
    private String max_expect_salary;
    private String job_type;
    private String job_type_id;
    private String job_title;
    private String job_description;
    private String job_requirement;
    private String job_benefit;
    private String job_other_requirement;
    private String deadline;
    private String granted_employer;
    private String created;
    private String updated;
    private String status;
    private String job_short_description_1;
    private String job_short_description_2;
    private String job_short_description_3;
    private String job_short_description_4;
    private String job_short_description_5;
    private String exp_min_require_year;
    private String exp_max_require_year;
    private String record_status;
    private String deleted;
    private String job_position;
    private String job_position_id;
    private String hash_tag;
    private String has_modify;
    private String is_demo;
    private String approved_time;
    private String job_image;
    private String is_job_love;
    private String salary_description;
    private boolean check;
    private String paused;
    private ShareInfoObj share_info;

    public String getJob_id() {
        return job_id;
    }

    public void setJob_id(String job_id) {
        this.job_id = job_id;
    }

    public String getEmployer_id() {
        return employer_id;
    }

    public void setEmployer_id(String employer_id) {
        this.employer_id = employer_id;
    }

    public ArrayList<JobPlaceObj> getJob_place() {
        return job_place;
    }

    public void setJob_place(ArrayList<JobPlaceObj> job_place) {
        this.job_place = job_place;
    }

    public ArrayList<JobCategoryObj> getJob_category() {
        return job_category;
    }

    public void setJob_category(ArrayList<JobCategoryObj> job_category) {
        this.job_category = job_category;
    }

    public String getDegree_id() {
        return degree_id;
    }

    public void setDegree_id(String degree_id) {
        this.degree_id = degree_id;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getMin_expect_salary() {
        return min_expect_salary;
    }

    public void setMin_expect_salary(String min_expect_salary) {
        this.min_expect_salary = min_expect_salary;
    }

    public String getMax_expect_salary() {
        return max_expect_salary;
    }

    public void setMax_expect_salary(String max_expect_salary) {
        this.max_expect_salary = max_expect_salary;
    }

    public String getJob_type() {
        return job_type;
    }

    public void setJob_type(String job_type) {
        this.job_type = job_type;
    }

    public String getJob_type_id() {
        return job_type_id;
    }

    public void setJob_type_id(String job_type_id) {
        this.job_type_id = job_type_id;
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

    public String getJob_requirement() {
        return job_requirement;
    }

    public void setJob_requirement(String job_requirement) {
        this.job_requirement = job_requirement;
    }

    public String getJob_benefit() {
        return job_benefit;
    }

    public void setJob_benefit(String job_benefit) {
        this.job_benefit = job_benefit;
    }

    public String getJob_other_requirement() {
        return job_other_requirement;
    }

    public void setJob_other_requirement(String job_other_requirement) {
        this.job_other_requirement = job_other_requirement;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public String getGranted_employer() {
        return granted_employer;
    }

    public void setGranted_employer(String granted_employer) {
        this.granted_employer = granted_employer;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getUpdated() {
        return updated;
    }

    public void setUpdated(String updated) {
        this.updated = updated;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getJob_short_description_1() {
        return job_short_description_1;
    }

    public void setJob_short_description_1(String job_short_description_1) {
        this.job_short_description_1 = job_short_description_1;
    }

    public String getJob_short_description_2() {
        return job_short_description_2;
    }

    public void setJob_short_description_2(String job_short_description_2) {
        this.job_short_description_2 = job_short_description_2;
    }

    public String getJob_short_description_3() {
        return job_short_description_3;
    }

    public void setJob_short_description_3(String job_short_description_3) {
        this.job_short_description_3 = job_short_description_3;
    }

    public String getJob_short_description_4() {
        return job_short_description_4;
    }

    public void setJob_short_description_4(String job_short_description_4) {
        this.job_short_description_4 = job_short_description_4;
    }

    public String getJob_short_description_5() {
        return job_short_description_5;
    }

    public void setJob_short_description_5(String job_short_description_5) {
        this.job_short_description_5 = job_short_description_5;
    }

    public String getExp_min_require_year() {
        return exp_min_require_year;
    }

    public void setExp_min_require_year(String exp_min_require_year) {
        this.exp_min_require_year = exp_min_require_year;
    }

    public String getExp_max_require_year() {
        return exp_max_require_year;
    }

    public void setExp_max_require_year(String exp_max_require_year) {
        this.exp_max_require_year = exp_max_require_year;
    }

    public String getRecord_status() {
        return record_status;
    }

    public void setRecord_status(String record_status) {
        this.record_status = record_status;
    }

    public String getDeleted() {
        return deleted;
    }

    public void setDeleted(String deleted) {
        this.deleted = deleted;
    }

    public String getJob_position() {
        return job_position;
    }

    public void setJob_position(String job_position) {
        this.job_position = job_position;
    }

    public String getJob_position_id() {
        return job_position_id;
    }

    public void setJob_position_id(String job_position_id) {
        this.job_position_id = job_position_id;
    }

    public String getHash_tag() {
        return hash_tag;
    }

    public void setHash_tag(String hash_tag) {
        this.hash_tag = hash_tag;
    }

    public String getHas_modify() {
        return has_modify;
    }

    public void setHas_modify(String has_modify) {
        this.has_modify = has_modify;
    }

    public String getIs_demo() {
        return is_demo;
    }

    public void setIs_demo(String is_demo) {
        this.is_demo = is_demo;
    }

    public String getApproved_time() {
        return approved_time;
    }

    public void setApproved_time(String approved_time) {
        this.approved_time = approved_time;
    }

    public String getJob_image() {
        return job_image;
    }

    public void setJob_image(String job_image) {
        this.job_image = job_image;
    }

    public String getIs_job_love() {
        return is_job_love;
    }

    public void setIs_job_love(String is_job_love) {
        this.is_job_love = is_job_love;
    }

    public String getSalary_description() {
        return salary_description;
    }

    public void setSalary_description(String salary_description) {
        this.salary_description = salary_description;
    }

    public boolean isCheck() {
        return check;
    }

    public void setCheck(boolean check) {
        this.check = check;
    }

    public String getPaused() {
        return paused;
    }

    public void setPaused(String paused) {
        this.paused = paused;
    }

    public ShareInfoObj getShare_info() {
        return share_info;
    }

    public void setShare_info(ShareInfoObj share_info) {
        this.share_info = share_info;
    }

    @Override
    public void parseJsonToObject(JSONObject jsonObject) {
        ArrayList<JobPlaceObj> lstPlace = new ArrayList<>();
        ArrayList<JobCategoryObj> lstCategory = new ArrayList<>();
        try {
            setJob_id(jsonObject.getString("job_id"));
            setEmployer_id(jsonObject.getString("employer_id"));
            JSONArray job_place = jsonObject.getJSONArray("job_place");
            for (int i = 0; i < job_place.length(); i++) {
                JobPlaceObj jobPlaceObj = new JobPlaceObj();
                jobPlaceObj.parseJsonToObject(job_place.getJSONObject(i));
                lstPlace.add(jobPlaceObj);
            }
            setJob_place(lstPlace);
            JSONArray job_category = jsonObject.getJSONArray("job_category");
            for (int i = 0; i < job_category.length(); i++) {
                JobCategoryObj jobCategoryObj = new JobCategoryObj();
                jobCategoryObj.parseJsonToObject(job_category.getJSONObject(i));
                lstCategory.add(jobCategoryObj);
            }
            setJob_category(lstCategory);
            setDegree_id(jsonObject.getString("degree_id"));
            setDegree(jsonObject.getString("degree"));
            setMin_expect_salary(jsonObject.getString("min_expect_salary"));
            setMax_expect_salary(jsonObject.getString("max_expect_salary"));
            setJob_type(jsonObject.getString("job_type"));
            setJob_type_id(jsonObject.getString("job_type_id"));
            setJob_title(jsonObject.getString("job_title"));
            setJob_description(jsonObject.getString("job_description"));
            setJob_requirement(jsonObject.getString("job_requirement"));
            setJob_benefit(jsonObject.getString("job_benefit"));
            setJob_other_requirement(jsonObject.getString("job_other_requirement"));
            setDeadline(jsonObject.getString("deadline"));
            setGranted_employer(jsonObject.getString("granted_employer"));
            setCreated(jsonObject.getString("created"));
            setUpdated(jsonObject.getString("updated"));
            setStatus(jsonObject.getString("status"));
            setJob_short_description_1(jsonObject.getString("job_short_description_1"));
            setJob_short_description_2(jsonObject.getString("job_short_description_2"));
            setJob_short_description_3(jsonObject.getString("job_short_description_3"));
            setJob_short_description_4(jsonObject.getString("job_short_description_4"));
            setJob_short_description_5(jsonObject.getString("job_short_description_5"));
            setExp_min_require_year(jsonObject.getString("exp_min_require_year"));
            setExp_max_require_year(jsonObject.getString("exp_max_require_year"));
            setRecord_status(jsonObject.getString("record_status"));
            setDeleted(jsonObject.getString("deleted"));
            setJob_position(jsonObject.getString("job_position"));
            setJob_position_id(jsonObject.getString("job_position_id"));
            setHash_tag(jsonObject.getString("hash_tag"));
            setHas_modify(jsonObject.getString("has_modify"));
            setIs_demo(jsonObject.getString("is_demo"));
            setApproved_time(jsonObject.getString("approved_time"));
            setJob_image(jsonObject.getString("job_image"));
            setIs_job_love(jsonObject.getString("is_job_love"));
            setSalary_description(jsonObject.getString("salary_description"));
            setPaused(jsonObject.getString("paused"));
            ShareInfoObj shareInfoObj = new ShareInfoObj();
            shareInfoObj.parseJsonToObject(jsonObject.getJSONObject("share_info"));
            setShare_info(shareInfoObj);
        } catch (Exception e) {
        //    HopeLog.e(e);
        }
    }
}
