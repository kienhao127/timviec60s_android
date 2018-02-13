package com.example.kienhao.timviec60s.jobseeker.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.kienhao.timviec60s.R;
import com.example.kienhao.timviec60s.model.JobDetail;

import java.util.ArrayList;

import static com.example.kienhao.timviec60s.utils.ElapsedTime.convertLongToDate;

/**
 * Created by KienHao on 2/13/2018.
 */

public class JobListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Context context;
    ArrayList<JobDetail> arrJobDetail;
    public JobListAdapter(Context context, ArrayList<JobDetail> arrJobDetail){
        this.context = context;
        this.arrJobDetail = arrJobDetail;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new JobItemHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_job_list,parent,false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        JobItemHolder jobItemHolder = (JobItemHolder) holder;
        Glide.with(context)
                .load(arrJobDetail.get(position).getCompanyLogoURL())
                .apply(RequestOptions.placeholderOf(R.drawable.company_logo))
                .apply(RequestOptions.errorOf(R.drawable.company_logo))
                .into(jobItemHolder.companyLogo);
        jobItemHolder.companyName.setText(arrJobDetail.get(position).getCompanyName());
        jobItemHolder.jobPosition.setText(arrJobDetail.get(position).getJobPosition());
        jobItemHolder.location.setText(arrJobDetail.get(position).getLocation());
        jobItemHolder.salaryAmount.setText(String.valueOf(arrJobDetail.get(position).getSalaryAmount()));
        jobItemHolder.deadline.setText(convertLongToDate(arrJobDetail.get(position).getDeadline()));
        if (arrJobDetail.get(position).isSaved()){
            jobItemHolder.saveJob.setImageResource(R.drawable.saved_job);
        } else {
            jobItemHolder.saveJob.setImageResource(R.drawable.save_job);
        }
    }

    @Override
    public int getItemCount() {
        return arrJobDetail.size();
    }

    public class JobItemHolder extends RecyclerView.ViewHolder {
        ImageView companyLogo;
        TextView companyName;
        TextView jobPosition;
        TextView location;
        TextView salaryAmount;
        ImageView saveJob;
        TextView deadline;

        public JobItemHolder(final View view){
            super(view);
            companyLogo = (ImageView) view.findViewById(R.id.companyLogo);
            companyName = (TextView) view.findViewById(R.id.companyName);
            jobPosition = (TextView) view.findViewById(R.id.jobPosition);
            location = (TextView) view.findViewById(R.id.location);
            salaryAmount = (TextView) view.findViewById(R.id.salaryAmount);
            saveJob = (ImageView) view.findViewById(R.id.saveJob);
            deadline = (TextView) view.findViewById(R.id.deadline);

            saveJob.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, "Saved", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}