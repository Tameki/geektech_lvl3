package com.geektech.astudy.data.beer.model;

import com.google.gson.annotations.SerializedName;

// Created by askar on 11/13/18.
public class Beer {
    @SerializedName("id")
    private int id;

    @SerializedName("name")
    private String name;

    @SerializedName("tagline")
    private String tagline;

    @SerializedName("description")
    private String description;

    @SerializedName("image_url")
    private String imageUrl;

    //region Constructor

    public Beer(
            int id,
            String name,
            String tagline,
            String description,
            String imageUrl){
        this.id = id;
        this.name = name;
        this.tagline = tagline;
        this.description = description;
        this.imageUrl = imageUrl;
    }

    //endregion

    //region Getters/Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTagline() {
        return tagline;
    }

    public void setTagline(String tagline) {
        this.tagline = tagline;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    //endregion


    @Override
    public String toString() {
        return id + " " + name + " " + imageUrl;
    }
}
