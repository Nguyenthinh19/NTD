package com.example.ntd.login.fragments;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import com.example.ntd.R;
import com.example.ntd.login.interfaces.LoginIdInterface;

import net.yslibrary.android.keyboardvisibilityevent.KeyboardVisibilityEvent;
import net.yslibrary.android.keyboardvisibilityevent.KeyboardVisibilityEventListener;

public class LoginIdView extends Fragment {

    private LoginIdInterface.Listener listener;
    private LoginIdInterface.Datasource datasource;

    public void setListener(LoginIdInterface.Listener listener) {
        this.listener = listener;
    }

    public void setDatasource(LoginIdInterface.Datasource datasource) {
        this.datasource = datasource;
    }

    private EditText edtUser,edtPass;
    private CheckBox checkBox;
    private Button btnDangnhap;
    private LinearLayout lnHeader1, lnHeader2;
    private Toolbar toolbar;
    private ProgressBar progressBar;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_login_id_view,container,false);
        edtUser = (EditText) view.findViewById(R.id.loginid_edtUser);
        edtPass = (EditText) view.findViewById(R.id.loginid_edtPass);
        btnDangnhap = (Button) view.findViewById(R.id.loginID_btnDangnhap);
        lnHeader1 = (LinearLayout) view.findViewById(R.id.login_id_header1);
        lnHeader2 = (LinearLayout) view.findViewById(R.id.login_id_header2);
        toolbar = (Toolbar) view.findViewById(R.id.login_id_toolbar);
        checkBox = (CheckBox) view.findViewById(R.id.loginid_checkghinho);
        progressBar = (ProgressBar) view.findViewById(R.id.loginId_progressbar);
        progressBar.getIndeterminateDrawable().setColorFilter(Color.parseColor("#1e8bc3"), PorterDuff.Mode.MULTIPLY);

        KeyboardVisibilityEvent.setEventListener(getActivity(), new KeyboardVisibilityEventListener() {
            @Override
            public void onVisibilityChanged(boolean isOpen) {
                if(isOpen ==true){
                    lnHeader1.setVisibility(View.GONE);
                    lnHeader2.setVisibility(View.GONE);
                }else {
                    lnHeader1.setVisibility(View.VISIBLE);
                    lnHeader2.setVisibility(View.VISIBLE);
                }

            }

        });

        btnDangnhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
        datasource.setUserName(edtUser.getText().toString().trim());
        datasource.setPass(edtPass.getText().toString().trim());
                if (checkBox.isChecked()) {
                    datasource.setCheckSave(true);
                    datasource.setUserName(edtUser.getText().toString().trim());
                    datasource.setPass(edtPass.getText().toString().trim());
                } else {
                    datasource.setCheckSave(false);
                }
                listener.onButtonDangnhapClick();

            }
        });

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onButtonBackClick();
            }
        });

        return view;
    }

    public void loadView() {
        toolbar.setNavigationIcon(R.drawable.ic_arrow_white_black_24dp);
        if (datasource.getCheckSave() == true){
            checkBox.setChecked(true);
            edtUser.setText(datasource.getUserName());
            edtPass.setText(datasource.getPass());
        } else {
            checkBox.setChecked(false);
        }
        hideProgress();
    }

    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
        btnDangnhap.setVisibility(View.VISIBLE);
    }

    public void showProgress(){
        progressBar.setVisibility(View.VISIBLE);
        btnDangnhap.setVisibility(View.GONE);
    }

    @Override
    public void onResume() {
        super.onResume();
        listener.onLoadViewFinish();
    }

}
