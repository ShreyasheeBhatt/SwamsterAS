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

        final ListView lv = findViewById(R.id.listIndEvents);
        final List<String> list = new ArrayList();
        list.add("backstroke");
        list.add("swim");
        list.add("red");
        ArrayAdapter adapter = new ArrayAdapter<String>(lv.getContext(),android.R.layout.simple_list_item_1,list);
        lv.setAdapter(adapter);

        final ListView lv2 = findViewById(R.id.listIndTimes);
        final List<String> list2 = new ArrayList();
        list2.add("front");
        list2.add("left");
        list2.add("blue");
        ArrayAdapter adapter2 = new ArrayAdapter<String>(lv2.getContext(),android.R.layout.simple_list_item_1,list2);
        lv2.setAdapter(adapter2);

//        Bundle bundle = getIntent().getExtras();
//        String firstName = bundle.getString("firstName");
//        String lastName = bundle.getString("lastName");
//
//        ArrayList<Swimmer> swimmers = null;
//        ArrayList<Race> races = null;
//
//        InputStream is = getResources().openRawResource(R.raw.data);
//        csvParse csv = new csvParse(is);
//        swimmers = csv.getSwimmers();
//
//        for(Swimmer swimmer: swimmers)
//        {
//            if(firstName.equals(swimmer.getFirstName()))
//            {
//                races = swimmer.getRaceList();
//                for(Race race: races)
//                {
                    int startHour = 20;
                    int startMinute = 12;
//                    race.setStartHour(startHour);
//                    race.setStartMinutes(startMinute);
                    Calendar currentTime = Calendar.getInstance();
                    long currentTimeInMillis = currentTime.getTimeInMillis();
                    long hourToMillis = startHour * 60 * 60 * 1000;
                    long minsToMillis = startMinute * 60 * 1000;
                    currentTimeInMillis += (hourToMillis + minsToMillis);
                    Intent intent = new Intent(this, notificationActivity.class);
                    AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
                    alarmManager.set(AlarmManager.RTC_WAKEUP, currentTimeInMillis, PendingIntent.getBroadcast(this, 2, intent, PendingIntent.FLAG_UPDATE_CURRENT));
                }
//            }
//        }
//    }
}
