package com.example.kienhao.timviec60s.model;

/**
 * Created by KienHao on 2/13/2018.
 */

public class VideoCall {
    String avatarURL;
    String fullname;
    long callTime;
    long totalCallTime;
    int callType;

    public VideoCall(){

    }

    public VideoCall(String avatarURL, String fullname, long callTime, long totalCallTime, int callType) {
        this.avatarURL = avatarURL;
        this.fullname = fullname;
        this.callTime = callTime;
        this.totalCallTime = totalCallTime;
        this.callType = callType;
    }

    public String getAvatarURL() {
        return avatarURL;
    }

    public void setAvatarURL(String avatarURL) {
        this.avatarURL = avatarURL;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public long getCallTime() {
        return callTime;
    }

    public void setCallTime(long callTime) {
        this.callTime = callTime;
    }

    public long getTotalCallTime() {
        return totalCallTime;
    }

    public void setTotalCallTime(long totalCallTime) {
        this.totalCallTime = totalCallTime;
    }

    public int getCallType() {
        return callType;
    }

    public void setCallType(int callType) {
        this.callType = callType;
    }
}
