package com.example.shreya.swamsteras;

/**
 * Created by Shreya 3/28/2018
 */

import java.sql.Time;
import java.util.ArrayList;

public class Event {

    private String eventName;
    private ArrayList<Swimmer> swimmer;

    /**
     * Constructs an Event object.
     * @param event
     * @param swimmers
     */
    public Event(String event, ArrayList<Swimmer> swimmers) {
        eventName = event;
        swimmer = swimmers;
    }

    /**
     * Constructs an Event object.
     */
    public Event() {
    }

    /**
     * Gets the name of the event.
     * @return eventName
     */
    public String getEventName() {
        return eventName;
    }

    /**
     * Sets the event name.
     * @param event
     */
    public void setEventName(String event) {
        eventName = event;
    }

    /**
     * Gets the list of Swimmers participating in the event.
     * @return list of Swimmers
     */
    public ArrayList<Swimmer> getSwimmer() {
        return swimmer;
    }

    /**
     * Sets the list of Swimmers participating in the event.
     * @param swimmer
     */
    public void setSwimmer(ArrayList<Swimmer> swimmer) {
        this.swimmer = swimmer;
    }


}
