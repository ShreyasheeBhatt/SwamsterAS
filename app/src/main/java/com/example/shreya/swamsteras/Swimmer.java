package com.example.shreya.swamsteras;

/**
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

    /**
     * Constructs a Swimmer object.
     * @param numYrs
     * @param eventName
     * @param last
     * @param first
     * @param race
     * @param racess
     * @param teamName
     * @param id
     */
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

    /**
     * Constructs a Swimmer object.
     */
    public Swimmer() {
    }

    /**
     * Gets the event the swimmer is participating in.
     * @return event name
     */
    public String getEvent() {
        return event;
    }

    /**
     * Sets the event the swimmer is participating in.
     * @param event
     */
    public void setEvent(String event) {
        this.event = event;
    }

    /**
     * Gets the swimmer's first name.
     * @return firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the swimmer's first name.
     * @param firstName
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets the swimmer's race in this particular event.
     * @return race list
     */
    public String getRaces() {
        return races;
    }

    /**
     * Sets the swimmer's race in this particular event.
     * @param races
     */
    public void setRaces(String races) {
        this.races = races;
    }

    /**
     * Gets the swimmer's swim team.
     * @return team
     */
    public String getTeam() {
        return team;
    }

    /**
     * Sets the swimmer's swim team.
     * @param team
     */
    public void setTeam(String team) {
        this.team = team;
    }

    /**
     * Gets the swimmer's age.
     * @return age
     */
    public int getAge() {
        return age;
    }

    /**
     * Sets the swimmer's age.
     * @param age
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Gets the swimmer's entire list of races.
     * @return raceList
     */
    public ArrayList<Race> getRaceList() {
        return raceList;
    }

    /**
     * Sets the swimmer's list of races.
     * @param raceList
     */
    public void setRaceList(ArrayList<Race> raceList) {
        this.raceList = raceList;
    }

    /**
     * Gets the swimmer's unique ID number.
     * @return uniqueID
     */
    public long getUniqueID() {
        return uniqueID;
    }

    /**
     * Sets the swimmer's unique ID number.
     * @param uniqueID
     */
    public void setUniqueID(long uniqueID) {
        this.uniqueID = uniqueID;
    }

    /**
     * Gets the swimmer's last name.
     * @return lastName
     */
    public String getLastName() {

        return lastName;
    }

    /**
     * Sets the swimmer's last name.
     * @param lastName
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String forCoachView() {
        return (lastName + ", " + firstName + "\t | \tAge: " + age + " years" + "\nEvent: " + event + "\nRaces: " + getRaces());
    }

    /**
     * Converts com.example.shreya.swamsteras.Swimmer object to a string.
     */
    @Override
    public String toString() {
        return (lastName + ", " + firstName + "\t | \tAge: " + age + " years" + "\nRaces: " + getRaces());
    }
}