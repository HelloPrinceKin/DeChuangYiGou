package com.dechuangyigou.orderform;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.dechuangyigou.dechuangyigou.BaseActivity;
import com.dechuangyigou.dechuangyigou.BaseFragment;
import com.dechuangyigou.dechuangyigou.R;
import com.dechuangyigou.net.HttpRequest;
import com.dechuangyigou.net.XRequest;

/**
 * Created by Administrator on 2017/2/18.
 */

public class OrderFormFragment extends BaseFragment {

    private Button button;
    private TextView text;

    //初始化fragment时使用
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    /**
     * 填充fragment的视图
     *
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dingdan, container,false);
        button = (Button) view.findViewById(R.id.button);
        text = (TextView) view.findViewById(R.id.text2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                XRequest xRequest = new XRequest(activity, "https://hao.360.cn/?src=lm&ls=n01c2c74491");
                xRequest.setOnRequestListener(new HttpRequest.OnRequestListener() {
                    @Override
                    public void onSuccess(BaseActivity activity, String result) {
                        text.setText("kljglkjlkiuhoiuiohyyiouyiuyhiouyiolkfdjsojiflbgkljblsdjbljblkjgkljbfjglk");

                    }

                    @Override
                    public void onFail(BaseActivity activity, int code) {

                    }
                }).execute();
            }
        });
        return view;
    }

    /**
     * 加载数据
     *
     * @param savedInstanceState
     */
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


    }
}
