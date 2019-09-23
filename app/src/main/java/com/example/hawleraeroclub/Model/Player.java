package com.example.hawleraeroclub.Model;

import android.view.View;

import java.util.Date;

public class Player {
    private String name;
    private String bloodType;
    private String workType;
    private String phoneNumber;
    private Date birthDate;
    private Integer imageResource;
    private View.OnClickListener requestBtnClickListener;

    public Player(String name, Date birthDate, String bloodType, Integer imageResource, String phoneNumber) {
        this.name = name;
        this.birthDate = birthDate;
        this.bloodType = bloodType;
        this.imageResource = imageResource;
        this.phoneNumber = phoneNumber;
    }

    // constructor
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    public String getWorkType() {
        return workType;
    }

    public void setWorkType(String workType) {
        this.workType = bloodType;
    }

    public Integer getImageResource() {
        return imageResource;
    }

    public void setImageResource(Integer imageResource) {
        this.imageResource = imageResource;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public View.OnClickListener getRequestBtnClickListener() {
        return requestBtnClickListener;
    }

    public void setRequestBtnClickListener(View.OnClickListener requestBtnClickListener) {
        this.requestBtnClickListener = requestBtnClickListener;
    }

}
