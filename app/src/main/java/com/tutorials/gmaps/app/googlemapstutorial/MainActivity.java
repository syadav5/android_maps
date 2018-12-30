package com.tutorials.gmaps.app.googlemapstutorial;

import android.app.Dialog;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;

public class MainActivity extends FragmentActivity {

    GoogleMap mMap;
    MapView mMapView;

    String mapLatLng="45.600994, -75.463005";
    String addressToSearch="2098 Esprit+Dr,Orléans";
    public static final int ERROR_DIALOG=10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //getActionBar()!=null?getActionBar().setCustomView(R.layout.action_view):null;
        if(servicesOK()){
            Toast.makeText(this, "READYY TO MAP...", Toast.LENGTH_SHORT).show();
/*
            setContentView(R.layout.activity_maps);
*/
            setContentView(R.layout.activity_main);
         //   mMapView= findViewById(R.id.mMapView);
           // mMapView.onCreate(savedInstanceState);
          }
        else{
            setContentView(R.layout.activity_main);
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return true;
    }

    public void goToMyLocations(View view){
        Utilities.navigateTo(this,CheckMyLocationActivity.class);

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.myLocation:
                Utilities.navigateTo(this,CheckMyLocationActivity.class);
                return true;
        }
        return super.onOptionsItemSelected(item);
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
       // mMapView.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
      //  mMapView.onResume();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
       // mMapView.onLowMemory();
    }

    @Override
    protected void onStop() {
        super.onStop();
       // mMapView.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
       // mMapView.onDestroy();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
       // mMapView.onSaveInstanceState(outState);
    }
}
