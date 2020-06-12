package com.example.ntd.login.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.ntd.R;
import com.example.ntd.base.BaseActivity;
import com.example.ntd.login.interfaces.LoginSuccessInterface;
import com.nostra13.universalimageloader.core.ImageLoader;

import de.hdodenhof.circleimageview.CircleImageView;


public class LoginSuccessView extends Fragment {

    private CircleImageView imgAvatar;
    private TextView txtName, txtChucvu;
    private ImageButton btnEdit;
    private ImageLoader imageLoader;
    private Button btnKhampha;
    private LoginSuccessInterface.Listener listener;
    private LoginSuccessInterface.Datasource datasource;

    public void setDatasource(LoginSuccessInterface.Datasource datasource) {
        this.datasource = datasource;
    }

    public void setListener(LoginSuccessInterface.Listener listener) {
        this.listener = listener;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login_success_view,container,false);
        imgAvatar = (CircleImageView) view.findViewById(R.id.login_success_avatar);
        txtName = (TextView) view.findViewById(R.id.login_success_txtName);
        txtChucvu = (TextView) view.findViewById(R.id.login_success_position);
        btnEdit = (ImageButton) view.findViewById(R.id.login_success_btnedit);
        btnKhampha = (Button) view.findViewById(R.id.login_btnKhampha);
        imageLoader = ((BaseActivity) getActivity()).imageLoader;
        // Inflate the layout for this fragment

        btnKhampha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onButtonKhamphaClick();
            }
        });
        return view;
    }






}
