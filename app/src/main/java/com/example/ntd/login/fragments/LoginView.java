package com.example.ntd.login.fragments;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.text.Html;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.URLSpan;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.ntd.R;
import com.example.ntd.login.adapters.ImgSlideAdapter;
import com.example.ntd.login.adapters.ImgSlideObj;
import com.example.ntd.login.interfaces.LoginInterface;

import java.util.ArrayList;


public class LoginView extends Fragment {

    private LoginInterface.Listener listener;
    private LoginInterface.Datasource datasource;
    private static final long ANIM_VIEWPAGER_DELAY = 20000;
    private static final long ANIM_VIEWPAGER_DELAY_USER_VIEW = 20000;

    public void setListener(LoginInterface.Listener listener) {
        this.listener = listener;
    }

    public void setDatasource(LoginInterface.Datasource datasource) {
        this.datasource = datasource;
    }

    private Button btnDangnhap;
    private TextView txtService;
    private CirclePageIndicator indicator;
    private ViewPager mViewPager;
    private Runnable animateViewPager;
    private Handler handler;
    private TextView txtDangky;
    private boolean stopSliding = false;
    private ImgSlideAdapter imgSlideAdapter;
    private ArrayList<ImgSlideObj> listImage;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login_view,container,false);

        btnDangnhap = (Button) view.findViewById(R.id.login_btnLogin);
        txtService = (TextView) view.findViewById(R.id.login_txtService);
        indicator = (CirclePageIndicator) view.findViewById(R.id.login_indicator);
        mViewPager = (ViewPager) view.findViewById(R.id.login_slideImage);
        txtDangky = (TextView) view.findViewById(R.id.login_txtDangky);

        createListImage();

        imgSlideAdapter = new ImgSlideAdapter(getActivity().getApplicationContext(),listImage);
        mViewPager.setAdapter(imgSlideAdapter);
        mViewPager.setCurrentItem(0);
        mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {
                if (state == ViewPager.SCROLL_STATE_IDLE) {
                    if (listImage != null) {

                    }
                }
            }
        });

        mViewPager.setPageMargin(20);
        indicator.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {
                if (state == ViewPager.SCROLL_STATE_IDLE) {
                    if (listImage != null) {

                    }
                }
            }
        });
        mViewPager.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                view.getParent().requestDisallowInterceptTouchEvent(true);
                switch (motionEvent.getAction()) {

                    case MotionEvent.ACTION_CANCEL:
                        break;

                    case MotionEvent.ACTION_UP:
                        if (listImage != null && listImage.size() != 0) {
                            stopSliding = false;
                            runnable(listImage.size());
                            handler.postDelayed(animateViewPager,
                                    ANIM_VIEWPAGER_DELAY_USER_VIEW);
                        }
                        break;

                    case MotionEvent.ACTION_MOVE:
                        if (handler != null && stopSliding == false) {
                            stopSliding = true;
                            handler.removeCallbacks(animateViewPager);
                        }
                        break;
                }
                return false;
            }
        });
        btnDangnhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onButtonDangnhapClick();
            }
        });
        return view;
    }

    public void runnable(final int size) {
        handler = new Handler();
        animateViewPager = new Runnable() {
            public void run() {
                if (!stopSliding) {
                    if (mViewPager.getCurrentItem() == size - 1) {
                        mViewPager.setCurrentItem(0);
                    } else {
                        mViewPager.setCurrentItem(
                                mViewPager.getCurrentItem() + 1, true);
                    }
                    handler.postDelayed(animateViewPager, ANIM_VIEWPAGER_DELAY);
                }
            }
        };
    }

    public void loadView() {
        try {
            String service = "Bằng cách đăng nhập bạn đã đồng ý với<br>" +
                    "<a href = \"http://employer.jobsgo.vn/site/term-of-service?layout=site\" style=\"color:#ffffff\">Điều khoản dịch vụ</a> và " +
                    "<a href = \"http://employer.jobsgo.vn/site/privacy-policy?layout=site\" style=\"color:#ffffff\">Chính sách bảo mật</a> của chúng tôi";
            txtService.setText(Html.fromHtml(service));
            txtService.setLinkTextColor(Color.parseColor("#ffffff"));
            txtService.setMovementMethod(LinkMovementMethod.getInstance());
            txtService.setLinksClickable(true);
            String dangky = "Đăng ký tài khoản tại "+"<a href =\"http://employer.jobsgo.vn/\" style=\"color:#f6c667,text-decoration: none\"> http://employer.jobsgo.vn</a>";
            txtDangky.setText(Html.fromHtml(dangky));
            stripUnderlines(txtDangky);
            txtDangky.setLinkTextColor(Color.parseColor("#f6c667"));
            txtDangky.setMovementMethod(LinkMovementMethod.getInstance());
            txtDangky.setLinksClickable(true);
        } catch (Exception e) {

        }
    }

    private void createListImage() {
        listImage = new ArrayList<>();
        ImgSlideObj obj1 = new ImgSlideObj();
        obj1.setmTitle(getString(R.string.slide_titile_4));
        obj1.setmImage(R.drawable.slide_login_four);
        listImage.add(obj1);

        ImgSlideObj obj2 = new ImgSlideObj();
        obj2.setmTitle(getString(R.string.slide_titile_2));
        obj2.setmImage(R.drawable.slide_login_two);
        listImage.add(obj2);

        ImgSlideObj obj3 = new ImgSlideObj();
        obj3.setmTitle(getString(R.string.slide_titile_3));
        obj3.setmImage(R.drawable.slide_login_three);
        listImage.add(obj3);

        ImgSlideObj obj4 = new ImgSlideObj();
        obj4.setmTitle(getString(R.string.slide_titile_1));
        obj4.setmImage(R.drawable.slide_login_one);
        listImage.add(obj4);

        ImgSlideObj obj5 = new ImgSlideObj();
        obj5.setmTitle(getString(R.string.slide_titile_5));
        obj5.setmImage(R.drawable.slide_login_five);
    }

    @Override
    public void onResume() {
        listener.onLoadViewFinish();
        if (listImage == null) {
            createListImage();
        } else {
            mViewPager.setAdapter(new ImgSlideAdapter(getActivity().getApplicationContext(),listImage));
            indicator.setViewPager(mViewPager);
            runnable(listImage.size());
            handler.postDelayed(animateViewPager, ANIM_VIEWPAGER_DELAY);
        }
        super.onResume();
    }

    @Override
    public void onPause() {
        if (handler != null) {
            handler.removeCallbacks(animateViewPager);
        }
        super.onPause();
    }

    private void stripUnderlines(TextView textView) {
        Spannable s = new SpannableString(textView.getText());
        URLSpan[] spans = s.getSpans(0, s.length(), URLSpan.class);
        for (URLSpan span: spans) {
            int start = s.getSpanStart(span);
            int end  = s.getSpanEnd(span);
            s.removeSpan(span);
            span = new URLSpanNoUnderline(span.getURL());
            s.setSpan(span, start, end, 0);
        }
        textView.setText(s);
    }

    public class URLSpanNoUnderline extends URLSpan {
        public URLSpanNoUnderline(String url) {
            super(url);
        }
        @Override
        public void updateDrawState(TextPaint ds) {
            super.updateDrawState(ds);
            ds.setUnderlineText(false);
        }
    }
}
