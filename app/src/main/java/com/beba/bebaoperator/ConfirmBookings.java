package com.beba.bebaoperator;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;

import java.util.HashMap;
import java.util.Map;

public class ConfirmBookings extends AppCompatActivity {

    private FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_bookings);



        Button btnNo = findViewById(R.id.btnNo);
        Button btnYes = findViewById(R.id.btnYes);

        String receivedId = getIntent().getStringExtra("Userid");



        btnYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Toast.makeText(view.getContext(), "Booking Confirmed" , Toast.LENGTH_LONG).show();
                                            Intent intent =  new Intent(ConfirmBookings.this, LandingPage.class);
                                            startActivity(intent);

//                db.collection("Bookings")
//                        .whereEqualTo("matatubooked", receivedId)
//                        .get()
//                        .addOnSuccessListener(queryDocumentSnapshots -> {
//                            for (QueryDocumentSnapshot documentSnapshot : queryDocumentSnapshots) {
//                                String documentId = documentSnapshot.getId();
//                                Map<String, Object> updates = new HashMap<>();
//                                updates.put("status", "booked");
//                                db.collection("bookings").document(documentId)
//                                        .update(updates)
//                                        .addOnSuccessListener(aVoid -> {
//
//                                            Toast.makeText(view.getContext(), "Booking Confirmed" , Toast.LENGTH_LONG).show();
//                                            Intent intent =  new Intent(ConfirmBookings.this, LandingPage.class);
//                                            startActivity(intent);
//
//                                            Log.d(TAG, "Booking successfully updated!");
//                                        })
//                                        .addOnFailureListener(e -> {
//                                            Log.w(TAG, "Error updating booking", e);
//                                        });
//                            }
//                        })
//                        .addOnFailureListener(e -> {
//                            Log.d(TAG, "Error fetching bookings: " + e.getMessage());
//                        });


            }
        });


        btnNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent =  new Intent(ConfirmBookings.this, LandingPage.class);
                startActivity(intent);

            }
        });
    }
}