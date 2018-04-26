package com.example.shreya.swamsteras;

import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

/**
 * Created by Charles 4/5/2018
 */
public class DataBaser {

    private Swimmer swimmer;
    private Event event;
    private Race race;
    private String test;

    public DataBaser(){
    }

    public String bigTest() {
       return "test";
    }

    public String getTest() {
        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference eventRef = database.getReference("server");

        eventRef.addValueEventListener(new ValueEventListener(){
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
               test = dataSnapshot.getValue(String.class);
               Log.d ("charles", "read");
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                System.out.println("The read failed: " + databaseError.getCode());
            }


        });
        Log.d ("charles","before send");
        return test+"noice ";

    }

    /**
     * Gets event from database.
     * @return event
     */
    public Event getDatabaseEvents() {
        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference eventRef = database.getReference("events");

        eventRef.addValueEventListener(new ValueEventListener(){
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                event = dataSnapshot.getValue(Event.class);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                System.out.println("The read failed: " + databaseError.getCode());
            }

        });
        return event;
    }

    /**
     * Gets swimmer from the database.
     * @return swimmer
     */
    public Swimmer getDatabaseSwimmer() {
        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference eventRef = database.getReference("swimmers");

        eventRef.addValueEventListener(new ValueEventListener(){
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                swimmer = dataSnapshot.getValue(Swimmer.class);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                System.out.println("The read failed: " + databaseError.getCode());
            }

        });
        return swimmer;
    }

    /**
     * Gets race from the database.
     * @return race
     */
    public Race getDatabaseRace() {
        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference eventRef = database.getReference("events");

        eventRef.addValueEventListener(new ValueEventListener(){
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                race = dataSnapshot.getValue(Race.class);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                System.out.println("The read failed: " + databaseError.getCode());
            }

        });
        return race;
    }
}
