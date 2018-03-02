package com.example.kienhao.timviec60s.jobseeker.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.kienhao.timviec60s.R;
import com.example.kienhao.timviec60s.general.activity.JobMapsActivity;

/**
 * Created by KienHao on 2/21/2018.
 */

public class CompanyInfoFragment extends Fragment {

    private TextView companyAddress;

    public CompanyInfoFragment() {
        // Required empty public constructor
    }

    void init(View view){
        companyAddress = (TextView) view.findViewById(R.id.companyAddress);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_company_info, container, false);
        init(view);

        companyAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mapInten = new Intent(getActivity(), JobMapsActivity.class);
                startActivity(mapInten);
            }
        });

        return view;
    }
}
