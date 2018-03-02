package com.example.kienhao.timviec60s.general.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.kienhao.timviec60s.R;
import com.example.kienhao.timviec60s.company.activity.CompanyHomeActivity;
import com.example.kienhao.timviec60s.general.adapter.NotifyAdapter;
import com.example.kienhao.timviec60s.jobseeker.activity.SeekerHomeActivity;
import com.example.kienhao.timviec60s.model.NotifyContent;

import org.w3c.dom.Text;

import java.util.ArrayList;

import static java.security.AccessController.getContext;

public class NotifyActivity extends AppCompatActivity {

    RecyclerView jobListRecyclerView;
    NotifyAdapter adapter;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<NotifyContent> arrNotifyContent;
    Toolbar toolbar;
    TextView toolbarTitle;
    int userID;
    int userType;

    void init(){
        toolbarTitle = (TextView) findViewById(R.id.toolbarTitle);
        toolbarTitle.setText("Thông báo");
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        userID = getIntent().getExtras().getInt("userID");
        userType = getIntent().getExtras().getInt("userType");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notify);
        init();

        arrNotifyContent = new ArrayList<>();
        arrNotifyContent.add(new NotifyContent("", "Nguyễn Văn A", "đã chấp nhận đơn xin việc của bạn", System.currentTimeMillis()));
        arrNotifyContent.add(new NotifyContent("", "Nguyễn Văn B", "đã từ chối đơn xin việc của bạn", System.currentTimeMillis()));
        arrNotifyContent.add(new NotifyContent("", "Nhắc nhở", "ngày mai bạn có cuộc phỏng vấn", System.currentTimeMillis()));

        jobListRecyclerView = (RecyclerView) findViewById(R.id.notifyList);
        layoutManager = new LinearLayoutManager(getBaseContext());
        jobListRecyclerView.setLayoutManager(layoutManager);
        adapter = new NotifyAdapter(getBaseContext(), arrNotifyContent);
        jobListRecyclerView.setAdapter(adapter);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == android.R.id.home) {
            onBackPressed();
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @Override
    public void onBackPressed() {

        int count = getFragmentManager().getBackStackEntryCount();

        if (count == 0) {
            super.onBackPressed();
            //additional code
        } else {
            getFragmentManager().popBackStack();
        }

    }
}
