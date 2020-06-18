package com.example.ntd.lovecandidate;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Toast;

import com.example.ntd.R;
import com.example.ntd.base.BaseActivity;

public class LoveCandidateActivity extends BaseActivity implements LoveCandidateInterface.Listener {

    private Context context;
    private LoveCandidateFragment loveCandidateFragment;
    private LoveCandidateModel model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_love_candidate);

        context = LoveCandidateActivity.this;
        model = new LoveCandidateModel();

        loveCandidateFragment = new LoveCandidateFragment();
        loveCandidateFragment.setDatasource(model);
        loveCandidateFragment.setListener(this);
        addFragment(R.id.love_candidate_contain,loveCandidateFragment);
        hideAllFragment();
        showFragment(loveCandidateFragment);

    }

    public void addFragment(int contain, Fragment fragment) {
        getSupportFragmentManager().beginTransaction().add(contain, fragment).commit();
    }

    private void showFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().show(fragment).commit();
    }

    private void hideFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().hide(fragment).commit();
    }

    private void hideAllFragment() {
        hideFragment(loveCandidateFragment);
    }

    @Override
    public void onLoadViewFinish() {
        model.loadLoveCandidate(context, new LoveCandidateModel.onExcuteFinish() {
            @Override
            public void Success() {
                loveCandidateFragment.loadView();
            }

            @Override
            public void Error() {
                Toast.makeText(context, getString(R.string.error), Toast.LENGTH_SHORT).show();

            }
        });

    }

    @Override
    public void onButtonBackClick() {
        finish();
    }

    @Override
    public void onItemCLick() {

    }

    @Override
    public void onButtonTKClick() {

    }

    @Override
    public void onButtonCancel() {

    }

    @Override
    public void onLoadMoreLoveCandidate() {

    }

    @Override
    public void onLoadMoreSearch() {

    }

    @Override
    public void onButtonSearchClick() {

    }

    @Override
    public void onLoadJob() {

    }

    @Override
    public void onLoadMoreJob() {

    }

    @Override
    public void onGioithieuClick() {

    }

    @Override
    public void onMoiChatClick() {

    }

    @Override
    public void onXoaClick() {

    }

    @Override
    public void onDSJobBackClick() {

    }

    @Override
    public void onButtonSendClick() {

    }
}
