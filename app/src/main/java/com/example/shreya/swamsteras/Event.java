package com.example.shreya.swamsteras;

import java.sql.Time;
import java.util.ArrayList;

/**
 * Created by Charles 4/6/2018
 */

public class Event {

    private String eventName;
    private Time eventTime;
    private ArrayList<Race> races;

    public Event(String event, Time time, ArrayList<Race> race){
        eventName = event;
        eventTime = time;
        races = race;
    }

    /**
     * Gets name of the event.
     * @return event name.
     */
    public String getEventName(){
        return eventName;
    }

    /**
     * Gets time of the event.
     * @return event time.
     */
    public Time getEventTime(){
        return eventTime;
    }

    /**
     * Gets an ArrayList of races or heats within the event.
     * @return list of races.
     */
    public ArrayList<Race> getRaces() {
        return races;
    }
}
