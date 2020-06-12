package com.example.ntd.urlconnection;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import android.util.Pair;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by vietn on 07/06/2016.
 */
public class HttpClient {
    private static final String TAG = "HttpClient";

    public static final String KEY_POST = "POST";
    public static final String KEY_GET = "GET";

    protected ArrayList<Pair<String, String>> mProperties = new ArrayList<>();
    protected ArrayList<Pair<String, String>> mParameters = new ArrayList<>();
    protected ArrayList<Pair<String, Uri>> mFiles = new ArrayList<>();

    String lineEnd = "\r\n";
    String twoHyphens = "--";
    String boundary =  "*****";

    DataOutputStream outputStream;
    int maxBufferSize = 1*1024*1024;

    Context mContext;

    public HttpClient(Context context){
        mContext = context;
    }

    private String request(String urlString, String method) {
        try{
            URL url = new URL(urlString);
            HttpURLConnection client = (HttpURLConnection) url.openConnection();
            client.setConnectTimeout(120000);
            client.setReadTimeout(120000);
            client.setRequestMethod(method);
            for (int i = 0; i < mProperties.size(); i++) {
                client.addRequestProperty(mProperties.get(i).first, mProperties.get(i).second);
            }

            if(method.equals("POST")){
                outputStream(client.getOutputStream());
//                client.setRequestProperty("Connection", "Keep-Alive");
//                client.setRequestProperty("Content-Type", "multipart/form-data;boundary="+boundary);
//                outputStream = new DataOutputStream( client.getOutputStream() );
//                buildAllParameters();
//                buildAllFiles(client);
//                outputStream.writeBytes(twoHyphens + boundary + twoHyphens + lineEnd);
//                outputStream.flush();
//                outputStream.close();
            }

            //Get Response
            return readInputStreamToString(client.getInputStream());
        }catch (Exception e) {
            e.printStackTrace();
        }
        return "";

    }

    private String readInputStreamToString(InputStream inputStream){
        String result = null;
        StringBuffer sb = new StringBuffer();
        InputStream is = null;

        try {
            is = new BufferedInputStream(inputStream);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String inputLine = "";
            while ((inputLine = br.readLine()) != null) {
                sb.append(inputLine);
            }
            result = sb.toString();
        }
        catch (Exception e) {
            Log.i(TAG, "Error reading InputStream");
            result = "";
        }
        finally {
            if (is != null) {
                try {
                    is.close();
                }
                catch (IOException e) {
                    Log.i(TAG, "Error closing InputStream");
                }
            }
        }
        return result;

    }

    private String getEncodedQuery(){
        Uri.Builder builder = new Uri.Builder();
        if(!mParameters.isEmpty()){
            for (int i = 0; i < mParameters.size(); i++) {
                builder.appendQueryParameter(mParameters.get(i).first, mParameters.get(i).second);
            }
        }
        return builder.build().getEncodedQuery();
    }

    private void outputStream(OutputStream os) throws IOException {
        BufferedWriter writer = new BufferedWriter(
                new OutputStreamWriter(os, "UTF-8"));
        writer.write(getEncodedQuery());
        writer.flush();
        writer.close();
        os.close();
    }

//    private void buildAllParameters() throws Exception {
//        for (int i = 0; i < mParameters.size(); i++) {
//            addFormField(mParameters.get(i).first, mParameters.get(i).second);
//        }
//    }

//    private void addFormField(String name, String value) throws Exception {
//        outputStream.writeBytes(twoHyphens + boundary + lineEnd);
//        outputStream.writeBytes("Content-Disposition: form-data; name=\"" + name + "\"" + lineEnd);
//        outputStream.writeBytes("Content-Type: text/plain; charset=UTF-8" + lineEnd);
//        outputStream.writeBytes(lineEnd);
//        outputStream.writeBytes(value + lineEnd);
//
//    }

    public void addRequestProperty(String key, String value){
        mProperties.add(new Pair<String, String>(key, value));
    }

    public void clearAllProperty(){
        mProperties.clear();
    }

    public void addParameter(String key, String value){
        mParameters.add(new Pair<String, String>(key, value));
    }

    public void clearAllParameter(){
        mParameters.clear();
    }

    public ArrayList<Pair<String, String>> getProperties() {
        return mProperties;
    }

    public void setProperties(ArrayList<Pair<String, String>> properties) {
        this.mProperties = properties;
    }

    public ArrayList<Pair<String, String>> getParameters() {
        return mParameters;
    }

    public void setParameters(ArrayList<Pair<String, String>> parameters) {
        this.mParameters = parameters;
    }

    public String get(String url){
        return request(url, "GET");
    }

    public String post(String url){
        return request(url, "POST");
    }

}
