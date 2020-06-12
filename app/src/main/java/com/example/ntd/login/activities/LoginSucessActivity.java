package com.example.ntd.login.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.example.ntd.HomeActivity;
import com.example.ntd.R;
import com.example.ntd.base.BaseActivity;
import com.example.ntd.login.fragments.LoginSuccessView;
import com.example.ntd.login.interfaces.LoginSuccessInterface;
import com.example.ntd.login.models.LoginSuccessModel;
import com.example.ntd.objects.User;

public class LoginSucessActivity extends BaseActivity implements LoginSuccessInterface.Listener {
    Context mContext;
    LoginSuccessView loginSuccessView;
    LoginSuccessModel loginSuccessModel;
    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_sucess);
        mContext = LoginSucessActivity.this;
        loginSuccessModel = new LoginSuccessModel();

        loginSuccessView = new LoginSuccessView();
        loginSuccessView.setListener(this);
        loginSuccessView.setDatasource(loginSuccessModel);

        addFragment(R.id.login_sucess_cotain, loginSuccessView);
        hideAllFragment();
        showFragment(loginSuccessView);
    }

    private void addFragment(int contain, Fragment fragment) {
        getSupportFragmentManager().beginTransaction().add(contain, fragment).commit();
    }

    private void showFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().show(fragment).commit();
    }

    private void hideFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().hide(fragment).commit();
    }

    private void hideAllFragment() {
        hideFragment(loginSuccessView);
    }

    @Override
    public void onLoadViewFinish() {

    }

    @Override
    public void onButtonEditClick() {

    }

    @Override
    public void onButtonKhamphaClick() {
        Intent intent = new Intent(LoginSucessActivity.this, HomeActivity.class);
        startActivity(intent);

    }

    @Override
    public void onImageClick() {

    }
}
