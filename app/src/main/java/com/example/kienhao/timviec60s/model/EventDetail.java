package com.example.kienhao.timviec60s.model;

import com.github.sundeepk.compactcalendarview.domain.Event;

/**
 * Created by KienHao on 2/19/2018.
 */

public class EventDetail {
    String companyLogoURL;
    String companyName;
    String interviewLocation;

    public EventDetail(String companyLogoURL, String companyName, String interviewLocation) {
        this.companyLogoURL = companyLogoURL;
        this.companyName = companyName;
        this.interviewLocation = interviewLocation;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getInterviewLocation() {
        return interviewLocation;
    }

    public void setInterviewLocation(String interviewLocation) {
        this.interviewLocation = interviewLocation;
    }

    public String getCompanyLogoURL() {
        return companyLogoURL;
    }

    public void setCompanyLogoURL(String companyLogoURL) {
        this.companyLogoURL = companyLogoURL;
    }
}
