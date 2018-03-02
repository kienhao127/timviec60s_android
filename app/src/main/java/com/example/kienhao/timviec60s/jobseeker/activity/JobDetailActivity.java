package com.example.kienhao.timviec60s.jobseeker.activity;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.kienhao.timviec60s.R;
import com.example.kienhao.timviec60s.jobseeker.fragment.CompanyInfoFragment;
import com.example.kienhao.timviec60s.jobseeker.fragment.InterviewScheduleFragment;
import com.example.kienhao.timviec60s.jobseeker.fragment.JobDetailFragment;
import com.example.kienhao.timviec60s.jobseeker.fragment.JobListFragment;
import com.example.kienhao.timviec60s.jobseeker.fragment.MyJobFragment;
import com.example.kienhao.timviec60s.jobseeker.fragment.VideoCallFragment;

import java.util.ArrayList;
import java.util.List;

public class JobDetailActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private Toolbar toolbar;
    private TextView toolbarTitle;
    private FloatingActionButton actionButton;
    private RelativeLayout completeBottomView;

    void init(){
        actionButton = (FloatingActionButton) findViewById(R.id.actionButton);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        tabLayout = (TabLayout) findViewById(R.id.tabs);
        toolbarTitle = (TextView) findViewById(R.id.toolbarTitle);
        completeBottomView = (RelativeLayout) findViewById(R.id.completeBottomView);
        toolbarTitle.setText("Mô tả công việc");
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_detail);
        init();

        actionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (completeBottomView.getVisibility() == View.GONE){
                    completeBottomView.setVisibility(View.VISIBLE);
                } else {
                    completeBottomView.setVisibility(View.GONE);
                }
            }
        });

        setupViewPager(viewPager);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new JobDetailFragment(), "Công việc");
        adapter.addFragment(new CompanyInfoFragment(), "Công ty");
        viewPager.setAdapter(adapter);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
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
