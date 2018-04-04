package com.example.shreya.swamsteras;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.shreya.swamsteras.SwamsterEclipse.swimmerandcoach;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);}

    public void onClick(View v) {
            startActivity(new Intent(MainActivity.this, swimmerandcoach.class));
        }
}