package com.example.shreya.swamsteras;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class SwimAndCoachAns extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swim_and_coach_ans);

    Spinner dropdown = findViewById(R.id.meetChoices);
    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.schools, android.R.layout.simple_spinner_item);
    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    dropdown.setAdapter(adapter);
//    dropdown.setOnItemSelectedListener(this);

    Spinner dropdown2 = findViewById(R.id.teamChoices);
    ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.teams, android.R.layout.simple_spinner_item);
    adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    dropdown2.setAdapter(adapter2);

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

//    @Override
//    public void onNothingSelected(AdapterView<?> adapterView) {
//
//    }
}
