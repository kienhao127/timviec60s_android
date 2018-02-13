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
import com.example.kienhao.timviec60s.model.JobDetail;

import java.util.ArrayList;

/**
 * Created by KienHao on 2/13/2018.
 */

public class SavedJobFragment extends Fragment {

    RecyclerView savedJobListtRecyclerView;
    JobListAdapter adapter;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<JobDetail> arrJobDetail;

    public SavedJobFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_saved_job, container, false);

        arrJobDetail = new ArrayList<>();
        arrJobDetail.add(new JobDetail("", "Tên công ty 1", "Vị trị công việc 1", "Địa điểm 1", 1000, System.currentTimeMillis(), true));
        arrJobDetail.add(new JobDetail("", "Tên công ty 2", "Vị trị công việc 2", "Địa điểm 2", 2000, System.currentTimeMillis(), false));
        arrJobDetail.add(new JobDetail("", "Tên công ty 3", "Vị trị công việc 3", "Địa điểm 3", 3000, System.currentTimeMillis(), false));
        arrJobDetail.add(new JobDetail("", "Tên công ty 4", "Vị trị công việc 4", "Địa điểm 4", 4000, System.currentTimeMillis(), true));
        arrJobDetail.add(new JobDetail("", "Tên công ty 5", "Vị trị công việc 5", "Địa điểm 5", 5000, System.currentTimeMillis(), true));
        arrJobDetail.add(new JobDetail("", "Tên công ty 6", "Vị trị công việc 6", "Địa điểm 6", 6000, System.currentTimeMillis(), false));
        arrJobDetail.add(new JobDetail("", "Tên công ty 7", "Vị trị công việc 7", "Địa điểm 7", 7000, System.currentTimeMillis(), false));
        arrJobDetail.add(new JobDetail("", "Tên công ty 8", "Vị trị công việc 8", "Địa điểm 8", 8000, System.currentTimeMillis(), true));

        savedJobListtRecyclerView = (RecyclerView) view.findViewById(R.id.savedJobList);
        layoutManager = new LinearLayoutManager(getContext());
        savedJobListtRecyclerView.setLayoutManager(layoutManager);
        adapter = new JobListAdapter(getContext(), arrJobDetail);
        savedJobListtRecyclerView.setAdapter(adapter);
        return view;
    }
}
