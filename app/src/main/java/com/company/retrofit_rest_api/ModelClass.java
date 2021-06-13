package com.company.retrofit_rest_api;

import com.google.gson.annotations.SerializedName;

public class ModelClass {

    //https://jsonplaceholder.typicode.com/posts

    private int userId;

    private int id;

    private String title;

    @SerializedName("body")
    private String subTitle;

    public int getUserId() {
        return userId;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getSubTitle() {
        return subTitle;
    }
}
