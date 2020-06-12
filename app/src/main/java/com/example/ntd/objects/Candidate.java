package com.example.ntd.objects;

import java.util.List;

/**
 * Created by vietn on 07/02/2017.
 */
public class Candidate {

    public static final String MALE = "male";
    public static final String FEMALE = "female";

    String candidate_id;
    String name;
    String avatar;
    String date_of_birth;
    String current_city;
    String email;
    String tel;
    String short_bio;
    String current_salary;
    String language;
    String degree;
    String degree_id;
    String min_expect_salary;
    String max_expect_salary;
    String job_type;
    String job_type_id;
    String status;
    String gender;
    String current_address;
    String job_position;
    String job_position_id;
    String chat_username;
    List<JobCategory> job_category;
    List<UserPlaceObj> job_place;
    List<JobApplied> job_applied;
    List<JobApplied> job_apply;
    List<Education> education;
    List<JobHistory> job_history;
   /* List<JobLanguage> job_language;
    String candidate_view_by_employer = "0";
    List<JobApplied> job_apply;
    List<JobApplied> job_suggest;*/
    String facebook_url;
    String count_employer_view_profile = "0";
    boolean allow_to_call;
   // List<JobApplied> job_relate;
    String no_job_history;
   // Contact contact;
    boolean from_headhunter;
    boolean need_confirm_headhunter;
    boolean highlight_file;
    String message_confirm_headhunter;
    String headhunter_icon;

    public String getHeadhunter_icon() {
        return headhunter_icon;
    }

    public void setHeadhunter_icon(String headhunter_icon) {
        this.headhunter_icon = headhunter_icon;
    }

    public boolean isHighlight_file() {
        return highlight_file;
    }

    public void setHighlight_file(boolean highlight_file) {
        this.highlight_file = highlight_file;
    }

    public String getMessage_confirm_headhunter() {
        return message_confirm_headhunter;
    }

    public void setMessage_confirm_headhunter(String message_confirm_headhunter) {
        this.message_confirm_headhunter = message_confirm_headhunter;
    }

    public boolean isNeed_confirm_headhunter() {
        return need_confirm_headhunter;
    }

    public void setNeed_confirm_headhunter(boolean need_confirm_headhunter) {
        this.need_confirm_headhunter = need_confirm_headhunter;
    }

    public boolean isFrom_headhunter() {
        return from_headhunter;
    }

    public void setFrom_headhunter(boolean from_headhunter) {
        this.from_headhunter = from_headhunter;
    }

  /*  public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }*/

    public String getNo_job_history() {
        return no_job_history;
    }

    public void setNo_job_history(String no_job_history) {
        this.no_job_history = no_job_history;
    }

 /*   public List<JobApplied> getJob_relate() {
        return job_relate;
    }

    public void setJob_relate(List<JobApplied> job_relate) {
        this.job_relate = job_relate;
    }*/

    public boolean isAllow_to_call() {
        return allow_to_call;
    }

    public void setAllow_to_call(boolean allow_to_call) {
        this.allow_to_call = allow_to_call;
    }

    public String getCount_employer_view_profile() {
        return count_employer_view_profile;
    }

    public void setCount_employer_view_profile(String count_employer_view_profile) {
        this.count_employer_view_profile = count_employer_view_profile;
    }

  /*  public List<JobApplied> getJob_suggest() {
        return job_suggest;
    }

    public void setJob_suggest(List<JobApplied> job_suggest) {
        this.job_suggest = job_suggest;
    }

    public List<JobApplied> getJob_apply() {
        return job_apply;
    }

    public void setJob_apply(List<JobApplied> job_apply) {
        this.job_apply = job_apply;
    }

    public String getCandidate_view_by_employer() {
        return candidate_view_by_employer;
    }

    public void setCandidate_view_by_employer(String candidate_view_by_employer) {
        this.candidate_view_by_employer = candidate_view_by_employer;
    }

    public List<JobLanguage> getJob_language() {
        return job_language;
    }

    public void setJob_language(List<JobLanguage> job_language) {
        this.job_language = job_language;
    }

    public List<JobHistory> getJob_history() {
        return job_history;
    }

    public void setJob_history(List<JobHistory> job_history) {
        this.job_history = job_history;
    }

    public List<Education> getEducation() {
        return education;
    }

    public void setEducation(List<Education> education) {
        this.education = education;
    }

    public List<JobApplied> getJob_applied() {
        return job_applied;
    }

    public void setJob_applied(List<JobApplied> job_applied) {
        this.job_applied = job_applied;
    }

    public List<UserPlaceObj> getJob_place() {
        return job_place;
    }

    public void setJob_place(List<UserPlaceObj> job_place) {
        this.job_place = job_place;
    }

    public List<JobCategory> getJob_category() {
        return job_category;
    }

    public void setJob_category(List<JobCategory> job_category) {
        this.job_category = job_category;
    }*/
    public List<JobHistory> getJob_history() {
        return job_history;
    }

    public void setJob_history(List<JobHistory> job_history) {
        this.job_history = job_history;
    }
    public List<Education> getEducation() {
        return education;
    }

    public void setEducation(List<Education> education) {
        this.education = education;
    }


    public List<JobApplied> getJob_apply() {
      return job_apply;
    }

    public void setJob_apply(List<JobApplied> job_apply) {
        this.job_apply = job_apply;
    }

    public List<JobCategory> getJob_category() {
        return job_category;
    }
    public void setJob_category(List<JobCategory> job_category) {
        this.job_category = job_category;
    }
    public List<UserPlaceObj> getJob_place() {
        return job_place;
    }

    public void setJob_place(List<UserPlaceObj> job_place) {
        this.job_place = job_place;
    }

    public String getCandidate_id() {
        return candidate_id;
    }

    public void setCandidate_id(String candidate_id) {
        this.candidate_id = candidate_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(String date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public String getCurrent_city() {
        return current_city;
    }

    public void setCurrent_city(String current_city) {
        this.current_city = current_city;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getShort_bio() {
        return short_bio;
    }

    public void setShort_bio(String short_bio) {
        this.short_bio = short_bio;
    }

    public String getCurrent_salary() {
        return current_salary;
    }

    public void setCurrent_salary(String current_salary) {
        this.current_salary = current_salary;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getDegree_id() {
        return degree_id;
    }

    public void setDegree_id(String degree_id) {
        this.degree_id = degree_id;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCurrent_address() {
        return current_address;
    }

    public void setCurrent_address(String current_address) {
        this.current_address = current_address;
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

    public String getChat_username() {
        return chat_username;
    }

    public void setChat_username(String chat_username) {
        this.chat_username = chat_username;
    }

    public String getFacebook_url() {
        return facebook_url;
    }

    public void setFacebook_url(String facebook_url) {
        this.facebook_url = facebook_url;
    }
}
