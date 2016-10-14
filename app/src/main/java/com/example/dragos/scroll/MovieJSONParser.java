package com.example.dragos.scroll;



import com.example.dragos.scroll.Movie;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class MovieJSONParser {

    public static ArrayList<Movie> parseFeed (String content){
        try {

            JSONObject jb= new JSONObject(content);
            JSONArray ar= jb.getJSONArray("results");


            ArrayList<Movie> movieList= new ArrayList<>();

            for( int i= 0; i < ar.length(); i ++){

                JSONObject obj= ar.getJSONObject(i);
                Movie movie = new Movie();


                movie.setTitle(obj.getString("title"));
                movie.setMovieID(obj.getInt("id"));
                movie.setVoteAverage(obj.getDouble("vote_average"));
                movie.setDescription(obj.getString("overview"));
                movie.setPicture(obj.getString("poster_path"));


                movieList.add(movie);

            }
            return movieList;
        } catch (JSONException e) {
            e.printStackTrace();

            return null;
        }
    }
}

