package com.tutorials.gmaps.app.googlemapstutorial;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.android.gms.maps.SupportMapFragment;

public class CheckMyLocationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_my_location);
      SupportMapFragment supportMapFragment=  (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.mapPlaceholder);
   // supportMapFragment.
    }
}
