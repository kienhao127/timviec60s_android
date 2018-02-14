package com.example.kienhao.timviec60s.jobseeker.activity;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.ImageView;

import com.example.kienhao.timviec60s.R;
import com.example.kienhao.timviec60s.general.activity.NotifyActivity;
import com.example.kienhao.timviec60s.general.activity.SearchActivity;
import com.example.kienhao.timviec60s.jobseeker.fragment.JobListFragment;
import com.example.kienhao.timviec60s.jobseeker.fragment.MyJobFragment;
import com.example.kienhao.timviec60s.jobseeker.fragment.VideoCallFragment;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class SeekerHomeActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ImageView notify;
    private TextView searchBox;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seeker_home);

        viewPager = (ViewPager) findViewById(R.id.seekerHomeViewpager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.seekerHomeTabs);
        tabLayout.setupWithViewPager(viewPager);

        notify = (ImageView) findViewById(R.id.notify);
        notify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent notifyIntent = new Intent(SeekerHomeActivity.this, NotifyActivity.class);
                Bundle mBundle = new Bundle();
                mBundle.putInt("userID", 0);
                mBundle.putInt("userType", 0);
                notifyIntent.putExtras(mBundle);
                startActivity(notifyIntent);
            }
        });

        searchBox = (TextView) findViewById(R.id.searchBox);
        searchBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent searchIntent = new Intent(SeekerHomeActivity.this, SearchActivity.class);
                startActivity(searchIntent);
            }
        });
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new JobListFragment(), "Danh sách công việc");
        adapter.addFragment(new MyJobFragment(), "Công việc của tôi");
        adapter.addFragment(new VideoCallFragment(), "Gọi video");
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
}
