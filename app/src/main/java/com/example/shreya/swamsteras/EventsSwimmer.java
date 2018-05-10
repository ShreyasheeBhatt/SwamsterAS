package com.example.shreya.swamsteras;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class EventsSwimmer extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events_swimmer);

        // for on data change

        final ListView lv = findViewById(R.id.listIndEvents);
        final List<String> list = new ArrayList();
        list.add("backstroke");
        list.add("swim");
        list.add("red");
        ArrayAdapter adapter = new ArrayAdapter<String>(lv.getContext(), android.R.layout.simple_list_item_1, list);
        lv.setAdapter(adapter);

        final ListView lv2 = findViewById(R.id.listIndTimes);
        final List<String> list2 = new ArrayList();
        list2.add("front");
        list2.add("left");
        list2.add("blue");
        ArrayAdapter adapter2 = new ArrayAdapter<String>(lv2.getContext(), android.R.layout.simple_list_item_1, list2);
        lv2.setAdapter(adapter2);
//
//        Bundle bundle = getIntent().getExtras();
//        String firstName = bundle.getString("firstName");
//        String lastName = bundle.getString("lastName");

        ArrayList<Swimmer> swimmers = null;
        ArrayList<Race> races = null;

        InputStream is = getResources().openRawResource(R.raw.data);
        csvParse csv = new csvParse(is);
        swimmers = csv.getSwimmers();

        int startHour = 17;
        int startMinute = 38;
            startNotification(startHour, startMinute);

//        for (Swimmer swimmer : swimmers) {
//            if (firstName.equals(swimmer.getFirstName()) && lastName.equals(swimmer.getLastName())) {
//                races = swimmer.getRaceList();
//                for (Race race : races) {
//                    Log.d("EventsSwimmer", "Getting to the time stuff!!");
//                    int startHour = 17;
//                    int startMinute = 30;
//                    startNotification(startHour, startMinute);
//                }
//            }
        }

    public void startNotification(int startHour, int startMinute)
    {
            Calendar c = Calendar.getInstance();
            long rightNow = c.getTimeInMillis();
            Log.d("notif", String.valueOf(rightNow));

            AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);

            c.set(c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH), startHour, startMinute, 0);
            Log.d("Notification", "year: " + c.get(Calendar.YEAR) + "month: " + c.get(Calendar.MONTH) + "day: " + c.get(Calendar.DAY_OF_MONTH));
            long timeToNotify = c.getTimeInMillis();
            System.out.println("TIME: " + timeToNotify);

            Intent intent = new Intent(this, notificationActivity.class);
            PendingIntent broadcast = PendingIntent.getBroadcast(this, 0, intent, 0);

            alarmManager.set(AlarmManager.RTC_WAKEUP, timeToNotify, broadcast);
    }
//            }
//        }
//    }
}
