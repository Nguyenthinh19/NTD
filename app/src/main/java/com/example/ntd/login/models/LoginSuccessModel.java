package com.example.ntd.login.models;

import com.example.ntd.login.interfaces.LoginSuccessInterface;

public class LoginSuccessModel implements LoginSuccessInterface.Datasource  {
    private String mNameUser;
    private String mPosition;
    private String mImage;

    @Override
    public String getNameUser() {
        return mNameUser;
    }

    @Override
    public void setNameUser(String nameUser) {
        this.mNameUser = nameUser;
    }

    @Override
    public String getPosition() {
        return mPosition;
    }

    @Override
    public void setPosition(String position) {
        this.mPosition = position;
    }

    @Override
    public String getImageUser() {
        return mImage;
    }

    @Override
    public void setImageUser(String image) {
        this.mImage = image;
    }


}
