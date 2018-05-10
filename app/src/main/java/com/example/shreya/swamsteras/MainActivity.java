package com.example.shreya.swamsteras;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //The swimmer/coach button on the main page connects to the login page.
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
