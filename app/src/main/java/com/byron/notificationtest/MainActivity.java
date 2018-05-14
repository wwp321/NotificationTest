package com.byron.notificationtest;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onButtonClick(View view) {
        switch (view.getId()) {
            case R.id.send_notification_button:
                NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                Intent intent = new Intent(this, NotificationActivity.class);
                PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);
                Notification notification = new NotificationCompat.Builder(this)
                        .setContentTitle("This is content tiele")
//                        .setContentText("辅导员岗位和管理岗位：采用结构化测试与答辩相结合的方式。主要测试应聘人员的综合分析能力、组织协调能力、应急应变能力、语言表达能力及相应岗位职业能力等。")
                        .setStyle(new NotificationCompat.BigTextStyle().bigText("辅导员岗位和管理岗位：采用结构化测试与答辩相结合的方式。主要测试应聘人员的综合分析能力、组织协调能力、应急应变能力、语言表达能力及相应岗位职业能力等。"))
                        .setWhen(System.currentTimeMillis())
                        .setPriority(NotificationCompat.PRIORITY_MAX)
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher))
                        .setContentIntent(pendingIntent)
                        .setDefaults(NotificationCompat.DEFAULT_ALL)
                        .build();
                manager.notify(1, notification);
                break;
        }
    }
}
