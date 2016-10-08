package com.example.dragos.scroll;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class MovieDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);

        ImageView imageView = (ImageView) findViewById(R.id.movie_poster);
        TextView title = (TextView) findViewById(R.id.title);
        TextView description = (TextView) findViewById(R.id.description);
        TextView vote = (TextView) findViewById(R.id.vote);
        Bundle extras = getIntent().getExtras();
        Intent intent= getIntent();

        Movie movie = extras.getParcelable("MY_MOVIE_OBJECT");
        imageView.setImageBitmap((Bitmap)intent.getParcelableExtra("BITMAP"));

        title.setText(movie.getTitle());

        String stringdouble = Double.toString(movie.getVoteAverage());
        vote.setText(stringdouble);

        if(movie.getDescription().equals("")){
            description.setText(R.string.noDescription);
        }else{
            description.setText(movie.getDescription());}

    }
}
