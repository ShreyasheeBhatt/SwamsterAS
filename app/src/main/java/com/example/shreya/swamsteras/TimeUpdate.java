package com.example.shreya.swamsteras;

import android.content.Intent;
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

public class TimeUpdate extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_update);
        Log.d("TimeUpdate", "Entered TimeUpdate");

    final Button timeButton = findViewById(R.id.updateButton);
        Log.d("TimeUpdate", "Completed button creation.");
        timeButton.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View view)
            {
                EditText name = findViewById(R.id.eventName);
                EditText start = findViewById(R.id.startTime);
                EditText mins = findViewById(R.id.minutesPerRace);
                EditText secs = findViewById(R.id.secondsPerRace);
                Log.d("TimeUpdate", "Parsed Text from Views");

                String eventName = name.getText().toString();
                Time startTime = Time.valueOf(start.getText().toString());
                int startHour = startTime.getHours();
                int startMinute = startTime.getMinutes();
                int raceMinutes = Integer.parseInt(mins.getText().toString());
                int raceSeconds = Integer.parseInt(secs.getText().toString());
                Log.d("TimeUpdate", "Parsed Information");


                Log.d("TimeUpdate", eventName + "\nEvent Start Time: " + startHour + ":" + startMinute + "\nTime per Race: " + raceMinutes + " minutes " + raceSeconds + " seconds");

                Intent intent = new Intent(view.getContext(), UpdateTime.class);
                intent.putExtra("eventName", eventName);
                intent.putExtra("startTime", startTime.toString());
                intent.putExtra("startHour", startHour);
                intent.putExtra("startMinute", startMinute);
                intent.putExtra("raceMinutes", raceMinutes);
                intent.putExtra("raceSeconds", raceSeconds);
                startActivity(intent);
            }
        });
    }
}


