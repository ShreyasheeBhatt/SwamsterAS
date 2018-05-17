package com.example.shreya.swamsteras;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.style.CharacterStyle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
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

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference teamRef = database.getReference("teams");
        final Spinner dropdown = findViewById(R.id.meetChoices);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.meets, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dropdown.setAdapter(adapter);

        final Spinner dropdown2 = findViewById(R.id.teamChoices);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.teams, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dropdown2.setAdapter(adapter2);

        final Spinner dropdown3 = findViewById(R.id.ageChoices);
        ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(this, R.array.ages,android.R.layout.simple_spinner_item);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dropdown3.setAdapter(adapter3);

    final EditText first = findViewById(R.id.firstInput);
    final EditText last = findViewById(R.id.lastInput);

    final Button finishButton = findViewById(R.id.finish);
        finishButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                String firstName = first.getText().toString();
                String lastName = last.getText().toString();
                Bundle bundle = new Bundle();
                bundle.putString("firstName", firstName);
                bundle.putString("lastName", lastName);
                Intent intent = new Intent(view.getContext(), EventsSwimmer.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

    }
}
