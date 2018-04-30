package com.example.shreya.swamsteras;

import java.sql.Time;
import java.util.ArrayList;

/**
 * Created by Shreya 3/28/2018
 */

public class Event {

    private String eventName;
    private Time eventTime;
    private ArrayList<String> names;
    private ArrayList<Race> races;

    public Event(String event, ArrayList<String> swimmerNames, Time time, ArrayList<Race> race){
        eventName = event;
        names = swimmerNames;
        eventTime = time;
        races = race;
    }

    public Event()
    {
        eventName = "";
        names = null;
        eventTime = null;
        races = null;
    }

    /**
     * Set the event name.
     * @param event
     */
    public void setEventName(String event) {
        eventName = event;
    }

    /**
     * Make the list of swimmer names.
     * @param swimmerNames
     */
    public void setNames(ArrayList<String> swimmerNames) {
        names = swimmerNames;
    }

    /**
     * Add swimmer names to the list of swimmer names.
     * @param swimmerName
     */
    public void addNames(String swimmerName) {
        names.add(swimmerName);
    }

    /**
     * Set the time the event will begin.
     * @param time
     */
    public void setEventTime(Time time) {
        eventTime = time;
    }

    /**
     * Make a list of races within the event.
     * @param raceS
     */
    public void setRaces(ArrayList<Race> raceS) {
        races = raceS;
    }

    /**
     * Add a race to the list of races within the event.
     * @param race
     */
    public void addRaces(Race race) {
        races.add(race);
    }

    //***************************//

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
     * Gets an Arraylist of races or heats within the event.
     * @return list of races.
     */
    public ArrayList<Race> getRaces() {
        return races;
    }

    /**
     * Gets the list of names of the swimmers.
     * @return
     */
    public String getNames() {
        return names.toString();
    }

    public String getFirstNames() {
        String[] s = null;
        for (int n=0; n<names.size()-1; n++)
        {
            String name = names.get(n);
            s = name.split(" ");
        }
        return s[0];
    }

    public String getLastNames() {
        String[] s = null;
        for (int n=0; n<names.size()-1; n++)
        {
            String name = names.get(n);
            s = name.split(" ");
        }
        return s[0];
    }
}
