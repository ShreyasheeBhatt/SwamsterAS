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
        Log.d("test", teamName);

        final List<String> swimmerList = new ArrayList();
        final ListView swimmers = findViewById(R.id.swimmersList);

        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference teamRef = database.getReference("0");

        teamRef.addValueEventListener(new ValueEventListener() {
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
                        String team = swimmer.getTeam();
                        if(team.equals(teamName)) {
                            Log.d("test", "Team name: " + team);
                            swimmerList.add(swimmer.getFirstName());

                        }
                    }
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
        ArrayAdapter adapter = new ArrayAdapter<String>(swimmers.getContext(), android.R.layout.simple_list_item_1, swimmerList);
        swimmers.setAdapter(adapter);
    }
}
