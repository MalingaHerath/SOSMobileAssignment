package com.example.sosapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.google.android.gms.maps.GoogleMap;
import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private GoogleMap mMap;
    private LocationListener locationListener;
    private LocationManager locationManager;
    private double lng;
    private double lat;
    private final long MIN_TIME=1000;
    private final long MIN_DISTANCE=5;
    private Object provider;
    private Object extras;
    private Object view;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, PackageManager.PERMISSION_GRANTED);
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_COARSE_LOCATION}, PackageManager.PERMISSION_GRANTED);
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.SEND_SMS}, PackageManager.PERMISSION_GRANTED);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, PackageManager.PERMISSION_GRANTED);
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_COARSE_LOCATION}, PackageManager.PERMISSION_GRANTED);
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.SEND_SMS}, PackageManager.PERMISSION_GRANTED);
        

        locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);



        public void onMapReady(View view){

            locationListener = new LocationListener() {
                @Override
                public void onLocationChanged(Location location) {
                    try {
                        /*latLng = new LatLng(location.getLatitude(), location.getLongitude());*/
                        lat = location.getLatitude();
                        lng = location.getLongitude();
                    } catch (SecurityException e) {
                        e.printStackTrace();
                    }
                }

                @Override
                public void onStatusChanged(String provider, int status, Bundle extras) {
                }

                ;

                @Override
                public void onProviderEnabled(String provider) {
                }

                ;

                @Override
                public void onProviderDisabled(String provider) {
                }

                ;
            };

            public void sendMessage (View view){
                String phoneNum = "0768652634";
                String msg = "I’m Malinga Herath IM/2017/029 . Please Help Me. I’m in https://www.google.lk/maps/?q=" + lat + "," + lng;

                try {

                    SmsManager smsManager = SmsManager.getDefault();
                    smsManager.sendTextMessage(phoneNum, null, msg, null, null);

                    Toast.makeText(getApplicationContext(), "Succesfully Sent to " + phoneNum + "Location : " + msg, Toast.LENGTH_LONG).show();
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), "SMS Sending Failed" + e, Toast.LENGTH_LONG).show();
                }
            }
        }