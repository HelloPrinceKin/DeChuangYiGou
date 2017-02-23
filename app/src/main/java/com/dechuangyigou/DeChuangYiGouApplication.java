package com.dechuangyigou;

import android.app.Application;

import org.xutils.x;

/**
 * Created by Administrator on 2017/2/23.
 */

public class DeChuangYiGouApplication extends Application {
    private static DeChuangYiGouApplication instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        x.Ext.init(this);//初始化xutils
    }

    public static DeChuangYiGouApplication getInstance(){
        return instance;
    }
}
