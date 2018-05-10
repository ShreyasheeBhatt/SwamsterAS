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
import android.widget.Spinner;

import com.google.firebase.database.ChildEventListener;
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

      /*  swimRef.child("meet").orderByChild("lastName").equalTo(lastName).on("value", function(snapshot) {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                //ArrayList<Race> raceList = (ArrayList<Race>) dataSnapshot.getValue();

                //Log.d("charles", raceList.get(0).toString());
                Log.d("charles", dataSnapshot.getKey());

               //final ListView lv = findViewById(R.id.listIndEvents);
               //ArrayAdapter adapter = new ArrayAdapter<>(EventsSwimmer.this, android.R.layout.simple_list_item_1, raceList);
               //lv.setAdapter(adapter);

            }
            @Override
            public void onCancelled(DatabaseError databaseError) {

            }

            });
      */  {

        }

    }
//
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

        /*               {
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
                */
//            }
//        }
}
