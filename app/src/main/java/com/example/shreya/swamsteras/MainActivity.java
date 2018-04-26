package com.example.shreya.swamsteras;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = findViewById(R.id.swimmerChoiceButton2);
        btn.setOnClickListener(new View.OnClickListener(){
        public void onClick(View view) {
            Intent intent = new Intent(view.getContext(), SwimAndCoachAns.class);
            startActivity(intent);
        }
        });
    }
}