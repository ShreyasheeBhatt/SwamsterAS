package com.example.shreya.swamsteras;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.sql.Time;
import java.util.ArrayList;

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
        Time startTime = Time.valueOf(bundle.getString("startTime"));
        int startHour = bundle.getInt("startHour");
        int startMinute = bundle.getInt("startMinute");
        int raceMinutes = bundle.getInt("raceMinutes");
        int raceSeconds = bundle.getInt("raceSeconds");
        Log.d("TimeUpdate", "Initiated intent variables");

        ArrayList<Event> events = null;
        ArrayList<Swimmer> swimmers = null;
        ArrayList<Race> races = null;
        Log.d("TimeUpdate", "Initiated ArrayLists");

        csvParse csv = null;
        Log.d("TimeUpdate", "Initialized csvParse object");
        events = csv.getEvents();
        Log.d("csvParse", "Got events?" + events.toString());
        swimmers = csv.getSwimmers();
        Log.d("csvParse", "Got swimmers?" + swimmers.toString());
        int heat;

        for(Swimmer swimmer : swimmers)
        {
            Log.d("TimeUpdate", "Can read swimmers");
            races = swimmer.getRaceList();
            for(Race race : races)
            {
                Log.d("TimeUpdate", "Can read races");
                if(eventName.equals(race.getEvent()))
                {
                    heat = race.getHeat();
                    raceMinutes+=((raceSeconds*heat)%60);
                    if(startMinute+(raceMinutes*heat-1)<60)
                    {
                        startMinute += (raceMinutes * heat);
                        Log.d("TimeUpdate", "1");
                    }
                    else if(startMinute+(raceMinutes*heat-1)==60)
                    {
                        startMinute = 0;
                        startHour+=1;
                        Log.d("TimeUpdate", "2");
                    }
                    else if(startMinute+(raceMinutes*heat-1)>60)
                    {
                        if(startMinute+(raceMinutes*heat-1)<120) {
                            startMinute = startMinute+(raceMinutes*heat-1)-60;
                            startHour+=1;
                            Log.d("TimeUpdate", "3");
                        }
                        else
                        {
                            startMinute = startMinute+(raceMinutes*heat-1)-120;
                            startHour+=2;
                            Log.d("TimeUpdate", "4");
                            //assumes that you cannot have a single event run for more than 2 hours
                        }
                    }
                }
                race.setStartTime(startHour,startMinute);
                Log.d("TimeUpdate", "Complete");
            }
        }
    }
}
