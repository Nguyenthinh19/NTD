package com.example.ntd.home.fragments;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import androidx.fragment.app.Fragment;

import com.example.ntd.R;
import com.example.ntd.candidateinviteinterview.CandidateInviteInterviewActivity;
import com.example.ntd.candidatesavejob.CandidateSaveJobActivity;
import com.example.ntd.login.activities.LoginActivity;
import com.example.ntd.lovecandidate.LoveCandidateActivity;
import com.example.ntd.objects.User;

import at.markushi.ui.CircleButton;

public class SettingFragment extends Fragment {
    View view;
    private FrameLayout stUVdaluuCV, stUVdaluu, stUVdamoichat, stQuyetdinhsau, stDSDatuchoi, stDSdagioithieu, stDSCongviec,
            stSupportOnile, stMoiPhongvan, stNews, stReferral, stUVBoqua, stUVApply, stInfo, stQuyenriengtu, stTrogiup, stGuiEmail,
            stShareapp, stInfoapp, stProfileCompany, stContest, stUVMSNS;
    private CircleButton btnLogout;
    User user;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             final Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_setting,container,false);
        user = User.getLocalUser(getContext());
        stUVdaluu = (FrameLayout) view.findViewById(R.id.setting_ungviendaluu);
        btnLogout = (CircleButton) view.findViewById(R.id.setting_login_btnLogout);
        stMoiPhongvan = (FrameLayout) view.findViewById(R.id.setting_damoiphongvan);
        stUVdaluu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), LoveCandidateActivity.class);
                startActivity(intent);
            }
        });
        stMoiPhongvan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), CandidateInviteInterviewActivity.class);
                startActivity(intent);
            }
        });
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getContext())
                        .setTitle("Đăng xuất")
                        .setMessage("Bạn thực sự muốn đăng xuất?")
                        .setPositiveButton("Đăng xuất", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent intent = new Intent(getContext(), LoginActivity.class);
                                startActivity(intent);
                            }
                        })
                        .setNegativeButton("Hủy", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                builder.show();
            }
        });
        return view;
    }


    //
}
