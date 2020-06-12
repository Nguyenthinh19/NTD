package com.example.ntd.login.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.example.ntd.R;
import com.example.ntd.login.fragments.LoginView;
import com.example.ntd.login.interfaces.LoginInterface;
import com.example.ntd.login.models.LoginModel;

public class LoginActivity extends AppCompatActivity implements LoginInterface.Listener {

    private Context mContext;
    private LoginView loginView;
    private LoginModel loginModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mContext = LoginActivity.this;

        loginModel = new LoginModel();

        loginView = new LoginView();
        loginView.setDatasource(loginModel);
        loginView.setListener(this);

        addFragment(R.id.login_main,loginView);
        hideAllFragment();
        showFragment(loginView);
    }

    private void hideAllFragment() {
        hideFragment(loginView);
    }

    private void hideFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().hide(fragment).commit();
    }

    private void showFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().show(fragment).commit();
    }

    private void addFragment(int contain, Fragment fragment) {
        getSupportFragmentManager().beginTransaction().add(contain,fragment).commit();
    }

    @Override
    public void onLoadViewFinish() {
     loginView.loadView();
    }

    @Override
    public void onButtonDangnhapClick() {
        Intent intent = new Intent(this,LoginIDActivity.class);
        startActivity(intent);
        finish();
    }
}
