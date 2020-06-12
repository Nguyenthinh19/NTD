package com.example.ntd.urlconnection;

import android.content.Context;

import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;

public class PostCalendar {
    OkHttpClient okHttpClient = new OkHttpClient.Builder().build();
     Context context;

    public PostCalendar(Context context) {
        this.context = context;
    }

    public String post(String url, String hopeToken, String candidateId, String description, String time, String date, String subemployer_id, String employer_id ) {
        RequestBody requestBody = new MultipartBody.Builder()
                .addFormDataPart("subemployer_id",subemployer_id)
                .addFormDataPart("employer_id",employer_id)
                .addFormDataPart("",subemployer_id)
                .addFormDataPart("hope-token",hopeToken)
                .setType(MultipartBody.FORM)
                .build();
        return null;
    }
}
