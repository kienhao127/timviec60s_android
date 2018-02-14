package com.example.kienhao.timviec60s.general.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.kienhao.timviec60s.R;

import java.util.ArrayList;

/**
 * Created by KienHao on 2/14/2018.
 */

public class LocationAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context context;
    ArrayList<String> arrLocationName;

    public LocationAdapter(Context context, ArrayList<String> arrLocationName) {
        this.context = context;
        this.arrLocationName = arrLocationName;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new LocationItemHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_location_list, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        LocationItemHolder locationItemHolder = (LocationItemHolder) holder;
        locationItemHolder.locationName.setText(arrLocationName.get(position));
    }

    @Override
    public int getItemCount() {
        return arrLocationName.size();
    }

    public class LocationItemHolder extends RecyclerView.ViewHolder {
        TextView locationName;

        public LocationItemHolder(final View view) {
            super(view);
            locationName = (TextView) view.findViewById(R.id.locationName);
        }
    }
}
