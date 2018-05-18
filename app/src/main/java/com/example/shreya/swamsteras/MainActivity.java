package com.example.shreya.swamsteras;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //The swimmer choice button leads to the coach or swimmer page.
        final Button swimCoachButton = findViewById(R.id.swimmerChoiceButton);
        swimCoachButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), coachOrSwimmer.class);
                startActivity(intent);
            }
        });

        //The admin button on the main page connects to the terms/conditions page.
        final Button adminButton = findViewById(R.id.adminChoiceButton);
        adminButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), adminLogin.class);
                startActivity(intent);
            }
        });
    }
}
