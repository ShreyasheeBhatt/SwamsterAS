package com.example.shreya.swamsteras;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;

/**
 * Created by Shreya on 5/9/18.
 */

public class notificationActivity extends BroadcastReceiver
{
    public static String NOTIFICATION_ID = "notification_id";
    public static String NOTIFICATION = "notification";

    @Override
    public void onReceive(Context context, Intent intent)
    {
                NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(context)
                        .setSmallIcon(android.R.drawable.stat_notify_error)
                        .setVibrate(new long[]{Notification.DEFAULT_VIBRATE})
                        .setPriority(Notification.PRIORITY_MAX)
                        .setContentTitle("Swamster Race Reminder")
                        .setContentText("Your race is in 5 minutes!")
                        .setAutoCancel(true);

                notificationBuilder.setDefaults(Notification.DEFAULT_SOUND | Notification.DEFAULT_LIGHTS | Notification.DEFAULT_VIBRATE);
                NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
                notificationManager.notify(0, notificationBuilder.build());

//                Intent intent1 = new Intent();
//                intent1.setClassName(context.getPackageName(),EventsSwimmer.class.getName());
//                intent1.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                context.startActivity(intent1);
    }
}
