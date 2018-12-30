package com.tutorials.gmaps.app.googlemapstutorial;

import android.app.Dialog;
import android.os.PersistableBundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;

public class MainActivity extends FragmentActivity {

    GoogleMap mMap;
    MapView mMapView;

    public static final int ERROR_DIALOG=10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(servicesOK()){
            Toast.makeText(this, "READYY TO MAP...", Toast.LENGTH_SHORT).show();
/*
            setContentView(R.layout.activity_maps);
*/
            setContentView(R.layout.maps_view_layout);
            mMapView= findViewById(R.id.mMapView);
            mMapView.onCreate(savedInstanceState);
          }
        else{
            setContentView(R.layout.activity_main);
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean servicesOK()
    {
        int isAvailable = GooglePlayServicesUtil.isGooglePlayServicesAvailable(this);
    switch (isAvailable){
      case  ConnectionResult.SUCCESS:
        return true;
        default:
            if(GooglePlayServicesUtil.isUserRecoverableError(isAvailable)){
                Dialog dialog = GooglePlayServicesUtil.getErrorDialog(isAvailable,this,ERROR_DIALOG);
                dialog.show();
            }
            else{
                Toast.makeText(this, "UNKNOWN ERROR WHILE CONNECTING TO SERVICES", Toast.LENGTH_SHORT).show();
            }
            return false;
    }

    }

    @Override
    protected void onPause() {
        super.onPause();
        mMapView.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mMapView.onResume();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mMapView.onLowMemory();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mMapView.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mMapView.onDestroy();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mMapView.onSaveInstanceState(outState);
    }
}
