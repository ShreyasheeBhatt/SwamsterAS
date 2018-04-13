package com.example.shreya.swamsteras;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class SwimAndCoachAns extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swim_and_coach_ans);

    Spinner dropdown = findViewById(R.id.spinner1);
    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.schools, android.R.layout.simple_spinner_item);
    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    dropdown.setAdapter(adapter);
//    dropdown.setOnItemSelectedListener(this);

    Spinner dropdown2 = findViewById(R.id.spinner2);
    ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.teams, android.R.layout.simple_spinner_item);
    adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    dropdown2.setAdapter(adapter2);

    Spinner dropdown3 = findViewById(R.id.spinner3);
    ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(this, R.array.ages, android.R.layout.simple_spinner_item);
    adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    dropdown3.setAdapter(adapter);

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
