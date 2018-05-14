package com.example.shreya.swamsteras; /**
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

    public Race(int heatNum, int laneNum, double timeSwam, String swim)
    {
        heat = heatNum;
        lane = laneNum;
        swimTime = timeSwam;
        swimmer = swim;
    }

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

    public void setHeat(int heat) {
        this.heat = heat;
    }

    public void setLane(int lane) {
        this.lane = lane;
    }

    public double getSwimTime() {
        return swimTime;
    }

    public void setSwimTime(double swimTime) {
        this.swimTime = swimTime;
    }

    public void setSwimmer(String swimmer) {
        this.swimmer = swimmer;
    }
}