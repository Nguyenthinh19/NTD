package com.example.ntd.configs;

import android.app.NotificationManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.preference.PreferenceManager;
import android.util.Log;

import com.example.ntd.objects.User;

import java.util.Locale;
import java.util.UUID;



/**
 * Created by vietn on 28/06/2016.
 */
public class AppSettings {

    public static final String LANG_VI = "vi";
    public static final String LANG_EN = "en";

    public static final String KEY_LANG = "en";
    public static final String KEY_FB_TOKEN = "fb_token";
    public static final String KEY_RANGE = "range";
    public static final String USER_CHAT_FILE_NAME = "hopecms.dat";
    public static final String HOPE_TOKEN_FILE_NAME = "hopetk.dat";
    public static final String DEVICE_TOKEN_FILE_NAME = "dvtk.dat";
    private static final String KEY_FB_ENABLE = "9asd79s0a87";
    public static final String HOPE_TRACKING_ID_FILENAME = "hopetid.dat";
    public static final String MARK_RESTART = "mrs.dat";

    public static final int DEFAULT_RANGE = 10;

    Context mContext;
    SharedPreferences mSharedPreferences;
    SharedPreferences.Editor mEditor;

    //Lang
    private OnLanguageChangedListenter mLanguageChangedListenter;

    public AppSettings(Context context){
        mContext = context;
        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(mContext);
        mEditor = mSharedPreferences.edit();
    }

    public void setFbToken(String token){
        mEditor.putString(KEY_FB_TOKEN, token);
        mEditor.apply();
    }

    public void saveFireBaseStatus(boolean status){
        mEditor.putBoolean(KEY_FB_ENABLE, status);
        mEditor.commit();
    }

    /**
     * Tracking userID
     */
    public static void saveTrackingID(Context context, String token){
        FileHelper.saveToFile(context, HOPE_TRACKING_ID_FILENAME, token);
        Log.i("saveHopeToken", token);
    }

    public static String getTrackingID(Context context){
        return FileHelper.readFile(context, HOPE_TRACKING_ID_FILENAME);
    }

    public String getFbToken(){
        return mSharedPreferences.getString(KEY_FB_TOKEN, null);
    }

    /**
     * Thiết lập ngôn ngữ cho app
     * @param lang mặc định AppSettings.LANG_VI
     */
    public void setLanguage(String lang){
        Locale locale = new Locale(lang);
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale = locale;
        mContext.getApplicationContext().getResources().updateConfiguration(config, null);
        mEditor.putString(KEY_LANG, lang).apply();
        if(mLanguageChangedListenter != null){
            mLanguageChangedListenter.onLanguageChanged(lang);
        }
    }

    /**
     * Trả về ngôn ngữ hiện tại của app
     */

    public String getCurrentLanguage(){
        return mSharedPreferences.getString(KEY_LANG, LANG_VI);
    }

    public void loadLanguage(){
        setLanguage(getCurrentLanguage());
    }

    /**
     * Cài đặt lắng nghe sự kiện khi thay đổi ngôn ngữ
     */
    public void setLanguageChangedListenter(OnLanguageChangedListenter listenter){
        mLanguageChangedListenter = listenter;
    }

    public interface OnLanguageChangedListenter{
        public void onLanguageChanged(String lang);
    }

    public static boolean logout(Context context){
        try {
            PreferenceManager.getDefaultSharedPreferences(context).edit().clear().commit();
            context.deleteFile(User.USER_FILE);
            context.deleteFile(USER_CHAT_FILE_NAME);
            context.deleteFile(HOPE_TOKEN_FILE_NAME);
           // context.deleteFile(Employer.EMPLOYER_FILE);
           // context.deleteFile(ContestObj.CONTEST_FILE);
         //   context.deleteFile(ListStatusObj.STATUS_FILE);
//            FirebaseAuth.getInstance().signOut();
            NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
            notificationManager.cancelAll();
            return true;
        }catch (Exception e) {
            e.printStackTrace();
     //       HopeLog.e(e);
        }
        return false;
    }

    public static String MD5(String md5) {
        try {
            java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
            byte[] array = md.digest(md5.getBytes());
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < array.length; ++i) {
                sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1,3));
            }
            return sb.toString();
        } catch (java.security.NoSuchAlgorithmException e) {
        }
        return "";
    }

    public static void saveHopeToken(Context context, String token){
        FileHelper.saveToFile(context, HOPE_TOKEN_FILE_NAME, token);
        Log.i("saveHopeToken", token);
    }

    public static String getHopeToken(Context context){
        return FileHelper.readFile(context, HOPE_TOKEN_FILE_NAME);
    }

    public static String getDeviceToken(Context context){
        try{
            String file = FileHelper.readFile(context, DEVICE_TOKEN_FILE_NAME);
            if(file != null && !file.equals("")){
                return file;
            }else{
                String newToken = genDeviceToken();
                FileHelper.saveToFile(context, DEVICE_TOKEN_FILE_NAME, newToken);
                return newToken;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return "";
    }

    public static void setMarkRestart(Context context, Boolean b){
        try {
            if(b){
                FileHelper.saveToFile(context, MARK_RESTART, "1");
            }else{
                FileHelper.deleteFile(context, MARK_RESTART);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static boolean getMarkRestart(Context context){
        try {
            if(FileHelper.readFile(context, MARK_RESTART).equals("1")){
                setMarkRestart(context, false);
                return true;
            }
        }catch (Exception e){
        }
        return false;
    }

    /**
     * Tạo ra một String ngẫu nhiên duy nhất cho mỗi lần cài đặt
     */
    private static String genDeviceToken(){
        String token = null;
        try{
            String time1 = String.valueOf(System.currentTimeMillis());
            String randomString = UUID.randomUUID().toString();
            String seed = randomString + time1 + "-" + String.valueOf(Math.random());
            Log.i("Main", "seed: " + seed);
            token = MD5(seed) + System.currentTimeMillis();
        }catch (Exception e){
            e.printStackTrace();
        }
        return token;
    }

}
