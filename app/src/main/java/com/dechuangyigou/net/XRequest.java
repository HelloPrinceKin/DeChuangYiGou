package com.dechuangyigou.net;

import com.dechuangyigou.dechuangyigou.BaseActivity;


import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/2/23.
 */

public class XRequest {
    public static final String POST = "POST";
    public static final String GET = "GET";
    public static final String FILE = "FILE";

    BaseActivity activity;
    String url;
    Map<String,Object> params;
    List<RequestBean> requestBean;
    HttpRequest.OnRequestListener requestListener;
    String method;
    boolean backend = false;//判断progressdialog的加载

    /**
     * 当只有url不用传入请求参数时调用的构造方法
     * @param activity
     * @param url
     */
    public XRequest(BaseActivity activity, String url) {
        this.activity = activity;
        this.url = url;
        this.method = GET;
        this.params = null;
    }

    /**
     * 需要有参数传入时调用的构造方法
     * @param activity
     * @param url
     * @param method
     * @param requestBean
     */
    public XRequest(BaseActivity activity, String url, String method, List<RequestBean> requestBean) {
        this.activity = activity;
        this.url = url;
        this.method = method;
        this.requestBean = requestBean;
    }

    public XRequest(BaseActivity activity, String url, Map<String, Object> params, String method) {
        this.activity = activity;
        this.url = url;
        this.params = params;
        this.method = method;
    }

    /**
     * 用来启动网络请求，调用HttpRequest
     */
    public void execute(){
        HttpRequest.getInstance().execute(this);//网址用构造方法已经传进来了

    }

    /**
     * 设置网络请求结束后得反馈
     * @param listener
     * @return 方法链编程
     */
    public XRequest setOnRequestListener(HttpRequest.OnRequestListener listener) {
        this.requestListener = listener;
        return this;
    }

    /**
     * 有的请求不需要加载dialog
     * @param backend
     * @return
     */
    public XRequest setBackstage(boolean backend){
        this.backend = backend;
        return this;

    }

}
