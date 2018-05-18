package com.example.shreya.swamsteras;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.google.firebase.database.FirebaseDatabase;

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

        //Recieves the packaged variables from the TimeUpdate class.
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

        //Here the database will be called and will enable writing to the database.

        /*
        //For each swimmer in a particular event, it will calculate the expected time of the Race minus 5 minutes to give the notification time for the given swimmer.
        for(Swimmer swimmer : swimmers)
        {
            races = swimmer.getRaceList();
            //For each race in a particular event, it calculates the time for the notification, which is 5 minutes before the estimated race start time.
            for(Race race : races)
            {
                if(eventName.equals(race.getEvent()))
                {
                    heat = race.getHeat();
                    raceMinutes+=(raceMinutes*(heat-1)-5);
                    raceSeconds+=(raceSeconds*(heat-1));
                    raceMinutes+=((raceSeconds*heat)%60);

                    //This if calculates the start hour and start minutes of the race when the minutes for the estimated time is less than one hour.
                    if(startMinute+(raceMinutes*heat-1)<60)
                    {
                        startMinute += (raceMinutes * heat);
                    }
                    //This else if calculates the start hour and start minutes of the race when the minutes for the estimated time is exactly one hour.
                    else if(startMinute+((raceMinutes*heat-1)-5)==60)
                    {
                        startMinute = 0;
                        startHour+=1;
                        startHour=startHour%24;
                    }
                    //This else if calculates the start hour and start minutes of the race when the minutes for the estimated time is greater than one hour.
                    else if(startMinute+((raceMinutes*heat-1)-5)>60)
                    {
                        //This if calculates the start hour and start minutes of the race when the minutes for the estimated time is greater than one hour but less than to hours.
                        if(startMinute+(raceMinutes*heat-1)<120) {
                            startMinute = startMinute+(raceMinutes*heat-1)-65;
                            startHour+=1;
                            startHour=startHour%24;
                        }
                        //This else calculates the start hour and start minutes of the race when the minutes for the estimated time is greater than two hours but less than three hours.
                        else
                        {
                            startMinute = startMinute+(raceMinutes*heat-1)-125;
                            startHour+=2;
                            //assumes that you cannot have a single event run for more than 3 hours
                            startHour=startHour%24;
                        }
                    }
                }
                //Updates the swimmer's race time.
                race.setStartHour(startHour);
                race.setStartMinutes(startMinute);
            }
        }
        */
    }
}
