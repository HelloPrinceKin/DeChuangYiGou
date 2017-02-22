package com.dechuangyigou.dechuangyigou;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.dechuangyigou.homepager.HomePagerFragment;
import com.dechuangyigou.me.MeFragment;
import com.dechuangyigou.orderform.OrderFormFragment;
import com.dechuangyigou.product.ProductFragment;
import com.dechuangyigou.shoppingcar.ShoppingCarFragment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView mHome_text;
    private TextView mProduct_text;
    private TextView mShopping_text;
    private TextView mOrder_text;
    private TextView mMe_text;
    private int currentIndex = 0;
    private int oldIndex = 0;
    private List<Fragment> fragments;
    private List<TextView> views;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //初始化控件
        initView();

        //加载fragment
        initFragment();

        //底部导航栏的实现
        aboutButtonBanner();

    }

    private void aboutButtonBanner() {

        //设置监听器
        mHome_text.setOnClickListener(this);
        mMe_text.setOnClickListener(this);
        mOrder_text.setOnClickListener(this);
        mProduct_text.setOnClickListener(this);
        mShopping_text.setOnClickListener(this);

        //默人第一项为选中
        mHome_text.setSelected(true);
        mHome_text.setTextColor(getResources().getColor(android.R.color.secondary_text_light_nodisable));
        //将TextView存储到集合中
        views = new ArrayList<>();
        Collections.addAll(views, mHome_text, mProduct_text, mShopping_text, mOrder_text, mMe_text);

    }

    /**
     * 加载fragment
     */
    private void initFragment() {
        fragments = new LinkedList<>();
        HomePagerFragment mHomePager = HomePagerFragment.instance(this);
        ProductFragment mProduct = new ProductFragment();
        ShoppingCarFragment mShopping = new ShoppingCarFragment();
        OrderFormFragment mOrder = new OrderFormFragment();
        MeFragment mMe = new MeFragment();
        Collections.addAll(fragments, mHomePager, mProduct, mShopping, mOrder, mMe);
        //默认加载前两个fragment，其中一个显示，另一个隐藏
        getSupportFragmentManager().beginTransaction().add(R.id.fragment_replace, mHomePager).
                add(R.id.fragment_replace, mProduct).hide(mProduct).show(mHomePager).commit();


    }

    /**
     * 初始化控件，即标签
     */
    private void initView() {
        //首页
        mHome_text = (TextView) findViewById(R.id.homepager);
        //产品
        mProduct_text = (TextView) findViewById(R.id.product);
        //购物车
        mShopping_text = (TextView) findViewById(R.id.shopping_car);
        //订单
        mOrder_text = (TextView) findViewById(R.id.order_form);
        //我的
        mMe_text = (TextView) findViewById(R.id.me);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.homepager:
                currentIndex = 0;//当前的选择，，走到这步之后current和old就不一样了
                break;
            case R.id.product:
                currentIndex = 1;
                break;
            case R.id.shopping_car:
                currentIndex = 2;
                break;
            case R.id.order_form:
                currentIndex = 3;
                break;
            case R.id.me:
                currentIndex = 4;
                break;
        }
        if(currentIndex!=oldIndex){
            views.get(oldIndex).setSelected(false);//设置选择器的颜色
            TextView current_text = views.get(currentIndex);
            current_text.setTextColor(getResources().getColor(android.R.color.holo_red_light));
            TextView old_text = views.get(oldIndex);
            old_text.setTextColor(getResources().getColor(android.R.color.secondary_text_light_nodisable));


            views.get(currentIndex).setSelected(true);
            //获得fragmentmanager的实例，用来切换显示fragment
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            Fragment fragment = fragments.get(oldIndex);//现在正在显示的fragment也就是要隐藏的
            fragmentTransaction.hide(fragment);
            Fragment fragment1 = fragments.get(currentIndex);//用户点击的需要显示的

            //判断当前的fragment是否被添加过，没有的就添加到事务中
            if(!fragment1.isAdded()){
                fragmentTransaction.add(R.id.fragment_replace, fragments.get(currentIndex));

            }

            fragmentTransaction.show(fragments.get(currentIndex)).commit();
            oldIndex = currentIndex;


        }

    }
}
