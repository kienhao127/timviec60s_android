package com.example.kienhao.timviec60s.jobseeker.adapter;

import android.content.Context;
import android.graphics.Color;
import android.provider.ContactsContract;
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
import com.example.kienhao.timviec60s.model.VideoCall;

import java.util.ArrayList;

import static com.example.kienhao.timviec60s.utils.ElapsedTime.convertLongToDate;
import static com.example.kienhao.timviec60s.utils.ElapsedTime.parseMStoTimer;

/**
 * Created by KienHao on 2/13/2018.
 */

public class VideoCallListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Context context;
    ArrayList<VideoCall> arrVideoCall;
    static final int OUT_GOING_CALL = 1;
    static final int IN_COMING_CALL = 2;
    static final int MISS_CALL = 3;
    public VideoCallListAdapter(Context context, ArrayList<VideoCall> arrVideoCall){
        this.context = context;
        this.arrVideoCall = arrVideoCall;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new VideoCallListAdapter.VideoCallItemHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_videocall_list,parent,false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        VideoCallItemHolder videoCallItemHolder = (VideoCallItemHolder) holder;
        Glide.with(context)
                .load(arrVideoCall.get(position).getAvatarURL())
                .apply(RequestOptions.placeholderOf(R.drawable.avatar))
                .apply(RequestOptions.errorOf(R.drawable.avatar))
                .into(videoCallItemHolder.avatar);
        videoCallItemHolder.fullname.setText(arrVideoCall.get(position).getFullname());
        videoCallItemHolder.callTime.setText(convertLongToDate(arrVideoCall.get(position).getCallTime(), "d/MM/yyyy"));
        videoCallItemHolder.totalCallTime.setText(parseMStoTimer(arrVideoCall.get(position).getTotalCallTime()));

        switch (arrVideoCall.get(position).getCallType()){
            case OUT_GOING_CALL:
                videoCallItemHolder.callType.setImageResource(R.drawable.outgoing_call);
                break;
            case IN_COMING_CALL:
                videoCallItemHolder.callType.setImageResource(R.drawable.incoming_call);
                break;
            case MISS_CALL:
                videoCallItemHolder.callType.setImageResource(R.drawable.miss_call);
                videoCallItemHolder.fullname.setTextColor(Color.RED);
                break;
        }
        if (arrVideoCall.get(position).getCallType() == 3){
            videoCallItemHolder.fullname.setTextColor(Color.RED);
        }
    }

    @Override
    public int getItemCount() {
        return arrVideoCall.size();
    }

    public class VideoCallItemHolder extends RecyclerView.ViewHolder {
        ImageView avatar;
        TextView fullname;
        TextView callTime;
        TextView totalCallTime;
        ImageView callType;

        public VideoCallItemHolder(final View view){
            super(view);
            avatar = (ImageView) view.findViewById(R.id.avatar);
            fullname = (TextView) view.findViewById(R.id.fullname);
            callTime = (TextView) view.findViewById(R.id.callTime);
            totalCallTime = (TextView) view.findViewById(R.id.totalCallTime);
            callType = (ImageView) view.findViewById(R.id.callType);
        }
    }
}
