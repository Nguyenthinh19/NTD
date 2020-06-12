package com.example.ntd.urlconnection;

import android.content.Context;
import android.os.AsyncTask;

import java.io.IOException;

import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class PostUser  {

    OkHttpClient okHttpClient = new OkHttpClient.Builder().build();
    public String user,password,hopeToken;
    Context context;

    public PostUser(Context context) {
        this.context = context;
    }

    public String post(String url, String user, String password,String hopeToken)  {

        RequestBody requestBody = new MultipartBody.Builder()
                .addFormDataPart("hopeToken",hopeToken)
                .addFormDataPart("username",user)
                .addFormDataPart("password",password)
                .setType(MultipartBody.FORM)
                .build();

        Request request = new Request.Builder()
                .url(url)
                .post(requestBody)
                .build();
        try {
            Response response = okHttpClient.newCall(request).execute();
            return response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;

    }

    /*@Override
    protected String doInBackground(String... strings) {
        RequestBody requestBody = new MultipartBody.Builder()
                .addFormDataPart("hopeToken",hopeToken)
                .addFormDataPart("username",user)
                .addFormDataPart("password",password)
                .setType(MultipartBody.FORM)
                .build();

        Request request = new Request.Builder()
                .url(strings[0])
                .post(requestBody)
                .build();

        try {
            Response response = okHttpClient.newCall(request).execute();
            return response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }*/

}
