package com.dechuangyigou.product;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dechuangyigou.dechuangyigou.BaseFragment;
import com.dechuangyigou.dechuangyigou.R;

/**
 * Created by Administrator on 2017/2/18.
 */

public class ProductFragment extends BaseFragment {
    //初始化fragment时使用
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    /**
     * 填充fragment的视图
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.product, null);

        return view;
    }

    /**
     * 加载数据
     * @param savedInstanceState
     */
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }
}
