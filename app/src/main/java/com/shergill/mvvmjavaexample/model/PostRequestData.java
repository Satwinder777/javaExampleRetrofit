package com.shergill.mvvmjavaexample.model;

import android.annotation.SuppressLint;

public class PostRequestData {
    public String name;
    public String job;

    public PostRequestData(String name, String job) {
        this.job = job;
        this.name= name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getName() {
        return name;
    }

    public String getJob() {
        return job;
    }
}

