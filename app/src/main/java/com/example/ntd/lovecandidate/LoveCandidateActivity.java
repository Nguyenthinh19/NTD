package com.example.ntd.lovecandidate;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;

import com.example.ntd.R;

public class LoveCandidateActivity extends AppCompatActivity {

    private Context context;
    private LoveCandidateFragment loveCandidateFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_love_candidate);

        context = LoveCandidateActivity.this;
        loveCandidateFragment = new LoveCandidateFragment();
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

}
