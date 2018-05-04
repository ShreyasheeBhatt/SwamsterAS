package com.example.shreya.swamsteras;

import android.os.Bundle;
import android.provider.CalendarContract;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.IOException;
import java.sql.Time;
import java.util.ArrayList;

public class TimeUpdate extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_update);
    }

    public void getInfo(android.view.View view)
    {
        EditText name = findViewById(R.id.eventName);
        EditText start = findViewById(R.id.startTime);
        EditText mins = findViewById(R.id.minutesPerRace);
        EditText secs = findViewById(R.id.secondsPerRace);

        String eventName = name.getText().toString();
        Time startTime = Time.valueOf(start.getText().toString());
        int startHour = startTime.getHours();
        int startMinute = startTime.getMinutes();
        int raceMinutes = Integer.parseInt(mins.getText().toString());
        int raceSeconds = Integer.parseInt(secs.getText().toString());


        Log.d("TimeUpdate", eventName + "\nEvent Start Time: " + startHour + ":" + startMinute + "\nTime per Race: " + raceMinutes + " minutes " + raceSeconds + " seconds");
        ArrayList<Event> events = new ArrayList<Event>();
        ArrayList<Swimmer> swimmers = new ArrayList<Swimmer>();
        ArrayList<Race> races = new ArrayList<Race>();

        csvParse csv = new csvParse();
        events = csv.getEvents();
        swimmers = csv.getSwimmers();
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
