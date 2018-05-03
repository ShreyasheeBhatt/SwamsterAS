package com.example.shreya.swamsteras;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class SwimAndCoachAns extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swim_and_coach_ans);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference teamRef = database.getReference("meet");

        ArrayList<String> teams = new ArrayList<>();
        teams.add("Aria");
        teams.add("Shreya");
        teams.add("Ellie");
        teamRef.setValue(teams);

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

//    dropdown.setAdapter(adapter);
}

//    @Override
//    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
//        String text = parent.getItemAtPosition(position).toString();
//        Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
//    }

}
