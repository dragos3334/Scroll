package com.example.dragos.scroll;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;
import android.widget.ProgressBar;

import org.json.JSONArray;

/**
 * Created by Dragos on 2016-09-23.
 */

public class Movie implements Parcelable {

    private String Title;
    private int MovieID;
    private double VoteAverage;
    private String Description;
    private String Picture;
    private Bitmap bitmap;


    public int getMovieID() {
        return MovieID;
    }

    public void setMovieID(int movieID) {
        this.MovieID = movieID;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
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

    public Movie(){}

    public Movie(Parcel in) {
        readFromParcel(in);
    }

    private void readFromParcel(Parcel in) {

        Title = in.readString();
        MovieID = in.readInt();
        VoteAverage = in.readDouble();
        Description = in.readString();
        Picture = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(Title);
        dest.writeInt(MovieID);
        dest.writeDouble(VoteAverage);
        dest.writeString(Description);
        dest.writeString(Picture);

    }

    public static final Parcelable.Creator CREATOR =
            new Parcelable.Creator() {
                public Movie createFromParcel(Parcel in) {
                    return new Movie(in);
                }

                @Override
                public Movie[] newArray(int size) {
                    return new Movie[size];
                }
            };
}

