package com.example.shreya.swamsteras;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Calendar;

/**
 * Created by Shreya on 5/4/18.
 */

public class UpdateTime extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_time);
        Log.d("TimeUpdate", "Entered UpdateTime");

        Bundle bundle = getIntent().getExtras();
        String eventName = bundle.getString("eventName");
        int startHour = bundle.getInt("startHour");
        int startMinute = bundle.getInt("startMinute");
        int raceMinutes = bundle.getInt("raceMinutes");
        int raceSeconds = bundle.getInt("raceSeconds");
        Log.d("TimeUpdate", "Initiated intent variables");

        ArrayList<Event> events = null;
        ArrayList<Swimmer> swimmers = null;
        ArrayList<Race> races = null;
        Log.d("TimeUpdate", "Initiated ArrayLists");

        InputStream is = getResources().openRawResource(R.raw.data);
        csvParse csv = new csvParse(is);
        Log.d("TimeUpdate", "Initialized csvParse object");
        events = csv.getEvents();
        Log.d("csvParse", "Got events?" + events.toString());
        swimmers = csv.getSwimmers();
        Log.d("csvParse", "Got swimmers?" + swimmers.toString());
        int heat;

        for(Swimmer swimmer : swimmers)
        {
            Log.d("TimeUpdate", "Can read swimmers" + swimmer.getFirstName());
            races = swimmer.getRaceList();
            Log.d("TimeUpdate", Integer.toString(races.size()));
            for(Race race : races)
            {
                Log.d("TimeUpdate", "Can read races");
                if(eventName.equals(race.getEvent()))
                {
                    heat = race.getHeat();
                    raceMinutes+=(raceMinutes*(heat-1)-5);
                    raceSeconds+=(raceSeconds*(heat-1));
                    raceMinutes+=((raceSeconds*heat)%60);
                    if(startMinute+(raceMinutes*heat-1)<60)
                    {
                        startMinute += (raceMinutes * heat);
                        Log.d("TimeUpdate", "1");
                    }
                    else if(startMinute+((raceMinutes*heat-1)-5)==60)
                    {
                        startMinute = 0;
                        startHour+=1;
                        startHour=startHour%24;
                        Log.d("TimeUpdate", "2");
                    }
                    else if(startMinute+((raceMinutes*heat-1)-5)>60)
                    {
                        if(startMinute+(raceMinutes*heat-1)<120) {
                            startMinute = startMinute+(raceMinutes*heat-1)-65;
                            startHour+=1;
                            startHour=startHour%24;
                            Log.d("TimeUpdate", "3");
                        }
                        else
                        {
                            startMinute = startMinute+(raceMinutes*heat-1)-125;
                            startHour+=2;
                            startHour=startHour%24;
                            Log.d("TimeUpdate", "4");
                            //assumes that you cannot have a single event run for more than 2 hours
                        }
                    }
                }
                Log.d("TimeUpdate", "Gets out of the if");
                /*race.setStartHour(startHour);
                race.setStartMinutes(startMinute);
                Log.d("TimeUpdate", "Complete: \n\tRace: " + race + "\n\tTime: " + race.getStartHour() + ":" + race.getStartMinutes());
                Calendar currentTime = Calendar.getInstance();
                long currentTimeInMillis = currentTime.getTimeInMillis();
                long hourToMillis = startHour*60*60*1000;
                long minsToMillis = startMinute*60*1000;
                currentTimeInMillis+=(hourToMillis+minsToMillis);
                Intent intent = new Intent(this, myReceiver.class);
                AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
                alarmManager.set(AlarmManager.RTC_WAKEUP, currentTimeInMillis, PendingIntent.getBroadcast(this,2,intent, PendingIntent.FLAG_UPDATE_CURRENT));
            */}
        }
    }
}
