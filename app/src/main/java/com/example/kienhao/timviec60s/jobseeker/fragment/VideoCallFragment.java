package com.example.kienhao.timviec60s.jobseeker.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.kienhao.timviec60s.R;
import com.example.kienhao.timviec60s.jobseeker.adapter.VideoCallListAdapter;
import com.example.kienhao.timviec60s.model.VideoCall;

import java.util.ArrayList;

/**
 * Created by KienHao on 2/13/2018.
 */

public class VideoCallFragment extends Fragment {

    RecyclerView videocallListRecyclerView;
    VideoCallListAdapter adapter;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<VideoCall> arrVideocall;

    public VideoCallFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_videocall, container, false);

        arrVideocall = new ArrayList<>();
        arrVideocall.add(new VideoCall("", "Nguyễn Văn A", System.currentTimeMillis(), 200*1000, 1));
        arrVideocall.add(new VideoCall("", "Nguyễn Văn B", System.currentTimeMillis(), 300*1000, 2));
        arrVideocall.add(new VideoCall("", "Nguyễn Văn C", System.currentTimeMillis(), 400*1000, 3));
        arrVideocall.add(new VideoCall("", "Nguyễn Văn D", System.currentTimeMillis(), 500*1000, 1));
        arrVideocall.add(new VideoCall("", "Nguyễn Văn E", System.currentTimeMillis(), 600*1000, 2));
        arrVideocall.add(new VideoCall("", "Nguyễn Văn F", System.currentTimeMillis(), 700*1000, 3));
        arrVideocall.add(new VideoCall("", "Nguyễn Văn G", System.currentTimeMillis(), 800*1000, 1));
        arrVideocall.add(new VideoCall("", "Nguyễn Văn H", System.currentTimeMillis(), 900*1000, 2));

        videocallListRecyclerView = (RecyclerView) view.findViewById(R.id.videocallList);
        layoutManager = new LinearLayoutManager(getContext());
        videocallListRecyclerView.setLayoutManager(layoutManager);
        adapter = new VideoCallListAdapter(getContext(), arrVideocall);
        videocallListRecyclerView.setAdapter(adapter);
        return view;
    }
}
