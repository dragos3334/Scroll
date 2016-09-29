package com.example.dragos.scroll;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Movie> movieList;
    public static ArrayAdapter adapter;
    private ListView listView;
    public  static int positionInList;
    public static final String IMAGE_URL="https://image.tmdb.org/t/p/w154";
    public static final String API_KEY= "&api_key=c4ecdfbf483df6da50ee828803c75746";
    private final String actionURL= "https://api.themoviedb.org/3/discover/movie?with_genres=28&sort_by=vote_average.desc&vote_count.gte=10&api_key=c4ecdfbf483df6da50ee828803c75746";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);

        requestData(actionURL);

        listView=(ListView)findViewById(R.id.movie_list);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startActivity(new Intent(MainActivity.this,MovieDetails.class));
                positionInList=position;

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(isOnLine())
        {
            MatchLinks(id);
        }
        else
        {
            Toast.makeText(getBaseContext(),"Network isnt available",Toast.LENGTH_LONG).show();
        }

        return super.onOptionsItemSelected(item);
    }

    private void requestData(String uri) {
        MyTask task= new MyTask();
        task.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR,uri);
    }

    protected void updateDisplay() {
        adapter=new MyArrayAdapter(this,movieList);

        if (movieList != null) {

            listView.setAdapter(adapter);
            }
    }

    protected boolean isOnLine(){
        ConnectivityManager cm =(ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo=cm.getActiveNetworkInfo();
        return netInfo != null && netInfo.isConnectedOrConnecting();
    }

    private class MyTask extends AsyncTask<String,String,String>{

        @Override
        protected String doInBackground(String... params) {
            String content= HttpManager.getData(params[0]);
            movieList= MovieJSONParser.parseFeed(content);

            return content;
        }

        @Override
        protected void onPostExecute(String result) {

            updateDisplay();
        }


    } private void MatchLinks(int id) {
        switch (id){


            case R.id.action_select:
                requestData(actionURL);
                break;

            case R.id.adventure_select:
                requestData("https://api.themoviedb.org/3/discover/movie?with_genres=12&sort_by=vote_average.desc&vote_count.gte=10&api_key=c4ecdfbf483df6da50ee828803c75746");
                break;
            case R.id.animation_select:
                requestData("https://api.themoviedb.org/3/discover/movie?with_genres=16&sort_by=vote_average.desc&vote_count.gte=10&api_key=c4ecdfbf483df6da50ee828803c75746");
                break;
            case R.id.comedy_select:
                requestData("https://api.themoviedb.org/3/discover/movie?with_genres=35&sort_by=vote_average.desc&vote_count.gte=10&api_key=c4ecdfbf483df6da50ee828803c75746");
                break;
            case R.id.crime_select:
                requestData("https://api.themoviedb.org/3/discover/movie?with_genres=80&sort_by=vote_average.desc&vote_count.gte=10&api_key=c4ecdfbf483df6da50ee828803c75746");
                break;
            case R.id.documentary_select:
                requestData("https://api.themoviedb.org/3/discover/movie?with_genres=99&sort_by=vote_average.desc&vote_count.gte=10&api_key=c4ecdfbf483df6da50ee828803c75746");
                break;
            case R.id.drama_select:
                requestData("https://api.themoviedb.org/3/discover/movie?with_genres=18&sort_by=vote_average.desc&vote_count.gte=10&api_key=c4ecdfbf483df6da50ee828803c75746");
                break;
            case R.id.family_select:
                requestData("https://api.themoviedb.org/3/discover/movie?with_genres=10751&sort_by=vote_average.desc&vote_count.gte=10&api_key=c4ecdfbf483df6da50ee828803c75746");
                break;
            case R.id.fantasy_select:
                requestData("https://api.themoviedb.org/3/discover/movie?with_genres=14&sort_by=vote_average.desc&vote_count.gte=10&api_key=c4ecdfbf483df6da50ee828803c75746");
                break;
            case R.id.history_select:
                requestData("https://api.themoviedb.org/3/discover/movie?with_genres=36&sort_by=vote_average.desc&vote_count.gte=10&api_key=c4ecdfbf483df6da50ee828803c75746");
                break;
            case R.id.horror_select:
                requestData("https://api.themoviedb.org/3/discover/movie?with_genres=27&sort_by=vote_average.desc&vote_count.gte=10&api_key=c4ecdfbf483df6da50ee828803c75746");
                break;
            case R.id.music_select:
                requestData("https://api.themoviedb.org/3/discover/movie?with_genres=10402&sort_by=vote_average.desc&vote_count.gte=10&api_key=c4ecdfbf483df6da50ee828803c75746");
                break;
            case R.id.mystery_select:
                requestData("https://api.themoviedb.org/3/discover/movie?with_genres=9648&sort_by=vote_average.desc&vote_count.gte=10&api_key=c4ecdfbf483df6da50ee828803c75746");
                break;
            case R.id.romance_select:
                requestData("https://api.themoviedb.org/3/discover/movie?with_genres=10749&sort_by=vote_average.desc&vote_count.gte=10&api_key=c4ecdfbf483df6da50ee828803c75746");
                break;
            case R.id.sciencefiction_select:
                requestData("https://api.themoviedb.org/3/discover/movie?with_genres=10749&sort_by=vote_average.desc&vote_count.gte=10&api_key=c4ecdfbf483df6da50ee828803c75746");
                break;
            case R.id.tvmovie_select:
                requestData("https://api.themoviedb.org/3/discover/movie?with_genres=10770&sort_by=vote_average.desc&vote_count.gte=10&api_key=c4ecdfbf483df6da50ee828803c75746");
                break;
            case R.id.thriller_select:
                requestData("https://api.themoviedb.org/3/discover/movie?with_genres=53&sort_by=vote_average.desc&vote_count.gte=10&api_key=c4ecdfbf483df6da50ee828803c75746");
                break;
            case R.id.war_select:
                requestData("https://api.themoviedb.org/3/discover/movie?with_genres=10752&sort_by=vote_average.desc&vote_count.gte=10&api_key=c4ecdfbf483df6da50ee828803c75746");
                break;
            case R.id.western_select:
                requestData("https://api.themoviedb.org/3/discover/movie?with_genres=37&sort_by=vote_average.desc&vote_count.gte=10&api_key=c4ecdfbf483df6da50ee828803c75746");
                break;

        }
    }

}
