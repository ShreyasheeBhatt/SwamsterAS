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

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class EventsSwimmer extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events_swimmer);

        Intent intentExtras = getIntent();
        Bundle strings = intentExtras.getExtras();
        String firstName = strings.getString("firstName");
        String lastName = strings.getString("lastName");

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference swimRef = database.getReference("meet");

        swimRef.orderByChild("lastName").equalTo(lastName).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot datas: dataSnapshot.getChildren()){
                    String keys = datas.getKey();
                    Log.d("test",keys);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


        {
        // for on data change

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

    }

        DatabaseReference myRef = database.getReference();
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                Log.d("TAG", "Value is: " + value);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.d("TAG", "Failed to read value.", error.toException());
            }
        });


        ArrayList<Event> events = null;
        ArrayList<Swimmer> swimmers = null;
        ArrayList<Race> races = null;
        Log.d("TimeUpdate", "Initiated ArrayLists");

        InputStream is = getResources().openRawResource(R.raw.data);
        csvParse csv = new csvParse(is);
        events = csv.getEvents();
        swimmers = csv.getSwimmers();

        for(Swimmer swimmer: swimmers)
        {
            if(firstName.equals(swimmer.getFirstName()) && lastName.equals(swimmer.getLastName())) {
                races = swimmer.getRaceList();
                int x = races.size();
                for(int n=0; n<x; n++)
                {
                    for (Race race : races) {
                        int startHour = race.getStartHour();
                        int startMinutes = race.getStartMinutes();
                        startNotification(startHour, startMinutes);
                        Calendar rightNow = Calendar.getInstance();
                        Calendar whenNotified = Calendar.getInstance();
                        whenNotified.set(rightNow.get(Calendar.YEAR), rightNow.get(Calendar.MONTH), rightNow.get(Calendar.DAY_OF_MONTH), startHour, startMinutes, 0);
                        if(rightNow.equals(whenNotified))
                            continue;

                    }
                }
            }
        }
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
}
