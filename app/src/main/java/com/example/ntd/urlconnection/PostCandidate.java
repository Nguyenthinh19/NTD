package com.example.ntd.urlconnection;

import android.content.Context;

import java.io.IOException;
import java.net.ContentHandler;

import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class PostCandidate {

    OkHttpClient okHttpClient = new OkHttpClient.Builder().build();
    public String status;
    public int page;
    Context context;

    public PostCandidate(Context context) {
        this.context = context;
    }

    public String post(String hopeToken,String url, String status, int page, String subemployer_id  )  {

        RequestBody requestBody = new MultipartBody.Builder()
                .addFormDataPart("status",status)
                .addFormDataPart("page",page+"")
                .addFormDataPart("subemployer_id",subemployer_id)
                .addFormDataPart("hope-token",hopeToken)
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
}
