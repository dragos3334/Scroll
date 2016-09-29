package com.example.dragos.scroll;

import android.graphics.Bitmap;

import org.json.JSONArray;

/**
 * Created by Dragos on 2016-09-23.
 */

public class Movie {

    private String Title;
    private int movieID;
    private JSONArray Genre;
    private int VoteCount;
    private double VoteAverage;
    private String Description;
    private String Picture;
    private Bitmap bitmap;


    public int getMovieID() {return movieID;}

    public void setMovieID(int movieID) {this.movieID = movieID;}

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public JSONArray getGenre() {
        return Genre;
    }

    public void setGenre(JSONArray genre) {
        Genre = genre;
    }

    public int getVoteCount() {
        return VoteCount;
    }

    public void setVoteCount(int voteCount) {
        VoteCount = voteCount;
    }

    public double getVoteAverage() {
        return VoteAverage;
    }

    public void setVoteAverage(double voteAverage) {
        VoteAverage = voteAverage;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getPicture() {
        return Picture;
    }

    public void setPicture(String picture) {
        Picture = picture;
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }
}
