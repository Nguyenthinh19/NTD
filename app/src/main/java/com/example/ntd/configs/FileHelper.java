package com.example.ntd.configs;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.Reader;

/**
 * Created by vietn on 22/07/2016.
 */
public class FileHelper {
    private static final String TAG = "FileHelper";

    public static String readFile(Context context, String fileName){
        String string = "";
        try {
            FileInputStream fis = context.openFileInput(fileName);
            Log.i(TAG, "readFile: " + fileName);
            string = getFileContent(fis);
            fis.close();
        } catch (Exception e) {
            Log.e(TAG, "readFile fail: " + fileName);
        }
        return string;
    }

    public static boolean saveToFile(Context context, String fileName, String data){
        try {
            FileOutputStream fos = context.openFileOutput(fileName, Context.MODE_PRIVATE);
            fos.write(data.getBytes());
            fos.close();
            Log.i(TAG, "saveToFile: " + fileName + " data: "+ data);
            return true;
        } catch (Exception e) {
            Log.e(TAG, "saveToFile fail: " + fileName);
        }
        return false;
    }

    public static String deleteFile(Context context, String fileName){
        String string = "";
        try {
            context.deleteFile(fileName);
            Log.e(TAG, "deleteFile: " + fileName);
        } catch (Exception e) {
            Log.e(TAG, "deleteFile fail: " + fileName);
        }
        return string;
    }

    public static boolean saveTempBitmap(Context context, Bitmap bitmap){
        try {
            FileOutputStream fos = context.openFileOutput("temp.png", Context.MODE_PRIVATE);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 40, fos);
            fos.close();
            Log.i(TAG, "saveTempBitmap");
            return true;
        } catch (Exception e) {
            Log.e(TAG, "saveTempBitmap fail");
        }
        return false;
    }

    private static String getFileContent(FileInputStream fis ) {
        String string = null;
        try {
            StringBuilder sb = new StringBuilder();
            Reader r = new InputStreamReader(fis, "UTF-8");
            BufferedReader reader = new BufferedReader(r);
            String line;
            while ((line = reader.readLine()) != null ){
                sb.append(line);
            }
            string = sb.toString();
        } catch (Exception e){
//            e.printStackTrace();
            Log.i("getFileContent", "no content");
        }
        Log.i("data", string);
        return string;
    }

}
