package com.example.kienhao.timviec60s.jobseeker.fragment;

import android.graphics.Color;
import android.icu.util.Calendar;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.kienhao.timviec60s.R;
import com.example.kienhao.timviec60s.jobseeker.adapter.EventListAdapter;
import com.example.kienhao.timviec60s.model.EventDetail;
import com.github.sundeepk.compactcalendarview.CompactCalendarView;
import com.github.sundeepk.compactcalendarview.domain.Event;

import java.security.acl.Owner;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

import static android.content.ContentValues.TAG;

/**
 * Created by KienHao on 2/15/2018.
 */

public class InterviewScheduleFragment extends Fragment {

    TextView monthAndYear;
    CompactCalendarView compactCalendarView;
    SimpleDateFormat simpleDateFormat;
    FloatingActionButton addEvent;
    RecyclerView eventListRecyclerView;
    EventListAdapter adapter;
    RecyclerView.LayoutManager layoutManager;
    List<Event> arrEventDetail;

    void init(View view){
        eventListRecyclerView = (RecyclerView) view.findViewById(R.id.eventList);
        monthAndYear = (TextView) view.findViewById(R.id.monthAndYear);
        compactCalendarView = (CompactCalendarView) view.findViewById(R.id.compactcalendar_view);
        addEvent = (FloatingActionButton) view.findViewById(R.id.addEvent);
        simpleDateFormat = new SimpleDateFormat("MM/yyyy");
        monthAndYear.setText("Tháng " + simpleDateFormat.format(System.currentTimeMillis()));
    }

    public InterviewScheduleFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_interview_schedule, container, false);
        init(view);

        arrEventDetail = new ArrayList<>();
        arrEventDetail.add(new Event(Color.RED, 1518024949335L,  new EventDetail("", "Công ty Đỏ", "182 Lê Đại Hành")));
        arrEventDetail.add(new Event(Color.GREEN, 1518024949335L,  new EventDetail("", "Công ty Xanh lá", "183 Lê Đại Hành")));
        arrEventDetail.add(new Event(Color.BLUE, 1518024949335L,  new EventDetail("", "Công ty Xanh dương", "184 Lê Đại Hành")));
        arrEventDetail.add(new Event(Color.YELLOW, 1518024949335L,  new EventDetail("", "Công ty Vàng", "185 Lê Đại Hành")));

        addEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "Add Event Clicked", Toast.LENGTH_SHORT).show();
            }
        });

        // Set first day of week to Monday, defaults to Monday so calling setFirstDayOfWeek is not necessary
        // Use constants provided by Java Calendar class
        compactCalendarView.setLocale(TimeZone.getTimeZone("GMT+07:00"), Locale.getDefault());
        String[] dayColumnNames = new String[7];

        dayColumnNames[0]="TH 2";
        dayColumnNames[1]="TH 3";
        dayColumnNames[2]="TH 4";
        dayColumnNames[3]="TH 5";
        dayColumnNames[4]="TH 6";
        dayColumnNames[5]="TH 7";
        dayColumnNames[6]="CN";
        compactCalendarView.setDayColumnNames(dayColumnNames);
        compactCalendarView.addEvents(arrEventDetail);

        // define a listener to receive callbacks when certain events happen.
        compactCalendarView.setListener(new CompactCalendarView.CompactCalendarViewListener() {
            @Override
            public void onDayClick(Date dateClicked) {
                List<Event> events = compactCalendarView.getEvents(dateClicked);

                layoutManager = new LinearLayoutManager(getContext());
                eventListRecyclerView.setLayoutManager(layoutManager);
                adapter = new EventListAdapter(getContext(), events);
                eventListRecyclerView.setAdapter(adapter);
            }

            @Override
            public void onMonthScroll(Date firstDayOfNewMonth) {
                Log.d(TAG, "Month was scrolled to: " + firstDayOfNewMonth);
                monthAndYear.setText("Tháng " + simpleDateFormat.format(firstDayOfNewMonth));
            }
        });

        return view;
    }
}