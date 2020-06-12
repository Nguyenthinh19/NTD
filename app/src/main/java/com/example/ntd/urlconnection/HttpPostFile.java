package com.example.ntd.urlconnection;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.OpenableColumns;
import android.util.Log;
import android.util.Pair;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by vietn on 01/08/2016.
 */
public class HttpPostFile {
    private static final String TAG = "HttpPostFile";

    private ArrayList<Pair<String, String>> mProperties = new ArrayList<>();
    protected ArrayList<Pair<String, String>> mParameters = new ArrayList<>();
    private ArrayList<Pair<String, Uri>> mFiles = new ArrayList<>();

    private String lineEnd = "\r\n";
    private String twoHyphens = "--";
    private String boundary = "*****";

    private DataOutputStream outputStream;
    private int maxBufferSize = 1 * 1024 * 1024;

    private Context mContext;

    public HttpPostFile(Context context) {
        mContext = context;
    }

    public String request(String urlString) {
        try {
            URL url = new URL(urlString);
            HttpURLConnection client = (HttpURLConnection) url.openConnection();
            client.setRequestMethod("POST");
            for (int i = 0; i < mProperties.size(); i++) {
                client.addRequestProperty(mProperties.get(i).first, mProperties.get(i).second);
            }
            client.setRequestProperty("Connection", "Keep-Alive");
            client.setRequestProperty("Content-Type", "multipart/form-data;boundary=" + boundary);
            outputStream = new DataOutputStream(client.getOutputStream());
            buildAllParameters();
            buildAllFiles(client);
            outputStream.writeBytes(twoHyphens + boundary + twoHyphens + lineEnd);
            outputStream.flush();
            outputStream.close();
            //Get Response
            return readInputStreamToString(client.getInputStream());

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private String readInputStreamToString(InputStream inputStream) {
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
        } catch (Exception e) {
            Log.i(TAG, "Error reading InputStream");
            result = "";
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    Log.i(TAG, "Error closing InputStream");
                }
            }
        }
        return result;

    }

    private void buildAllFiles(HttpURLConnection client) throws Exception {
        for (int i = 0; i < mFiles.size(); i++) {
            addInputStream(mFiles.get(i).first, mFiles.get(i).second, client);
        }
    }

    private String getFileName(Uri uri) {
        String result = null;
        if (uri.getScheme().equals("content")) {
            Cursor cursor = mContext.getContentResolver().query(uri, null, null, null, null);
            try {
                if (cursor != null && cursor.moveToFirst()) {
                    result = cursor.getString(cursor.getColumnIndex(OpenableColumns.DISPLAY_NAME));
                }
            } finally {
                cursor.close();
            }
        }
        if (result == null) {
            result = uri.getPath();
            int cut = result.lastIndexOf('/');
            if (cut != -1) {
                result = result.substring(cut + 1);
            }
        }
        return result;
    }

    private void addInputStream(String key, Uri uri, HttpURLConnection client) throws Exception {
        int bytesRead, bytesAvailable, bufferSize;
        byte[] buffer;

        InputStream inputStream = mContext.getContentResolver().openInputStream(uri);
        String fileName = getFileName(uri);

//        client.setDoInput(true);
//        client.setDoOutput(true);
//        client.setUseCaches(false);

        outputStream.writeBytes(twoHyphens + boundary + lineEnd);
        outputStream.writeBytes("Content-Disposition: form-data; name=\"" + key + "\";filename=\"" + fileName + "\"" + lineEnd);
        outputStream.writeBytes(lineEnd);

        bytesAvailable = inputStream.available();
        bufferSize = Math.min(bytesAvailable, maxBufferSize);
        buffer = new byte[bufferSize];

        // Read file
        bytesRead = inputStream.read(buffer, 0, bufferSize);

        while (bytesRead > 0) {
            outputStream.write(buffer, 0, bufferSize);
            bytesAvailable = inputStream.available();
            bufferSize = Math.min(bytesAvailable, maxBufferSize);
            bytesRead = inputStream.read(buffer, 0, bufferSize);
        }

        outputStream.writeBytes(lineEnd);
        inputStream.close();
    }

    public void addFile(String key, Uri uri) {
        mFiles.add(new Pair<String, Uri>(key, uri));
    }

    public ArrayList<Pair<String, Uri>> getFiles() {
        return mFiles;
    }

    public void setFiles(ArrayList<Pair<String, Uri>> files) {
        mFiles = files;
    }

    private void buildAllParameters() throws Exception {
        for (int i = 0; i < mParameters.size(); i++) {
            addFormField(mParameters.get(i).first, mParameters.get(i).second);
        }
    }

    private void addFormField(String name, String value) throws Exception {
        outputStream.writeBytes(twoHyphens + boundary + lineEnd);
        outputStream.writeBytes("Content-Disposition: form-data; name=\"" + name + "\"" + lineEnd);
        outputStream.writeBytes("Content-Type: text/plain; charset=UTF-8" + lineEnd);
        outputStream.writeBytes(lineEnd);
        outputStream.write(value.getBytes("utf-8"));
        outputStream.writeBytes(lineEnd);

    }

    public ArrayList<Pair<String, String>> getParameters() {
        return mParameters;
    }

    public void setParameters(ArrayList<Pair<String, String>> parameters) {
        this.mParameters = parameters;
    }

    public void addRequestProperty(String key, String value) {
        mProperties.add(new Pair<String, String>(key, value));
    }
}
