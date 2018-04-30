package com.example.shreya.swamsteras;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by Shreya on 4/23/18.
 */

public class csvParse extends AppCompatActivity
{
    private ArrayList<Event> events;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        events = new ArrayList<Event>();
        readEventData();
        Log.d("csvParse","Event: " + events.get(0).getEventName());
        for (Event event : events)
            Log.d("csvParse", "\nTime: " + event.getEventTime() + " " + stuffToString(event.getRaces().toString()) + " \n\tName: " + stuffToString(event.getNames()));
    }

    public void readEventData()
    {
        //Read the data from the file
        InputStream is = getResources().openRawResource(R.raw.data);
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));

        String line = "";
        try
        {
            while ((line = reader.readLine()) != null)
            {
                //Split line by ","
                String[] fields = line.split(",");
                Event e = new Event();
                ArrayList<String> s = new ArrayList<>();
                ArrayList<Race> r = new ArrayList<>();
                e.setEventName(fields[0]);
                e.setEventTime(null);
                e.setNames(s);
                e.setRaces(r);
                e.addRaces(new Race(fields[0],Integer.parseInt(fields[2]), Integer.parseInt(fields[3]), 0));
                e.addNames((fields[4]+" " + fields[5]));
                events.add(e);
            }
        }

        catch (IOException ex)
        {
            Log.d("csvParse", "Error reading data from file on line " + line);
        }
    }

    public String stuffToString(String s)
    {
        String string = s.replace("[", " ");
        string = string.replace("]","");
        return string;
    }
}