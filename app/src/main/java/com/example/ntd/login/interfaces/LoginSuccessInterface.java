package com.example.ntd.login.interfaces;

public class LoginSuccessInterface {
    public  interface Listener{
        void onLoadViewFinish();

        void onButtonEditClick();

        void onButtonKhamphaClick();

        void onImageClick();
    }
    public interface Datasource{
        String getNameUser();

        void setNameUser(String nameUser);

        String getPosition();

        void setPosition(String position);

        String getImageUser();

        void setImageUser(String image);
    }
}
