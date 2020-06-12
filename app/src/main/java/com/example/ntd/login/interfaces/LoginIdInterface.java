package com.example.ntd.login.interfaces;

public class LoginIdInterface {

    public interface Listener {

        void onLoadViewFinish();

        void onButtonDangnhapClick();

        void onButtonBackClick();
    }

    public interface Datasource {
        String getUserName();

        void setUserName(String userName);

        String getPass();

        void setPass(String pass);

        String getMessage();

        void setMessage(String message);

        void setCheckSave(boolean check);

        boolean getCheckSave();

    }

}
