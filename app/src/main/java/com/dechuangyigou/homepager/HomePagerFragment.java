package com.dechuangyigou.homepager;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.dechuangyigou.dechuangyigou.BaseFragment;
import com.dechuangyigou.dechuangyigou.R;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Administrator on 2017/2/18.
 */

public class HomePagerFragment extends BaseFragment {
    private Context context;
    private ListView mListView;
    private Toolbar mToorbar;

    public static HomePagerFragment instance (Context context){
        HomePagerFragment homePFragment = new HomePagerFragment();
        homePFragment.context = context;
        return homePFragment;

    }

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
        View view = inflater.inflate(R.layout.homepager_fragment, null);
        mToorbar = (Toolbar) view.findViewById(R.id.toorbar);
        mListView = (ListView) view.findViewById(R.id.listview);


        return view;
    }

    /**
     * 加载数据
     * @param savedInstanceState
     */
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //关于toorbar的操作
        aboutToorbar();

        List<String> data = new LinkedList<>();
        for(int i=0;i<30;i++){
            data.add("这是"+i);
        }

        ArrayAdapter adapter = new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1, data);
        mListView.setAdapter(adapter);

    }

    /**
     * 关于toorbar的操作
     */
    private void aboutToorbar() {
        mToorbar.setNavigationIcon(R.mipmap.ic_launcher);
    }
}
