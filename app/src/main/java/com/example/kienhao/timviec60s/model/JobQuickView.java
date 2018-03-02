package com.example.kienhao.timviec60s.model;

/**
 * Created by KienHao on 2/13/2018.
 */

public class JobQuickView {
    String companyLogoURL;
    String companyName;
    String jobPosition;
    String location;
    int salaryAmount;
    long deadline;
    boolean isSaved;
    double latitude;
    double longitude;

    public JobQuickView(){

    }

    public JobQuickView(String companyLogoURL, String companyName, String jobPosition, String location, int salaryAmount, long deadline, boolean isSaved, double latitude, double longitude) {
        this.companyLogoURL = companyLogoURL;
        this.companyName = companyName;
        this.jobPosition = jobPosition;
        this.location = location;
        this.salaryAmount = salaryAmount;
        this.deadline = deadline;
        this.isSaved = isSaved;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getCompanyLogoURL() {
        return companyLogoURL;
    }

    public void setCompanyLogoURL(String companyLogoURL) {
        this.companyLogoURL = companyLogoURL;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getJobPosition() {
        return jobPosition;
    }

    public void setJobPosition(String jobPosition) {
        this.jobPosition = jobPosition;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getSalaryAmount() {
        return salaryAmount;
    }

    public void setSalaryAmount(int salaryAmount) {
        this.salaryAmount = salaryAmount;
    }

    public long getDeadline() {
        return deadline;
    }

    public void setDeadline(long deadline) {
        this.deadline = deadline;
    }

    public boolean isSaved() {
        return isSaved;
    }

    public void setSaved(boolean saved) {
        isSaved = saved;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}
