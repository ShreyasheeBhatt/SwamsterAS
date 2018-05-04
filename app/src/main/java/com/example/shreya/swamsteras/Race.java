package com.example.shreya.swamsteras; /**
 * Created by Shreya on 3/28/2018.
 */
import java.sql.Time;
import java.util.*;

public class Race
{
    private String event;
    private int heat;
    private int lane;
    private double time;
    private Time startTime;
    private String swimmer;

    public Race(String eventName, int heatNum, int laneNum, double timeSwam, Time timeStart, String swim)
    {
        event = eventName;
        heat = heatNum;
        lane = laneNum;
        time = timeSwam;
        startTime = timeStart;
        swimmer = swim;
    }


    /**
     * Gets the event of the race.
     * @return event name
     */
    public String getEvent()
    {
        return event;
    }

    /**
     * Gets the heat number of the race.
     * @return heat number
     */
    public int getHeat()
    {
        return heat;
    }

    /**
     * Gets the lane number of the race.
     * @return lane number
     */
    public int getLane()
    {
        return lane;
    }

    /**
     * Gets swimmer of race.
     * @return swimmer
     */
    public String getSwimmer() { return swimmer;}

    /**
     * Gets the time it took to swim the race.
     * @return time
     */
    public double getSwimTime()
    {
        return time;
    }

    /**
     *
     */
    public Time getStartTime()
    {
        return startTime;
    }

    /**
     * Changes the final swim time.
     * @param timeSwam the time it took to swim the race
     * @return time
     */
    public double changeSwimTime(double timeSwam)
    {
        time = timeSwam;
        return time;
    }

    public Time setStartTime(int hours, int minutes)
    {
        startTime.setHours(hours);
        startTime.setMinutes(minutes);
        return startTime;
    }

    /**
     * Converts com.example.shreya.swamsteras.Race object to a string.
     */
    @Override
    public String toString() {
        return ("\nEvent: " + event + "\n\tHeat: " + heat + "\n\tLane: " + lane + "\n\tTime: " + time);
    }
}