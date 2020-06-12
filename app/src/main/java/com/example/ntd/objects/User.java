package com.example.ntd.objects;

import android.content.Context;
import android.util.Log;

import com.example.ntd.configs.AppSettings;
import com.example.ntd.configs.FileHelper;
import com.google.gson.Gson;

import org.json.JSONObject;


/**
 * Created by vietn on 14/12/2016.
 */
public class User implements Cloneable {
    String subemployer_id;
    String employer_id;
    String user_name;
    String name;
    String email;
    String tel;
    String function;
    String created;
    String updated;
    String password_reset_token;
    String role;
    String referal_id;
    String date_of_birth;
    String avatar;
    String accept_email;
    String chat_username;
    String chat_fb_token;
    String version_code;
    String share_app_url;
    String share_app_title;
    String share_app_image;
    String share_app_description;
    String candidate_view_by_employer;

    public String getCandidate_view_by_employer() {
        return candidate_view_by_employer;
    }

    public void setCandidate_view_by_employer(String candidate_view_by_employer) {
        this.candidate_view_by_employer = candidate_view_by_employer;
    }

    public String getSubemployer_id() {
        return subemployer_id;
    }

    public void setSubemployer_id(String subemployer_id) {
        this.subemployer_id = subemployer_id;
    }

    public String getEmployer_id() {
        return employer_id;
    }

    public void setEmployer_id(String employer_id) {
        this.employer_id = employer_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
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

    public String getPassword_reset_token() {
        return password_reset_token;
    }

    public void setPassword_reset_token(String password_reset_token) {
        this.password_reset_token = password_reset_token;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getReferal_id() {
        return referal_id;
    }

    public void setReferal_id(String referal_id) {
        this.referal_id = referal_id;
    }

    public String getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(String date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getAccept_email() {
        return accept_email;
    }

    public void setAccept_email(String accept_email) {
        this.accept_email = accept_email;
    }

    public String getChat_username() {
        return chat_username;
    }

    public void setChat_username(String chat_username) {
        this.chat_username = chat_username;
    }

    public String getChat_fb_token() {
        return chat_fb_token;
    }

    public void setChat_fb_token(String chat_fb_token) {
        this.chat_fb_token = chat_fb_token;
    }

    public String getVersion_code() {
        return version_code;
    }

    public void setVersion_code(String version_code) {
        this.version_code = version_code;
    }

    public String getShare_app_url() {
        return share_app_url;
    }

    public void setShare_app_url(String share_app_url) {
        this.share_app_url = share_app_url;
    }

    public String getShare_app_title() {
        return share_app_title;
    }

    public void setShare_app_title(String share_app_title) {
        this.share_app_title = share_app_title;
    }

    public String getShare_app_image() {
        return share_app_image;
    }

    public void setShare_app_image(String share_app_image) {
        this.share_app_image = share_app_image;
    }

    public String getShare_app_description() {
        return share_app_description;
    }

    public void setShare_app_description(String share_app_description) {
        this.share_app_description = share_app_description;
    }

    public static final String USER_FILE = "user.dat";

    public static User getLocalUser(Context context) {
        Log.i("user", "getLocalUser");
//        if(HopeClient.getTempUser() == null){
        String data = FileHelper.readFile(context, USER_FILE);
        Gson gson = new Gson();
        User newUser = gson.fromJson(data, User.class);
//            HopeClient.setTempUser(newUser);
        return newUser;
//        }
//        return HopeClient.getTempUser();
    }

    public static User getFromJson(JSONObject jsonObject) {
        User user = new Gson().fromJson(jsonObject.toString(), User.class);
        //HopeClient.setTempUser(user);
        return user;
    }

    public void saveToLocal(final Context context) {
        Log.i("user", "saveToLocal");
        Gson gson = new Gson();
        FileHelper.saveToFile(context, USER_FILE, gson.toJson(User.this).toString());
        //lưu Chat ID
        if(this.getChat_username() != null && !this.getChat_username().isEmpty()){
            FileHelper.saveToFile(context, AppSettings.USER_CHAT_FILE_NAME, this.getChat_username());
        }
//        HopeClient.setTempUser(this);
//        Thread thread = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try{
//                    Gson gson = new Gson();
//                    FileHelper.saveToFile(context, USER_FILE, gson.toJson(User.this).toString());
//                }catch (Exception e){
//                    e.printStackTrace();
//                    HopeLog.e(e);
//                }
//            }
//        });
//        thread.start();
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public User cloneThis()throws CloneNotSupportedException {
        return (User) clone();
    }
}
