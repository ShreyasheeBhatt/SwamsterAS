package com.example.shreya.swamsteras;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DatabasePopulator {
    public static void main(String []args){
        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference testRef = database.getReference("swamsteras");

        testRef.setValue("Giggidy giggidy");
    }
}
