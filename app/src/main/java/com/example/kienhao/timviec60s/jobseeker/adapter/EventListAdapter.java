package com.example.kienhao.timviec60s.jobseeker.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.kienhao.timviec60s.R;
import com.example.kienhao.timviec60s.model.EventDetail;
import com.github.sundeepk.compactcalendarview.domain.Event;

import java.util.ArrayList;
import java.util.List;

import static com.example.kienhao.timviec60s.utils.ElapsedTime.convertLongToDate;

/**
 * Created by KienHao on 2/19/2018.
 */

public class EventListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Context context;
    List<Event> arrEventDetail;
    public EventListAdapter(Context context, List<Event> arrEventDetail){
        this.context = context;
        this.arrEventDetail = arrEventDetail;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new EventItemHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_interview_event,parent,false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        EventItemHolder eventItemHolder = (EventItemHolder) holder;
        Glide.with(context)
                .load(((EventDetail) arrEventDetail.get(position).getData()).getCompanyLogoURL())
                .apply(RequestOptions.placeholderOf(R.drawable.company_logo))
                .apply(RequestOptions.errorOf(R.drawable.company_logo))
                .into(eventItemHolder.companyLogoURL);
        eventItemHolder.companyName.setText(((EventDetail) arrEventDetail.get(position).getData()).getCompanyName());
        eventItemHolder.interviewTime.setText(convertLongToDate(arrEventDetail.get(position).getTimeInMillis(), "hh:mm d/MM/yyyy"));
        eventItemHolder.interviewLocation.setText(((EventDetail) arrEventDetail.get(position).getData()).getInterviewLocation());
        eventItemHolder.eventColor.setBackgroundColor(arrEventDetail.get(position).getColor());
    }

    @Override
    public int getItemCount() {
        return arrEventDetail.size();
    }

    public class EventItemHolder extends RecyclerView.ViewHolder {
        ImageView companyLogoURL;
        TextView companyName;
        TextView interviewTime;
        TextView interviewLocation;
        View eventColor;

        public EventItemHolder(final View view){
            super(view);
            eventColor = (View) view.findViewById(R.id.eventColor);
            companyLogoURL = (ImageView) view.findViewById(R.id.companyLogo);
            companyName = (TextView) view.findViewById(R.id.companyName);
            interviewTime = (TextView) view.findViewById(R.id.interviewTime);
            interviewLocation = (TextView) view.findViewById(R.id.interviewLocation);
        }
    }
}