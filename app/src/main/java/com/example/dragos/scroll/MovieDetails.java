package com.example.dragos.scroll;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class MovieDetails extends AppCompatActivity {

    private ImageView imageView;
    private TextView title;
    private TextView description;
    private TextView vote;
    private int positionItem;
    private ArrayAdapter arrayAdapter;
    private Movie movie;
    private String stringdouble;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);

        imageView=(ImageView) findViewById(R.id.movie_poster);
        title=(TextView)findViewById(R.id.title);
        description=(TextView)findViewById(R.id.description);
        vote=(TextView)findViewById(R.id.vote);

        positionItem= MainActivity.positionInList;


        arrayAdapter= MainActivity.adapter;
        movie= (Movie) arrayAdapter.getItem(positionItem);
        imageView.setImageBitmap(movie.getBitmap());

        title.setText(movie.getTitle());

        stringdouble= Double.toString(movie.getVoteAverage());
        vote.setText(stringdouble);
        if(movie.getDescription().equals("")){
            description.setText(R.string.noDescription);
        }else{description.setText(movie.getDescription());}


    }
}
