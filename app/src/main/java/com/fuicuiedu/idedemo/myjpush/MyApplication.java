package com.fuicuiedu.idedemo.myjpush;

import android.app.Application;

import cn.jpush.android.api.JPushInterface;

/**
 * Created by Administrator on 2016/12/7 0007.
 */

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        //极光推送的初始化
        JPushInterface.init(this);
        //激光推送调试模式
        JPushInterface.setDebugMode(true);
    }
}
