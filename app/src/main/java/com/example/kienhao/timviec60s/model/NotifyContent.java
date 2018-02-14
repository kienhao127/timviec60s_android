package com.example.kienhao.timviec60s.model;

/**
 * Created by KienHao on 2/14/2018.
 */

public class NotifyContent {
    String avatarURL;
    String userName;
    String notifyContent;
    long notifyTime;

    public NotifyContent() {
    }

    public NotifyContent(String avatarURL, String userName, String notifyContent, long notifyTime) {
        this.avatarURL = avatarURL;
        this.userName = userName;
        this.notifyContent = notifyContent;
        this.notifyTime = notifyTime;
    }

    public String getAvatarURL() {
        return avatarURL;
    }

    public void setAvatarURL(String avatarURL) {
        this.avatarURL = avatarURL;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getNotifyContent() {
        return notifyContent;
    }

    public void setNotifyContent(String notifyContent) {
        this.notifyContent = notifyContent;
    }

    public long getNotifyTime() {
        return notifyTime;
    }

    public void setNotifyTime(long notifyTime) {
        this.notifyTime = notifyTime;
    }
}
