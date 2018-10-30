package com.example.administrator.bottomnavigationdemo;

import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.linear_main)
    LinearLayout linearMain;
    @BindView(R.id.child_iv)
    ImageView childIv;
    @BindView(R.id.child_tv)
    TextView childTv;
    @BindView(R.id.child_linear)
    LinearLayout childLinear;
    @BindView(R.id.message_iv)
    ImageView messageIv;
    @BindView(R.id.message_tv)
    TextView messageTv;
    @BindView(R.id.message_linear)
    LinearLayout messageLinear;
    @BindView(R.id.course_iv)
    ImageView courseIv;
    @BindView(R.id.course_tv)
    TextView courseTv;
    @BindView(R.id.course_linear)
    LinearLayout courseLinear;
    @BindView(R.id.me_iv)
    ImageView meIv;
    @BindView(R.id.me_tv)
    TextView meTv;
    @BindView(R.id.me_linear)
    LinearLayout meLinear;
    private int current = 0, target = 0;
    private List<Fragment> mFragments;

    private boolean unreaded = false;//是否有未读消息
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initData();
    }

    private void initData() {
        if(unreaded){
            messageIv.setImageResource(R.mipmap.newmsg1);
        }
        mFragments = new ArrayList<>();
        mFragments.add(new MyFragment("孩子"));
        mFragments.add(new MyFragment("消息"));
        mFragments.add(new MyFragment("课程"));
        mFragments.add(new MyFragment("我的"));
        FragmentTransaction tran = getSupportFragmentManager().beginTransaction();
        tran.add(R.id.linear_main, mFragments.get(0));
        tran.commit();
    }
    private void getFragment() {
        Fragment fragmentCu = mFragments.get(current);
        Fragment fragmentTar = mFragments.get(target);
        FragmentTransaction tran = getSupportFragmentManager().beginTransaction();
        tran.hide(fragmentCu);
        if (fragmentTar.isAdded()) {
            tran.show(fragmentTar);
        } else {
            tran.add(R.id.linear_main, fragmentTar);
        }
        if (unreaded) {
            if (target == 1) {
                messageIv.setImageResource(R.mipmap.newmsg2);
            } else {
                messageIv.setImageResource(R.mipmap.newmsg1);
            }
        } else {
            if (target == 1) {
                messageIv.setImageResource(R.mipmap.message_red);
            } else {
                messageIv.setImageResource(R.mipmap.message);
            }
        }
        current = target;
        tran.commit();
    }

    @OnClick({R.id.child_linear, R.id.message_linear, R.id.course_linear, R.id.me_linear})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.child_linear:
                childIv.setImageResource(R.mipmap.child_red);
                messageIv.setImageResource(R.mipmap.message);
                courseIv.setImageResource(R.mipmap.course);
                meIv.setImageResource(R.mipmap.me);
                childTv.setTextColor(Color.rgb(239, 56, 58));
                messageTv.setTextColor(Color.rgb(141, 141, 141));
                courseTv.setTextColor(Color.rgb(141, 141, 141));
                meTv.setTextColor(Color.rgb(141, 141, 141));
                target = 0;
                getFragment();
                break;
            case R.id.message_linear:
                childIv.setImageResource(R.mipmap.child);
                messageIv.setImageResource(R.mipmap.message_red);
                courseIv.setImageResource(R.mipmap.course);
                meIv.setImageResource(R.mipmap.me);
                childTv.setTextColor(Color.rgb(141, 141, 141));
                messageTv.setTextColor(Color.rgb(239, 56, 58));
                courseTv.setTextColor(Color.rgb(141, 141, 141));
                meTv.setTextColor(Color.rgb(141, 141, 141));
                target = 1;
                getFragment();
                break;
            case R.id.course_linear:
                childIv.setImageResource(R.mipmap.child);
                messageIv.setImageResource(R.mipmap.message);
                courseIv.setImageResource(R.mipmap.course_red);
                meIv.setImageResource(R.mipmap.me);
                childTv.setTextColor(Color.rgb(141, 141, 141));
                messageTv.setTextColor(Color.rgb(141, 141, 141));
                courseTv.setTextColor(Color.rgb(239, 56, 58));
                meTv.setTextColor(Color.rgb(141, 141, 141));
                target = 2;
                getFragment();
                break;
            case R.id.me_linear:
                childIv.setImageResource(R.mipmap.child);
                messageIv.setImageResource(R.mipmap.message);
                courseIv.setImageResource(R.mipmap.course);
                meIv.setImageResource(R.mipmap.me_red);
                childTv.setTextColor(Color.rgb(141, 141, 141));
                messageTv.setTextColor(Color.rgb(141, 141, 141));
                courseTv.setTextColor(Color.rgb(141, 141, 141));
                meTv.setTextColor(Color.rgb(239, 56, 58));
                target = 3;
                getFragment();
                break;
        }
    }
}
