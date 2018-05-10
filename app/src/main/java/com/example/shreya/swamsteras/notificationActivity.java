package com.example.shreya.swamsteras;

import android.app.IntentService;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by Shreya on 5/9/18.
 */

public class notificationActivity extends AppCompatActivity
{
        @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notification);

        Button button = findViewById(R.id.notifyButton);
        button.setOnClickListener(new View.OnClickListener()

        {


            @Override
            public void onClick(View view)
            {


                NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(notificationActivity.this)
                        .setSmallIcon(android.R.drawable.stat_notify_error)
                        .setVibrate(new long[]{Notification.DEFAULT_VIBRATE})
                        .setPriority(Notification.PRIORITY_MAX)
                        .setContentTitle("Swamster Race Reminder")
                        .setContentText("You have 5 minutes left until your race!")
                        .setAutoCancel(true);

                notificationBuilder.setDefaults(Notification.DEFAULT_SOUND | Notification.DEFAULT_LIGHTS | Notification.DEFAULT_VIBRATE);
                NotificationManagerCompat notificationManager = NotificationManagerCompat.from(notificationActivity.this);
                notificationManager.notify(1, notificationBuilder.build());
            }
        });
    }
}
