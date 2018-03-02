package com.example.kienhao.timviec60s.jobseeker.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.kienhao.timviec60s.R;
import com.example.kienhao.timviec60s.jobseeker.activity.JobDetailActivity;
import com.example.kienhao.timviec60s.jobseeker.adapter.JobListAdapter;
import com.example.kienhao.timviec60s.model.JobQuickView;

import java.util.ArrayList;

/**
 * Created by KienHao on 2/13/2018.
 */

public class JobListFragment extends Fragment implements JobListAdapter.OnItemClickListener {

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
        arrJobQuickView.add(new JobQuickView("", "Công ty VNG", "Vị trị công việc 1", "Địa điểm 1", 1000, System.currentTimeMillis(), true, 10.7635963, 106.6555787));
        arrJobQuickView.add(new JobQuickView("", "Lotte mart Phú Thọ", "Vị trị công việc 2", "Địa điểm 2", 2000, System.currentTimeMillis(), false, 10.7624213,106.6566533));
        arrJobQuickView.add(new JobQuickView("", "Nhà sách Phương Nam", "Vị trị công việc 3", "Địa điểm 3", 3000, System.currentTimeMillis(), false, 10.7626708,106.6573942));
        arrJobQuickView.add(new JobQuickView("", "Ngân hàng Đông Á", "Vị trị công việc 4", "Địa điểm 4", 4000, System.currentTimeMillis(), true, 10.7636823,106.6594847));

        jobListRecyclerView = (RecyclerView) view.findViewById(R.id.jobList);
        layoutManager = new LinearLayoutManager(getContext());
        jobListRecyclerView.setLayoutManager(layoutManager);
        adapter = new JobListAdapter(getContext(), arrJobQuickView);
        adapter.SetOnItemClickListener(this);
        jobListRecyclerView.setAdapter(adapter);
        return view;
    }

    @Override
    public void onItemClick(View view, int position) {
        Intent jobDetailIntent = new Intent(getActivity(), JobDetailActivity.class);
        startActivity(jobDetailIntent);
    }
}
