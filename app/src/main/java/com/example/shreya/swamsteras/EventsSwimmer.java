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

        Log.d("test", "1. Gets here.");

        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference swimRef = database.getReference("0");

        Log.d("test", "2. Gets here.");

        swimRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Log.d("test", "4. Gets here.");
                Event event;
                Log.d("test", "5. Gets here.");
                for (DataSnapshot data : dataSnapshot.getChildren()) {
                    Log.d("test", "6. Gets here.");
                    event = data.getValue(Event.class);
                    Log.d("test", "7. Gets here.");
                    ArrayList<Swimmer> swimmers = event.getSwimmer();
                    if(swimmers == null) {
                        Log.d("test", "NULL");
                    }
                    Log.d("test", "Gets here.");
                    for(Swimmer swimmer : swimmers) {
                        Log.d("test", "Last Name: " + swimmer.getLastName());
                        String last = swimmer.getLastName();
                        String first = swimmer.getFirstName();
                        if(last.equals(lastName) && first.equals(firstName)) {
                            Log.d("test", "Last Name: " + last + "First Name: " + first);
                            eventsList.add(swimmer.getEvent());
                            ArrayList<Race> races = swimmer.getRaceList();
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