package com.example.kienhao.timviec60s.jobseeker.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.kienhao.timviec60s.R;
import com.example.kienhao.timviec60s.jobseeker.adapter.JobListAdapter;
import com.example.kienhao.timviec60s.model.JobQuickView;

import java.util.ArrayList;

/**
 * Created by KienHao on 2/13/2018.
 */

public class JobListFragment extends Fragment {

    RecyclerView jobListRecyclerView;
    JobListAdapter adapter;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<JobQuickView> arrJobQuickView;

    public JobListFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_job_list, container, false);

        arrJobQuickView = new ArrayList<>();
        arrJobQuickView.add(new JobQuickView("", "Tên công ty 1", "Vị trị công việc 1", "Địa điểm 1", 1000, System.currentTimeMillis(), true));
        arrJobQuickView.add(new JobQuickView("", "Tên công ty 2", "Vị trị công việc 2", "Địa điểm 2", 2000, System.currentTimeMillis(), false));
        arrJobQuickView.add(new JobQuickView("", "Tên công ty 3", "Vị trị công việc 3", "Địa điểm 3", 3000, System.currentTimeMillis(), false));
        arrJobQuickView.add(new JobQuickView("", "Tên công ty 4", "Vị trị công việc 4", "Địa điểm 4", 4000, System.currentTimeMillis(), true));
        arrJobQuickView.add(new JobQuickView("", "Tên công ty 5", "Vị trị công việc 5", "Địa điểm 5", 5000, System.currentTimeMillis(), true));
        arrJobQuickView.add(new JobQuickView("", "Tên công ty 6", "Vị trị công việc 6", "Địa điểm 6", 6000, System.currentTimeMillis(), false));
        arrJobQuickView.add(new JobQuickView("", "Tên công ty 7", "Vị trị công việc 7", "Địa điểm 7", 7000, System.currentTimeMillis(), false));
        arrJobQuickView.add(new JobQuickView("", "Tên công ty 8", "Vị trị công việc 8", "Địa điểm 8", 8000, System.currentTimeMillis(), true));

        jobListRecyclerView = (RecyclerView) view.findViewById(R.id.jobList);
        layoutManager = new LinearLayoutManager(getContext());
        jobListRecyclerView.setLayoutManager(layoutManager);
        adapter = new JobListAdapter(getContext(), arrJobQuickView);
        jobListRecyclerView.setAdapter(adapter);
        return view;
    }
}
