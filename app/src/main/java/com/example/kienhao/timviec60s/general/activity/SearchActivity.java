package com.example.kienhao.timviec60s.general.activity;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.provider.Settings;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.kienhao.timviec60s.R;
import com.example.kienhao.timviec60s.company.activity.CompanyHomeActivity;
import com.example.kienhao.timviec60s.general.adapter.LocationAdapter;
import com.example.kienhao.timviec60s.jobseeker.activity.SeekerHomeActivity;

import org.w3c.dom.Text;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class SearchActivity extends AppCompatActivity {

    private static final int REQUEST_LOCATION = 1;
    EditText searchBox;
    EditText locationSearch;
    RelativeLayout locationNameLayout;
    RelativeLayout advancedSearch;
    TextView extendAdvancedSearch;
    RecyclerView locationNameRecyclerView;
    LocationAdapter locationAdapter;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<String> arrLocationName;
    Toolbar toolbar;
    TextView toolbarTitle;
    TextView myLocation;
    LocationManager locationManager;

    void init() {
        myLocation = (TextView) findViewById(R.id.myLocation);
        advancedSearch = (RelativeLayout) findViewById(R.id.advancedSearch);
        extendAdvancedSearch = (TextView) findViewById(R.id.extendAdvancedSearch);
        searchBox = (EditText) findViewById(R.id.searchBox);
        locationSearch = (EditText) findViewById(R.id.location);
        locationNameLayout = (RelativeLayout) findViewById(R.id.locationNameLayout);
        toolbarTitle = (TextView) findViewById(R.id.toolbarTitle);
        toolbarTitle.setText("Tìm kiếm");
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        init();

        extendAdvancedSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (advancedSearch.getVisibility() == View.VISIBLE) {
                    advancedSearch.setVisibility(View.GONE);
                    extendAdvancedSearch.setText("Nâng cao");
                } else {
                    advancedSearch.setVisibility(View.VISIBLE);
                    extendAdvancedSearch.setText("Tắt nâng cao");
                }
            }
        });

        locationSearch.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if (b) {
                    locationNameLayout.setVisibility(View.VISIBLE);
                } else {
                    locationNameLayout.setVisibility(View.GONE);
                }
            }
        });

        myLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
                if (!locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
                    buildAlertMessageNoGps();

                } else if (locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
                    if (ActivityCompat.checkSelfPermission(SearchActivity.this, Manifest.permission.ACCESS_FINE_LOCATION)
                            != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission
                            (SearchActivity.this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

                        ActivityCompat.requestPermissions(SearchActivity.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_LOCATION);

                    } else {
                        Location location = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);

                        if (location == null) {
                            location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
                            if (location == null){
                                location = locationManager.getLastKnownLocation(LocationManager.PASSIVE_PROVIDER);
                                if (location == null){
                                    Toast.makeText(getBaseContext(), "Unble to Trace your location", Toast.LENGTH_SHORT).show();
                                    return;
                                }
                            }
                        }
                        getCityName(location, new OnGeocoderFinishedListener() {
                            @Override
                            public void onFinished(List<Address> results) {
                                locationSearch.setText(results.get(0).getAdminArea());
                            }
                        });
                    }
                }
            }
        });


        arrLocationName = new ArrayList<>();
        arrLocationName.add("Hồ Chí Minh");
        arrLocationName.add("Thanh Hóa");
        arrLocationName.add("Hà Nội");
        arrLocationName.add("Đà Nẵng");
        arrLocationName.add("Huế");
        arrLocationName.add("Hội An");

        locationNameRecyclerView = (RecyclerView) findViewById(R.id.locationList);
        layoutManager = new LinearLayoutManager(getBaseContext());
        locationNameRecyclerView.setLayoutManager(layoutManager);
        locationAdapter = new LocationAdapter(getBaseContext(), arrLocationName);
        locationNameRecyclerView.setAdapter(locationAdapter);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == android.R.id.home) {
            if (true){
                Intent intent = new Intent(SearchActivity.this, SeekerHomeActivity.class);
                startActivity(intent);
                finish();
            } else {
                Intent intent = new Intent(SearchActivity.this, CompanyHomeActivity.class);
                startActivity(intent);
                finish();
            }
        }
        return super.onOptionsItemSelected(menuItem);
    }

    protected void buildAlertMessageNoGps() {

        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Please Turn ON your GPS Connection")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(final DialogInterface dialog, final int id) {
                        startActivity(new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS));
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(final DialogInterface dialog, final int id) {
                        dialog.cancel();
                    }
                });
        final AlertDialog alert = builder.create();
        alert.show();
    }

    @SuppressLint("StaticFieldLeak")
    public  void getCityName(final Location location, final OnGeocoderFinishedListener listener) {
        new AsyncTask<Void, Integer, List<Address>>() {
            @Override
            protected List<Address> doInBackground(Void... arg0) {
                Geocoder coder = new Geocoder(getBaseContext(), Locale.ENGLISH);
                List<Address> results = null;
                try {
                    results = coder.getFromLocation(location.getLatitude(), location.getLongitude(), 1);
                } catch (IOException e) {
                    // nothing
                }
                return results;
            }

            @Override
            protected void onPostExecute(List<Address> results) {
                if (results != null && listener != null) {
                    listener.onFinished(results);
                }
            }
        }.execute();
    }

    public abstract class OnGeocoderFinishedListener {
        public abstract void onFinished(List<Address> results);
    }
}
