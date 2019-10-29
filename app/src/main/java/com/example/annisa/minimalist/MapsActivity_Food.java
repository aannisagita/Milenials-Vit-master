package com.example.annisa.minimalist;

import android.app.ActionBar;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MapStyleOptions;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity_Food extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps_food);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar1);

        toolbar.setTitle("Healty food");

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

        LatLng uin = new LatLng(-5.380774, 105.304371);
        mMap.addMarker(new MarkerOptions().position(uin).title("UIN"));
        LatLng p1 = new LatLng(-5.384634, 105.295190);
        mMap.addMarker(new MarkerOptions().position(p1).title("Ayam Bakar"));
        LatLng p2 = new LatLng(-5.379841, 105.300876);
        mMap.addMarker(new MarkerOptions().position(p2).title("Ayam Geprek"));
        LatLng p3= new LatLng(-5.373640, 105.307760);
        mMap.addMarker(new MarkerOptions().position(p3).title("Warteg Giant"));
        LatLng p4 = new LatLng(-5.371819, 105.302509);
        mMap.addMarker(new MarkerOptions().position(p4).title("Es Pisang Hijau"));
        LatLng p5 = new LatLng(-5.371819, 105.302509);
        mMap.addMarker(new MarkerOptions().position(p5).title("Sensasi Sambal"));
        LatLng p6 = new LatLng(-5.384909, 105.294430);
        mMap.addMarker(new MarkerOptions().position(p6).title("Ayam Penyet"));
        LatLng p7 = new LatLng(-5.387407, 105.291294);
        mMap.addMarker(new MarkerOptions().position(p7).title("Bakso dan Mi Ayam"));
        LatLng p8 = new LatLng(-5.380536, 105.287803);
        mMap.addMarker(new MarkerOptions().position(p8).title("Ketoprak"));
        LatLng p9 = new LatLng(-5.380175, 105.291962);
        mMap.addMarker(new MarkerOptions().position(p9).title("Mi Aceh"));
        LatLng p10 = new LatLng(-5.378684, 105.293872);
        mMap.addMarker(new MarkerOptions().position(p10).title("Nasi Goreng"));


        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng itera = new LatLng(-5.357013, 105.314735);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(p10,14));
        mMap.addMarker(new MarkerOptions().position(itera).title("ITERA"));
        //mMap.moveCamera(CameraUpdateFactory.newLatLng(itera));

        setMapStyle();
    }

    private void setMapStyle(){
        boolean result = mMap.setMapStyle(MapStyleOptions.loadRawResourceStyle(this, R.raw.maps_style));
        if(!result){
            Log.e("MAP","Error set maps style");
        }
    }
}

