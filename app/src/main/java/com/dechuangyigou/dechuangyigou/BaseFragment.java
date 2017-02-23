package com.dechuangyigou.dechuangyigou;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;

/**
 * Created by Administrator on 2017/2/22.
 */

public class BaseFragment extends Fragment {

    public BaseActivity activity;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity = (BaseActivity) getActivity();//所有Fragment的上下文对象
    }
}
