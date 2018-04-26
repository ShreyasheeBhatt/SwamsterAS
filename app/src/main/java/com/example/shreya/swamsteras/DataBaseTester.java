package com.example.shreya.swamsteras;

import android.os.Bundle;

import java.sql.Time;
import java.util.ArrayList;

public class DataBaseTester {
    public static void main(String []args){
        Race fly50 = new Race("15 & over 50 meter Butterly", 9, 4, 0,"Ayy");
        Race free50 = new Race("15 & over 50 meter Freestyle", 12, 2, 0,"Lmao");
        Race free200 = new Race("15 & over 200 meter Freestyle", 3, 5, 0,"Aeiou");
        ArrayList<Race> races = new ArrayList<Race>();
        races.add(fly50);
        races.add(free50);
        races.add(free200);
        Time time = new Time( 9, 3, 51);
        Event man = new Event("hello", time, races);
        System.out.println(man.getEventName());
        DataBaser data = new DataBaser();
        String test = data.getTest();
        System.out.println(data.bigTest());
        //System.out.println(data.test;
    }
}
