package com.example.annisa.minimalist;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MapStyleOptions;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity_Workout extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps_workout);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar2);

        toolbar.setTitle("Lets Workout");

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng p1 = new LatLng(-5.383791, 105.289648);
        mMap.addMarker(new MarkerOptions().position(p1).title("Lapangan"));
        LatLng p2 = new LatLng(-5.367740, 105.301100);
        mMap.addMarker(new MarkerOptions().position(p2).title("Gym"));
        LatLng p3= new LatLng(-5.377172, 105.305563);
        mMap.addMarker(new MarkerOptions().position(p3).title("Gym"));
        LatLng p4 = new LatLng(-5.381946, 105.308653);
        mMap.addMarker(new MarkerOptions().position(p4).title("Lapangan Futsal"));
        LatLng p5 = new LatLng(-5.379261, 105.309179);
        mMap.addMarker(new MarkerOptions().position(p5).title("Lapangan Golf"));
        LatLng p6 = new LatLng(-5.346967, 105.299627);
        mMap.addMarker(new MarkerOptions().position(p6).title("Lapangan Futsal"));
        LatLng p7 = new LatLng(-5.353237, 105.285293);
        mMap.addMarker(new MarkerOptions().position(p7).title("GOR"));
        LatLng p8 = new LatLng(-5.354101, 105.285201);
        mMap.addMarker(new MarkerOptions().position(p8).title("Lapangan"));
        LatLng p9 = new LatLng(-5.374218, 105.300486);
        mMap.addMarker(new MarkerOptions().position(p9).title("Kolam Renang"));
        LatLng p10 = new LatLng(-5.362211, 105.291502);
        mMap.addMarker(new MarkerOptions().position(p10).title("Kolam Renang"));



        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng itera = new LatLng(-5.357013, 105.314735);
        mMap.addMarker(new MarkerOptions().position(itera).title("ITERA"));
        //mMap.moveCamera(CameraUpdateFactory.newLatLng(itera));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(p2,14));

        setMapStyle();
    }

    private void setMapStyle(){
        boolean result = mMap.setMapStyle(MapStyleOptions.loadRawResourceStyle(this, R.raw.maps_style));
        if(!result){
            Log.e("MAP","Error set maps style");
        }
    }
}
