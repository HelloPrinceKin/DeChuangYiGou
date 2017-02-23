package com.dechuangyigou.dechuangyigou;

import android.content.Context;
import android.content.pm.PackageManager;
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
        mIbFinish = (ImageView) findViewById(R.id.ib_finish);//箭头按钮
        mTVtitle = (TextView) findViewById(R.id.tv_title);//标题
        mTvStatle = (TextView) findViewById(R.id.tv_state);//右边的状态栏
        mFlContent = (FrameLayout) findViewById(R.id.fl_content);//content内容栏
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

    /**
     * 设置返回键点击事件，即返回按钮
     * 利用接口回调
     * @param listener
     */
    public void setBackListener(View.OnClickListener listener){
        mIbFinish.setOnClickListener(listener);
    }

    /**
     * 设置标题栏的内容和隐藏其他的控件
     * @param titleStr
     */
    public void setTitleStr(String titleStr) {
        mTVtitle.setText(titleStr);
        mTVtitle.setVisibility(View.VISIBLE);

    }

    /**
     * 设置标题栏右侧按钮的图标与点击事件
     * @param str
     * @param listener
     */
    public void setMIvState(String str, View.OnClickListener listener) {
        if (listener != null) {
            mTvStatle.setOnClickListener(listener);
        }
        mTvStatle.setText(str);
        mTvStatle.setVisibility(View.VISIBLE);
    }

    /**
     * 设置标题栏右侧按钮隐藏
     */
    public void setmTvStatleGone(){
        mTvStatle.setVisibility(View.GONE);
    }

    /**
     * 判断是否有相应的权限
     * @param permission
     * @return
     */
    protected boolean hasAccessed(String permission){
        int i = ContextCompat.checkSelfPermission(this, permission);
        boolean hasAccessed = ContextCompat.checkSelfPermission(this, permission) != PackageManager.PERMISSION_GRANTED;
        return hasAccessed;
    }

    public void showProgressDialog(){
        progressDialog = CustomProgressDialog.newInstance();
        progressDialog.show(getSupportFragmentManager(), CustomProgressDialog.TAG);

    }

    public void remoreProgressDialog() {
        if (progressDialog != null) {
            progressDialog.dismiss();
        }
    }
}
