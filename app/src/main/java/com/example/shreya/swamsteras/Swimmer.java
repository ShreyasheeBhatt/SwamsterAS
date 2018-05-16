package com.example.shreya.swamsteras; /**
 * Created by Shreya on 3/28/2018.
 */

import java.math.BigInteger;
import java.util.*;

public class Swimmer {
    private String event;
    private String lastName;
    private String firstName;
    private String races;
    private String team;
    private int age;
    private ArrayList<Race> raceList;
    private long uniqueID;

    public Swimmer(int numYrs, String eventName, String last, String first, ArrayList<Race> race, String racess, String teamName, long id)
    {
        lastName = last;
        firstName = first;
        age = numYrs;
        team = teamName;
        raceList = race;
        races = racess;
        uniqueID = id;
    }

    public Swimmer() {
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getRaces() {
        return races;
    }

    public void setRaces(String races) {
        this.races = races;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public ArrayList<Race> getRaceList() {
        return raceList;
    }

    public void setRaceList(ArrayList<Race> raceList) {
        this.raceList = raceList;
    }

    public long getUniqueID() {
        return uniqueID;
    }

    public void setUniqueID(long uniqueID) {
        this.uniqueID = uniqueID;
    }

    public String getLastName() {

        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Converts com.example.shreya.swamsteras.Swimmer object to a string.
     */
    @Override
    public String toString() {
        return (lastName + ", " + firstName + " \tAge: " + age + " years" + "\nRaces: " + getRaces());
    }
}