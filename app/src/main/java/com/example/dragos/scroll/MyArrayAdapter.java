package com.example.dragos.scroll;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.LruCache;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by Dragos on 2016-09-25.
 */

public class MyArrayAdapter extends ArrayAdapter<Movie> {

    private LruCache<Integer,Bitmap> imagaeCache;


    public MyArrayAdapter(Activity context, ArrayList<Movie> movies) {

        super(context, 0, movies);

        final  int maxMemory= (int)(Runtime.getRuntime().maxMemory()/1024);
        final  int cacheSize= maxMemory/8;
        imagaeCache= new LruCache<>(cacheSize);

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView.inflate(getContext(),R.layout.item_layout,null);

        Movie currentMovie = getItem(position);

        TextView titleTextView = (TextView) listItemView.findViewById(R.id.item_title);
        titleTextView.setText(currentMovie.getTitle());

        TextView averageVoteTextView = (TextView) listItemView.findViewById(R.id.item_Average_vote);
        String stringdouble= Double.toString(currentMovie.getVoteAverage());
        averageVoteTextView.setText(stringdouble);


        Bitmap bitmap=imagaeCache.get(currentMovie.getMovieID());
        if(bitmap != null) {
            ImageView moviePosterImageView = (ImageView) listItemView.findViewById(R.id.film_poster);
            moviePosterImageView.setImageBitmap(currentMovie.getBitmap());
        }
        else
        {
            MovieAndView container= new MovieAndView();
            container.movie= currentMovie;
            container.view= listItemView;

            ImageLoader loader= new ImageLoader();
            loader.execute(container);
        }

        return listItemView;
    }

    private  class MovieAndView{
        private Movie movie;
        private View view;
        private Bitmap bitmap;
    }

    private class  ImageLoader extends AsyncTask<MovieAndView,Void,MovieAndView>{


        @Override
        protected MovieAndView doInBackground(MovieAndView... params) {

            MovieAndView container= params[0];
            Movie movie= container.movie;

            try {
                String imageUrl= MainActivity.IMAGE_URL + movie.getPicture()+ MainActivity.API_KEY ;
                InputStream in= (InputStream) new URL(imageUrl).getContent();
                Bitmap bitmap= BitmapFactory.decodeStream(in);
                movie.setBitmap(bitmap);
                in.close();

                container.bitmap= bitmap;
                return container;
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(MovieAndView result) {

            ImageView moviePosterImageView= (ImageView)result.view.findViewById(R.id.film_poster);
            moviePosterImageView.setImageBitmap(result.bitmap);

            imagaeCache.put(result.movie.getMovieID(),result.bitmap);

        }
    }


}

