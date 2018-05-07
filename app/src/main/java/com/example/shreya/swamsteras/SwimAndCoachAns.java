package com.example.shreya.swamsteras;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReferenceArray;

public class SwimAndCoachAns extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swim_and_coach_ans);

        final Button finishButton = findViewById(R.id.finish);
        finishButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), EventsSwimmer.class);
                startActivity(intent);
            }
        });

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference teamRef = database.getReference("meet");

/*       ArrayList<String> teams = new ArrayList<>();
        teams.add("Aria");
        teams.add("Shreya");
        teams.add("Ellie");
        teamRef.setValue(teams);

        ArrayList<String> swams = new ArrayList<>();
        swams.add("Black");
        swams.add("Brown");
        swams.add("White");
        teamRef.setValue(swams);

        ArrayList<ArrayList<String>> combo = new ArrayList<>();
        combo.add(swams);
        combo.add(teams);
        teamRef.setValue(combo);

        Race fly50 = new Race("15 & over 50 meter Butterly", 9, 4, 0, null, "Ayy");
        Race free50 = new Race("15 & over 50 meter Freestyle", 12, 2, 0, null, "Lmao");
        Race free200 = new Race("15 & over 200 meter Freestyle", 3, 5, 0, null, "Aeiou");
        ArrayList<Race> races = new ArrayList<Race>();
        races.add(fly50);
        races.add(free50);
        races.add(free200);
        Swimmer shreya = new Swimmer("Bhatt","Shreya", 16, "Evo", races);
        Swimmer emma = new Swimmer("Kudej","Emma", 16, "Evo", races);
        ArrayList<Swimmer> swimarray = new ArrayList<>();
        swimarray.add(shreya);
        swimarray.add(emma);
        teamRef.setValue(swimarray);
*/


        teamRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                ArrayList<String> teamList = (ArrayList<String>) dataSnapshot.getValue();

                Spinner dropdown2 = findViewById(R.id.teamChoices);
                ArrayAdapter<String> adapter2 = new ArrayAdapter<>(SwimAndCoachAns.this, android.R.layout.simple_spinner_item, teamList);
                adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                dropdown2.setAdapter(adapter2);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("Error", "Failed to read value.", error.toException());
            }
        });

    Spinner dropdown = findViewById(R.id.meetChoices);
    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.meets, android.R.layout.simple_spinner_item);
    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    dropdown.setAdapter(adapter);

    Spinner dropdown3 = findViewById(R.id.ageChoices);
    ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(this, R.array.ages, android.R.layout.simple_spinner_item);
    adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    dropdown3.setAdapter(adapter3);

    TextView first = findViewById(R.id.firstText);
    TextView last = findViewById(R.id.firstText);
    String firstName = first.getText().toString();
    String lastName = last.getText().toString();

}
}
