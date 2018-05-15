package com.example.shreya.swamsteras;

import java.sql.Time;
import java.util.ArrayList;

/**
 * Created by Shreya 3/28/2018
 */

public class Event {

    private String eventName;
    private ArrayList<Swimmer> swimmer;

    public Event(String event, ArrayList<Swimmer> swimmers){
        eventName = event;
        swimmer = swimmers;
    }

    public Event()
    {
    }

    /**
     * Set the event name.
     * @param event
     */
    public void setEventName(String event) {
        eventName = event;
    }

    public ArrayList<Swimmer> getSwimmer() {
        return swimmer;
    }

    public void setSwimmer(ArrayList<Swimmer> swimmer) {
        this.swimmer = swimmer;
    }

    public String getEventName() {
        return eventName;
    }
}