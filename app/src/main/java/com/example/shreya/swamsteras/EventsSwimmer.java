package com.example.shreya.swamsteras;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class EventsSwimmer extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events_swimmer);

        Intent intentExtras = getIntent();
        Bundle strings = intentExtras.getExtras();

        final String firstName = strings.getString("firstName");
        final String lastName = strings.getString("lastName");

        final ListView events = findViewById(R.id.listOfEvents);
        final List<String> eventsList = new ArrayList();


        final ListView heats = findViewById(R.id.listOfHeats);
        final List<String> heatsList = new ArrayList();


        final ListView lanes = findViewById(R.id.listOfLanes);
        final List<String> lanesList = new ArrayList();

        final FirebaseDatabase database = FirebaseDatabase.getInstance();

        //Gets a database reference for the main node in our database.
        DatabaseReference swimRef = database.getReference("0");

        //Creates a new ValueEventListener which enables pulling data from the database.
        swimRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                /* Sets Event event to the Event in the particular child node. */
                Event event;

                /* Loops through the children in our main database node.*/
                for (DataSnapshot data : dataSnapshot.getChildren()) {

                    /* Sets Event event to the Event in the particular child node. */
                    event = data.getValue(Event.class);

                    /* Sets the ArrayList of Swimmers to the event's swimmer list. */
                    ArrayList<Swimmer> swimmers = event.getSwimmer();

                    /* Loops through the list of swimmers in the event. */
                    for(Swimmer swimmer : swimmers) {
                        String last = swimmer.getLastName();
                        String first = swimmer.getFirstName();

                        /* Checks to see if the swimmer's last name and first name match the first and last name that the user inputted on the last page. */
                        if(last.equals(lastName) && first.equals(firstName)) {

                            /* Adds the swimmer's event to the event list to be viewed. */
                            eventsList.add(swimmer.getEvent());

                            /* Sets the ArrayList of Races to the event's race list. */
                            ArrayList<Race> races = swimmer.getRaceList();

                            /* Loops through the races, adding the heat and lane of each race. */
                            for(Race race : races) {
                                heatsList.add(String.valueOf(race.getHeat()));
                                lanesList.add(String.valueOf(race.getLane()));
                            }

                        }
                    }
                }
                ArrayAdapter adapter = new ArrayAdapter<String>(events.getContext(), android.R.layout.simple_list_item_1, eventsList);
                events.setAdapter(adapter);

                ArrayAdapter adapter2 = new ArrayAdapter<String>(heats.getContext(), android.R.layout.simple_list_item_1, heatsList);
                heats.setAdapter(adapter2);

                ArrayAdapter adapter3 = new ArrayAdapter<String>(lanes.getContext(), android.R.layout.simple_list_item_1, lanesList);
                lanes.setAdapter(adapter3);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
    }
}