package com.example.ntd.candidateinviteinterview;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.ntd.R;
import com.example.ntd.base.BaseActivity;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CandidateInviteInterviewActivity extends BaseActivity implements CandidateInviteInterviewInterface.Listener {

    private CandidateInviteInterviewModel model;
    Context context;
    CandidateInviteInterviewFragment candidateInviteInterviewFragment;
    private AlertDialog mCalendarDialog;
    private AlertDialog mSendEmailDialog;
    private TextView mTimeEditText,mDateEditText;
    private EditText mNoteEditText;
    private TimePickerDialog mTimePickerDialog;
    private DatePickerDialog mDatePickerDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_candidate_invite_interview);

        context = CandidateInviteInterviewActivity.this;
        model = new CandidateInviteInterviewModel();
        candidateInviteInterviewFragment = new CandidateInviteInterviewFragment();
        candidateInviteInterviewFragment.setListener(this);
        candidateInviteInterviewFragment.setDatasource(model);

        buidCalendarDialog();
        buildTimePickerDialog();
        buildDatePickerDialog();
        addFragment(R.id.invite_interview_contain,candidateInviteInterviewFragment);
        hideAllFragment();
        showFragment(candidateInviteInterviewFragment);

    }

    private void buildDatePickerDialog() {

        DatePickerDialog.OnDateSetListener onDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                mDateEditText.setText(String.format("%02d-%02d-%d",dayOfMonth,month,year));
            }
        };

        Calendar calendar= Calendar.getInstance();
        mDatePickerDialog = new DatePickerDialog(this, onDateSetListener, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH));
        mDatePickerDialog.getDatePicker().setMinDate(calendar.getTimeInMillis());

    }

    private void buildTimePickerDialog() {

        TimePickerDialog.OnTimeSetListener onTimeSetListener = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                mTimeEditText.setText(String.format("%02d:%02d",hourOfDay,minute));
            }
        };
        mTimePickerDialog = new TimePickerDialog(this,onTimeSetListener,8,30,true);

    }

    private void buidCalendarDialog() {

        try {
            View view = getLayoutInflater().inflate(R.layout.layout_dialog_calendar,null);
            mTimeEditText = (TextView) view.findViewById(R.id.textView_calendar_time);
            mTimeEditText.setText("");
            mTimeEditText.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mTimePickerDialog.show();
                }
            });
            mDateEditText = (TextView) view.findViewById(R.id.textView_calendar_date);
            mDateEditText.setText("");
            mDateEditText.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mDatePickerDialog.show();
                }
            });
            mNoteEditText = (EditText) view.findViewById(R.id.editText_calendar_note);
            mNoteEditText.setText("");
            mCalendarDialog = new AlertDialog.Builder(this)
                    .setTitle("Đặt lịch hẹn")
                    .setView(view)
                    .setNegativeButton("Hủy", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    })
                    .setPositiveButton("Đồng ý", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dongyDatlichClick();
                            dialog.dismiss();
                            
                        }
                    })
                    .create();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void dongyDatlichClick() {
        try {
            if (!mTimeEditText.getText().toString().isEmpty()
                && !mDateEditText.getText().toString().isEmpty()
                && !mNoteEditText.getText().toString().isEmpty()) {

                String note = mNoteEditText.getText().toString();
                String time = mTimeEditText.getText().toString();
                String displayTime = mDateEditText.getText().toString();
                SimpleDateFormat displayFormat = new SimpleDateFormat("dd-MM-yyyy");
                displayFormat.parse(displayTime);
                Calendar calendar = displayFormat.getCalendar();
                String date = String.format("%d-%02d-%02d", calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));

            }
        } catch (Exception e) {

        }

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
        hideFragment(candidateInviteInterviewFragment);
    }

    @Override
    public void onLoadCandidateInterview() {
        model.loadDSMoiPhongvan(context, new CandidateInviteInterviewModel.onExcuteFinish() {
            @Override
            public void onSuccess() {
                candidateInviteInterviewFragment.loadView();
            }

            @Override
            public void onError() {
                Toast.makeText(context, getString(R.string.error), Toast.LENGTH_SHORT).show();

            }
        });
    }

    @Override
    public void onLoadCandidateInterviewMore() {

    }

    @Override
    public void onButtonCancelClick() {

    }

    @Override
    public void onButtonSearchClick() {

    }

    @Override
    public void onItemClick() {

    }

    @Override
    public void onLoadMoreSearch() {

    }

    @Override
    public void onItemButtonXoaClick() {
        new AlertDialog.Builder(context)
                .setTitle("")
                .setMessage("Bạn có thực sự muốn xóa ứng viên này?")
                .setPositiveButton("Đồng ý", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        candidateInviteInterviewFragment.deleteItem(model.getPosition());
                    }
                })
                .setNegativeButton("Hủy bỏ", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .show();
    }

    @Override
    public void onItemButtonXoaSearchClick() {

    }

    @Override
    public void onButtonBackClick() {
        finish();
    }

    @Override
    public void onButtonTKClick() {

    }

    @Override
    public void onDatLichClick() {
        mCalendarDialog.show();

    }

    @Override
    public void onSendEmailClick() {

    }

    @Override
    public void onSendNotification() {

    }

}
