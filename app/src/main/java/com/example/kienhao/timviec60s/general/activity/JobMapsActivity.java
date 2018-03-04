package com.example.kienhao.timviec60s.general.activity;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.example.kienhao.timviec60s.R;
import com.example.kienhao.timviec60s.general.adapter.CustomInfoWindowGoogleMap;
import com.example.kienhao.timviec60s.model.JobQuickView;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

public class JobMapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ArrayList<JobQuickView> arrJobQuickView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        arrJobQuickView = new ArrayList<>();
        arrJobQuickView.add(new JobQuickView("", "Công ty VNG", "Vị trị công việc 1", "Địa điểm 1", 1000, System.currentTimeMillis(), true, 10.763938d, 106.6562652d));
        arrJobQuickView.add(new JobQuickView("", "Lotte mart Phú Thọ", "Vị trị công việc 2", "Địa điểm 2", 2000, System.currentTimeMillis(), false, 10.7627871d,106.6572009d));
        arrJobQuickView.add(new JobQuickView("", "Nhà sách Phương Nam", "Vị trị công việc 3", "Địa điểm 3", 3000, System.currentTimeMillis(), false, 10.763356d,106.658822d));
        arrJobQuickView.add(new JobQuickView("", "Ngân hàng Đông Á", "Vị trị công việc 4", "Địa điểm 4", 4000, System.currentTimeMillis(), true, 10.7641458d,106.659743d));
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

        CustomInfoWindowGoogleMap customInfoWindow = new CustomInfoWindowGoogleMap(this);
        mMap.setInfoWindowAdapter(customInfoWindow);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(new LatLng(arrJobQuickView.get(0).getLatitude(), arrJobQuickView.get(0).getLongitude())));
        mMap.moveCamera(CameraUpdateFactory.zoomTo(15));
        for (int i = 0; i < arrJobQuickView.size(); i++){
            Marker m = mMap.addMarker(new MarkerOptions()
                    .position(new LatLng(arrJobQuickView.get(i).getLatitude(), arrJobQuickView.get(i).getLongitude())));
            m.setTag(arrJobQuickView.get(i));
            m.setZIndex(22);
        }
    }
}
