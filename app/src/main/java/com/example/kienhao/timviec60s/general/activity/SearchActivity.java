package com.example.kienhao.timviec60s.general.activity;

import android.content.Intent;
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

import com.example.kienhao.timviec60s.R;
import com.example.kienhao.timviec60s.company.activity.CompanyHomeActivity;
import com.example.kienhao.timviec60s.general.adapter.LocationAdapter;
import com.example.kienhao.timviec60s.jobseeker.activity.SeekerHomeActivity;

import java.util.ArrayList;

public class SearchActivity extends AppCompatActivity {

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

    void init(){
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
                if (advancedSearch.getVisibility() == View.VISIBLE){
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
                if (b){
                    locationNameLayout.setVisibility(View.VISIBLE);
                } else {
                    locationNameLayout.setVisibility(View.GONE);
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
}
