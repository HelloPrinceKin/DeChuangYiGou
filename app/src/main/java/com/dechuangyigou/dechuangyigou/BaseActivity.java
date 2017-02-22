package com.dechuangyigou.dechuangyigou;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by Administrator on 2017/2/22.
 */

public class BaseActivity extends AppCompatActivity {

    private ImageView mIbFinish;
    private TextView mTVtitle;
    private TextView mTvStatle;
    private FrameLayout mFlContent;
    private LinearLayout laycontent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.base_pager);
        Context mContext = BaseActivity.this;
        //根据版本设置状态栏
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
        initView();

    }

    /**
     * 初始化控件
     */
    private void initView() {

        mIbFinish = (ImageView) findViewById(R.id.ib_finish);
        mTVtitle = (TextView) findViewById(R.id.tv_title);
        mTvStatle = (TextView) findViewById(R.id.tv_state);
        mFlContent = (FrameLayout) findViewById(R.id.fl_content);
        laycontent = (LinearLayout) findViewById(R.id.layoutContent);
    }

    public void setBodyView(int layout){
        View view = LayoutInflater.from(getApplicationContext()).inflate(layout, null);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.MATCH_PARENT);
        mFlContent.addView(view, layoutParams);

    }

    /**
     * 设置返回键隐藏
     */
    public void setBackGone(){
        mIbFinish.setVisibility(View.GONE);

    }
}
