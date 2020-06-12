package com.example.ntd.login.models;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.util.Pair;

import com.example.ntd.HopeBuildConfig;
import com.example.ntd.configs.AppSettings;
import com.example.ntd.login.interfaces.LoginIdInterface;
import com.example.ntd.objects.User;
import com.example.ntd.urlconnection.HttpClient;
import com.example.ntd.urlconnection.PostUser;

import org.json.JSONObject;

import java.util.ArrayList;

public class LoginIdModel implements LoginIdInterface.Datasource {

    private String mUsername;
    private String mPass;
    private boolean mCheck;
    private String mMessagge;

    @Override
    public String getUserName() {
        return mUsername;
    }

    @Override
    public void setUserName(String userName) {
        this.mUsername = userName;
    }

    @Override
    public String getPass() {
        return mPass;
    }

    @Override
    public void setPass(String pass) {
        this.mPass = pass;
    }

    @Override
    public String getMessage() {
        return mMessagge;
    }

    @Override
    public void setMessage(String message) {
        this.mMessagge = message;
    }

    @Override
    public void setCheckSave(boolean check) {
        this.mCheck = check;
    }

    @Override
    public boolean getCheckSave() {
        return mCheck;
    }

    public interface onExcuteFinish {

        void Success();

        void Error();
 //       https://dev-admin.jobsgo.vn/employerapi/employer-login/login?username=hoang.nguyen&password=564329
        void ErrorNet();

    }

    public void login(final Context context, final String user, final String pass, final onExcuteFinish finish) {
        class HopeRequest1 extends AsyncTask {

            private String API_SERVER = "https://dev-admin.jobsgo.vn/employerapi/employer-login/login";

            private String mHopeToken = "hopejob2017702725";
//hope-token/hopejob2017702725
            @Override
            protected void onPreExecute() {

            }

            @Override
            protected Object doInBackground(Object[] objects) {

                PostUser postUser = new PostUser(context);
                return postUser.post(API_SERVER,user,pass,mHopeToken);
            }
            @Override
            protected void onPostExecute(Object o) {
                try{
                    JSONObject jsonObject = new JSONObject((String)o);
                    if(jsonObject.getInt("status") == -1){
                        //trường hợp api yêu cầu login lại
                   //     restartApp();
                        return;
                    }
                    try {
                        int status = jsonObject.getInt("status");
                        if (status == 1) {

                            JSONObject data = jsonObject.getJSONObject("data");
                            User user = User.getFromJson(data);
                            user.saveToLocal(context);
                            AppSettings.saveTrackingID(context, user.getSubemployer_id());
                            JSONObject employer = data.getJSONObject("employer");
                        //    Employer employer_obj = Employer.getFromJson(employer);
                          //  employer_obj.saveToLocal(context);
                            String hope_token = jsonObject.getString("hope_token");
                            AppSettings.saveHopeToken(context,hope_token);

                            String fbToken = jsonObject.getJSONObject("data").getString("chat_fb_token");
                            new AppSettings(context).setFbToken(fbToken);
                            finish.Success();
                        }
                        if (status == 0) {
                            setMessage(jsonObject.getString("message"));
                            finish.Error();
                        }
                    } catch (Exception e) {
                        finish.Error();
                //        HopeLog.e(e);
                    }
                    return;
                }catch (Exception e) {
                    e.printStackTrace();
             //       HopeLog.e(e);
                }
                finish.ErrorNet();
            }
        }
        new  HopeRequest1().execute();
    }


}
