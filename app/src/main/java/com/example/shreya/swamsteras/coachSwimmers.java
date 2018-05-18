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

public class coachSwimmers extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coach_swimmers);

        Intent intent = getIntent();
        Bundle strings = intent.getExtras();

        final String teamName = strings.getString("team");
        final List<String> swimmerList = new ArrayList();
        final ListView swimmers = findViewById(R.id.swimmersList);
        final FirebaseDatabase database = FirebaseDatabase.getInstance();

        /* Gets a database reference for the main node in our database. */
        DatabaseReference teamRef = database.getReference("0");

        /* Creates a new ValueEventListener which enables pulling data from the database. */
        teamRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Event event;

                /* Loops through the children in our main database node. */
                for (DataSnapshot data : dataSnapshot.getChildren()) {

                    /* Sets Event event to the Event in the particular child node. */
                    event = data.getValue(Event.class);

                    /* Sets the ArrayList of Swimmers to the event's swimmer list. */
                    ArrayList<Swimmer> swimmers = event.getSwimmer();

                    /* Loops through the list of swimmers in the event. */
                    for(Swimmer swimmer : swimmers) {

                        /* Sets the team variable to the swimmer's team. */
                        String team = swimmer.getTeam();

                        /* Checks if the coach's inputted team matches the swimmer's team. If they match, the swimmer is added to the swimmer list to be viewed. */
                        if(team.equals(teamName)) {
                            swimmerList.add(swimmer.forCoachView());
                        }
                    }
                }
                /* Sets the adapter to show all the swimmers' names and event information. */
                ArrayAdapter adapter = new ArrayAdapter<>(swimmers.getContext(), android.R.layout.simple_list_item_1, swimmerList);
                swimmers.setAdapter(adapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });

    }
}
