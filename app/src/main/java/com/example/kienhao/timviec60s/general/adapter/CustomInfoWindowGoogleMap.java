package com.example.kienhao.timviec60s.general.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.kienhao.timviec60s.R;
import com.example.kienhao.timviec60s.model.JobQuickView;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;

import static com.example.kienhao.timviec60s.utils.ElapsedTime.convertLongToDate;

/**
 * Created by KienHao on 3/1/2018.
 */

public class CustomInfoWindowGoogleMap implements GoogleMap.InfoWindowAdapter {

    private Context context;

    public CustomInfoWindowGoogleMap(Context ctx){
        context = ctx;
    }

    @Override
    public View getInfoWindow(Marker marker) {
        return null;
    }

    @Override
    public View getInfoContents(Marker marker) {
        View view = ((Activity)context).getLayoutInflater()
                .inflate(R.layout.item_job_list, null);

        ImageView companyLogo = (ImageView) view.findViewById(R.id.companyLogo);
        TextView  companyName = (TextView) view.findViewById(R.id.companyName);
        TextView jobPosition = (TextView) view.findViewById(R.id.jobPosition);
        TextView location = (TextView) view.findViewById(R.id.location);
        TextView salaryAmount = (TextView) view.findViewById(R.id.salaryAmount);
        ImageView saveJob = (ImageView) view.findViewById(R.id.saveJob);
        TextView deadline = (TextView) view.findViewById(R.id.deadline);

        JobQuickView jobQuickView = (JobQuickView) marker.getTag();

        Glide.with(context)
                .load(jobQuickView.getCompanyLogoURL())
                .apply(RequestOptions.placeholderOf(R.drawable.company_logo))
                .apply(RequestOptions.errorOf(R.drawable.company_logo))
                .into(companyLogo);
        companyName.setText(jobQuickView.getCompanyName());
        jobPosition.setText(jobQuickView.getJobPosition());
        location.setText(jobQuickView.getLocation());
        salaryAmount.setText(String.valueOf(jobQuickView.getSalaryAmount()));
        deadline.setText(convertLongToDate(jobQuickView.getDeadline(), "d/MM/yyyy"));
        if (jobQuickView.isSaved()){
            saveJob.setImageResource(R.drawable.saved_job);
        } else {
            saveJob.setImageResource(R.drawable.save_job);
        }

        return view;
    }
}
