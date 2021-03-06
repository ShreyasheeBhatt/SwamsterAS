package com.example.shreya.swamsteras;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class coachLogin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coach_login);

        //The meet choices spinner displays the meets.
        Spinner dropdown = findViewById(R.id.meetChoices);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.meets, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dropdown.setAdapter(adapter);

        final EditText teamChoice = findViewById(R.id.teamChoices);

        /**
         * This button leads to the coach's page where they can view their swimmers and their events.
         */
        final Button findButton = findViewById(R.id.find);
        findButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                String team = teamChoice.getText().toString();
                bundle.putString("team",team);
                Intent intent = new Intent(view.getContext(), coachSwimmers.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }
}