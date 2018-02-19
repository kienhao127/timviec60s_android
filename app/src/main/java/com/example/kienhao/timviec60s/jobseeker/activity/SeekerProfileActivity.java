package com.example.kienhao.timviec60s.jobseeker.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.kienhao.timviec60s.R;
import com.example.kienhao.timviec60s.company.activity.CompanyHomeActivity;
import com.example.kienhao.timviec60s.general.activity.SearchActivity;

public class SeekerProfileActivity extends AppCompatActivity {

    Toolbar toolbar;
    TextView toolbarTitle;

    void init(){
        toolbarTitle = (TextView) findViewById(R.id.toolbarTitle);
        toolbarTitle.setText("Trang cá nhân");
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seeker_profile);
        init();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == android.R.id.home) {
            if (true){
                Intent intent = new Intent(SeekerProfileActivity.this, SeekerHomeActivity.class);
                startActivity(intent);
                finish();
            } else {
                Intent intent = new Intent(SeekerProfileActivity.this, CompanyHomeActivity.class);
                startActivity(intent);
                finish();
            }
        }
        return super.onOptionsItemSelected(menuItem);
    }
}
