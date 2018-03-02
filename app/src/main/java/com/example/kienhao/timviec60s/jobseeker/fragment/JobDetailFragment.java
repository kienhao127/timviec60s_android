package com.example.kienhao.timviec60s.jobseeker.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.kienhao.timviec60s.R;

/**
 * Created by KienHao on 2/21/2018.
 */

public class JobDetailFragment extends Fragment {

    public JobDetailFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_job_detail, container, false);

        return view;
    }
}
