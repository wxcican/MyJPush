package com.fuicuiedu.idedemo.myjpush;

import android.app.Notification;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import cn.jpush.android.api.BasicPushNotificationBuilder;
import cn.jpush.android.api.CustomPushNotificationBuilder;
import cn.jpush.android.api.JPushInterface;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BasicPushNotificationBuilder builder = new BasicPushNotificationBuilder(MainActivity.this);
        builder.statusBarDrawable = R.drawable.xiaoliu;
        builder.notificationFlags = Notification.FLAG_AUTO_CANCEL
                | Notification.FLAG_SHOW_LIGHTS;  //设置为自动消失和呼吸灯闪烁
        builder.notificationDefaults = Notification.DEFAULT_SOUND
                | Notification.DEFAULT_VIBRATE
                | Notification.DEFAULT_LIGHTS;  // 设置为铃声、震动、呼吸灯闪烁都要
        JPushInterface.setPushNotificationBuilder(1, builder);


        //设置自定义通知栏样式2
        //定制 Notification 的 Layout。
        CustomPushNotificationBuilder builder1 = new CustomPushNotificationBuilder(
                MainActivity.this,
                R.layout.view_notification,
                R.id.icon,
                R.id.title,
                R.id.text
        );
        //指定状态栏小图标
        builder1.statusBarDrawable = R.drawable.xinba;
        //指定下拉状态是显示的通知图标
        builder1.layoutIconDrawable = R.drawable.xiaoliu;
        JPushInterface.setPushNotificationBuilder(2,builder1);

    }
}
