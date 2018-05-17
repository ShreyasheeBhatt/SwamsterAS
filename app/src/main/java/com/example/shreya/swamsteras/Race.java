package com.example.shreya.swamsteras;

/**
 * Created by Shreya on 3/28/2018.
 */

import java.sql.Time;
import java.util.*;

public class Race
{
    private int heat;
    private int lane;
    private double swimTime;
    private String swimmer;

    /**
     * Constructs a Race object.
     * @param heatNum
     * @param laneNum
     * @param timeSwam
     * @param swim
     */
    public Race(int heatNum, int laneNum, double timeSwam, String swim)
    {
        heat = heatNum;
        lane = laneNum;
        swimTime = timeSwam;
        swimmer = swim;
    }

    /**
     * Constructs a Race object.
     */
    public Race() {

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
     * Sets the heat number of the race.
     * @param heat
     */
    public void setHeat(int heat) {
        this.heat = heat;
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
     * Sets the lane number of the race.
     * @param lane
     */
    public void setLane(int lane) {
        this.lane = lane;
    }

    /**
     * Gets the swimmer swimming in the race.
     * @return swimmer
     */
    public String getSwimmer() { return swimmer;}

    /**
     * Sets the swimmer swimming in the race.
     * @param swimmer
     */
    public void setSwimmer(String swimmer) {
        this.swimmer = swimmer;
    }

    /**
     * Gets the time it took to swim the race.
     * @return swimTime
     */
    public double getSwimTime() {
        return swimTime;
    }

    /**
     * Sets the time it took to swim the race.
     * @param swimTime
     */
    public void setSwimTime(double swimTime) {
        this.swimTime = swimTime;
    }
}