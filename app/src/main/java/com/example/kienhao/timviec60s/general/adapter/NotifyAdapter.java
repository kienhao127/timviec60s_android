package com.example.kienhao.timviec60s.general.adapter;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.kienhao.timviec60s.R;
import com.example.kienhao.timviec60s.model.NotifyContent;

import java.util.ArrayList;

import static com.example.kienhao.timviec60s.utils.ElapsedTime.convertLongToDate;

/**
 * Created by KienHao on 2/14/2018.
 */

public class NotifyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context context;
    ArrayList<NotifyContent> arrNotifyContent;
    public NotifyAdapter(Context context, ArrayList<NotifyContent> arrNotifyContent){
        this.context = context;
        this.arrNotifyContent = arrNotifyContent;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new NotifyItemHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_notify_list,parent,false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        NotifyItemHolder notifyItemHolder = (NotifyItemHolder) holder;
        Glide.with(context)
                .load(arrNotifyContent.get(position).getAvatarURL())
                .apply(RequestOptions.circleCropTransform())
                .apply(RequestOptions.placeholderOf(R.drawable.avatar))
                .apply(RequestOptions.errorOf(R.drawable.avatar))
                .into(notifyItemHolder.avatarURL);

        SpannableStringBuilder builder = new SpannableStringBuilder();
        SpannableString userName = new SpannableString(arrNotifyContent.get(position).getUserName());
        userName.setSpan(new StyleSpan(Typeface.BOLD), 0, userName.length(), 0);
        builder.append(userName);
        builder.append(" " + arrNotifyContent.get(position).getNotifyContent());


        notifyItemHolder.content.setText(builder, TextView.BufferType.SPANNABLE);
        notifyItemHolder.notiTime.setText(convertLongToDate(arrNotifyContent.get(position).getNotifyTime()));
    }

    @Override
    public int getItemCount() {
        return arrNotifyContent.size();
    }

    public class NotifyItemHolder extends RecyclerView.ViewHolder {
        ImageView avatarURL;
        TextView content;
        TextView notiTime;

        public NotifyItemHolder(final View view){
            super(view);
            avatarURL = (ImageView) view.findViewById(R.id.notifyAvatar);
            content = (TextView) view.findViewById(R.id.notifyContent);
            notiTime = (TextView) view.findViewById(R.id.notifyTime);
        }
    }
}
