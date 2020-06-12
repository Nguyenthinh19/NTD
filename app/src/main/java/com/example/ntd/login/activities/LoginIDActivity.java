package com.example.ntd.login.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.ntd.R;
import com.example.ntd.login.fragments.LoginIdView;
import com.example.ntd.login.interfaces.LoginIdInterface;
import com.example.ntd.login.models.LoginIdModel;
import com.example.ntd.objects.User;

public class LoginIDActivity extends AppCompatActivity implements LoginIdInterface.Listener {

    private Context context;
    private LoginIdView loginIdView;
    private LoginIdModel loginIdModel;
    private User user;
    public  boolean mCheck;
    public String mUsername,mPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_id);

        context = LoginIDActivity.this;
        user = User.getLocalUser(context);
        loginIdModel = new LoginIdModel();

        try {
            mCheck = getSharedPreferences("SAVEACC", MODE_PRIVATE).getBoolean("checksave", true);
            mUsername = getSharedPreferences("SAVEACC", MODE_PRIVATE).getString("username", "");
            mPass = getSharedPreferences("SAVEACC", MODE_PRIVATE).getString("pasword", "");
        } catch (Exception e) {
            e.printStackTrace();
        }

        loginIdView = new LoginIdView();
        loginIdView.setListener(this);
        loginIdView.setDatasource(loginIdModel);

        addFragment(R.id.longin_id_contain,loginIdView);
        hideAllFragment();
        showFragment(loginIdView);

    }

    private void hideAllFragment() {
        hideFragment(loginIdView);
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

        loginIdModel.setCheckSave(mCheck);
        loginIdModel.setUserName(mUsername);
        loginIdModel.setPass(mPass);
        loginIdView.loadView();
    }

    @Override
    public void onButtonDangnhapClick() {

        loginIdView.showProgress();
        loginIdModel.login(context, loginIdModel.getUserName(), loginIdModel.getPass(), new LoginIdModel.onExcuteFinish() {

            @Override
            public void Success() {
                loginIdView.hideProgress();
                Intent i = new Intent(context, LoginSucessActivity.class);
                startActivity(i);
                finish();
                getSharedPreferences("SAVEACC", MODE_PRIVATE).edit().putBoolean("checksave", loginIdModel.getCheckSave()).commit();
                getSharedPreferences("SAVEACC", MODE_PRIVATE).edit().putString("username", loginIdModel.getUserName()).commit();
                getSharedPreferences("SAVEACC", MODE_PRIVATE).edit().putString("pasword", loginIdModel.getPass()).commit();

            }

            @Override
            public void Error() {
                Toast.makeText(context, loginIdModel.getMessage(), Toast.LENGTH_SHORT).show();
                loginIdView.hideProgress();
            }

            @Override
            public void ErrorNet() {
                loginIdView.hideProgress();
            }
        });
    }

    @Override
    public void onButtonBackClick() {
        onBackPressed();

    }

    @Override
    public void onBackPressed() {
        Intent i = new Intent(this, LoginActivity.class);
        startActivity(i);
        finish();
    }
}
