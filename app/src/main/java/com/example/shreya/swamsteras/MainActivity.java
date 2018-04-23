package com.example.shreya.swamsteras;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import android.widget.Button;

import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import junit.framework.Test;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d ("charles","first");



/*    public void onClick(Button doneButton) {
        Intent intent = new Intent(this, SwimAndCoachAns.class);
        startActivity(intent);
    }
*/

        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference eventRef = database.getReference("server");

        eventRef.setValue("this is a big test");

        DataBaser data = new DataBaser();
        String tested = data.getTest();
        Log.d ("charles",tested+"cool");

        Log.d ("charles","last");

/*        eventRef.addValueEventListener(new ValueEventListener(){
                                           @Override
                                           public void onDataChange(DataSnapshot dataSnapshot) {
                                              String test = dataSnapshot.getValue(String.class);
                                              Log.d("charles",test);
                                           }

                                           @Override
                                           public void onCancelled(DatabaseError databaseError) {
                                               System.out.println("The read failed: " + databaseError.getCode());
                                           }
    });
*/
//    public void onClick(View v) {
//            startActivity(new Intent(MainActivity.this, swimmerandcoach.class));

}}