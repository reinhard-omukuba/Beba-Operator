package com.beba.bebaoperator;

import static android.content.ContentValues.TAG;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

public class NyumbaniFragment extends Fragment {



    public NyumbaniFragment() {
        // Required empty public constructor
    }


    private GoogleMap mMap;

    // private ActivityMapsBinding binding;

    private LocationManager locationManager;

    LocationListener locationListener;

    private static final int LOCATION_PERMISSION_REQUEST_CODE = 1;

    private static final float DEFAULT_ZOOM = 15f;
    private Marker mMarker;


    double latitude;
    double longitude;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_nyumbani, container, false);


        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("Nearby Matatus");




        // Check if the app has permission to access the user's location
        if (ContextCompat.checkSelfPermission(getActivity(), android.Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {
            // Permission is already granted, proceed with your code
            // ...

            Toast.makeText(getActivity(), "Permision granted " , Toast.LENGTH_SHORT).show();

            // Permission is already granted, proceed with getting the location
            LocationManager locationManager = (LocationManager) getActivity().getSystemService(Context.LOCATION_SERVICE);
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, new LocationListener() {
                @Override
                public void onLocationChanged(Location location) {
                    // Handle location updates
                    latitude = location.getLatitude();
                    longitude = location.getLongitude();
                    // ...

                    LatLng currentLocation = new LatLng(latitude, longitude);


                    //        run the function below
                    Timer timer = new Timer();
                    timer.scheduleAtFixedRate(new TimerTask() {
                        @Override
                        public void run() {
                            // code to update location to Firestore every 1 minute
                            updateLocationToFirestore();
                        }
                    }, 0, 60000); // run every 1 minute (60,000 milliseconds)



                }

                @Override
                public void onProviderDisabled(String provider) {
                    // Handle provider disabled
                }

                @Override
                public void onProviderEnabled(String provider) {
                    // Handle provider enabled
                }

                @Override
                public void onStatusChanged(String provider, int status, Bundle extras) {
                    // Handle status changes
                }
            });

        } else {
            // Permission is not granted, request it
            ActivityCompat.requestPermissions(getActivity(),
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                    LOCATION_PERMISSION_REQUEST_CODE);
        }

        return view;
    }


    public void updateLocationToFirestore(){
        String userId = FirebaseAuth.getInstance().getCurrentUser().getUid();


        FirebaseFirestore db = FirebaseFirestore.getInstance();
        DocumentReference userRef = db.collection("users").document(userId);

        Map<String, Object> updates = new HashMap<>();
        updates.put("latitude", latitude);
        updates.put("longitude", longitude);

        userRef.update(updates)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Log.d(TAG, "DocumentSnapshot successfully updated!");
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w(TAG, "Error updating document", e);
                    }
                });

    }
}