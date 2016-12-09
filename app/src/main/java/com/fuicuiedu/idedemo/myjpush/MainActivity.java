package com.fuicuiedu.idedemo.myjpush;

import android.app.Notification;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import cn.jpush.android.api.BasicPushNotificationBuilder;
import cn.jpush.android.api.CustomPushNotificationBuilder;
import cn.jpush.android.api.JPushInterface;
import cn.jpush.android.data.JPushLocalNotification;

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

        //做一个本地通知
        JPushLocalNotification ln = new JPushLocalNotification();
        //设置通知栏样式
        ln.setBuilderId(0);
        //设置通知内容文本
        ln.setContent("hhh");
        //设置通知标题
        ln.setTitle("ln");
        //设置本地通知的ID
        ln.setNotificationId(11111111);
        //设置通知时间
        ln.setBroadcastTime(System.currentTimeMillis() + 1000 * 3);

        //设置通知里的字段
        Map<String , Object> map = new HashMap<>() ;
        map.put("name", "jpush") ;
        map.put("test", "111") ;
        JSONObject json = new JSONObject(map) ;
        ln.setExtras(json.toString()) ;

        //把做好的本地通知添加进来
        JPushInterface.addLocalNotification(getApplicationContext(), ln);

    }
}
