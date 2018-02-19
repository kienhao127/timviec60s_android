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

    public JobQuickView(){

    }

    public JobQuickView(String companyLogoURL, String companyName, String jobPosition, String location, int salaryAmount, long deadline, boolean isSaved) {
        this.companyLogoURL = companyLogoURL;
        this.companyName = companyName;
        this.jobPosition = jobPosition;
        this.location = location;
        this.salaryAmount = salaryAmount;
        this.deadline = deadline;
        this.isSaved = isSaved;
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
}
