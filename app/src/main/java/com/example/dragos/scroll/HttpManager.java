package com.example.dragos.scroll;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Dragos on 2016-09-23.
 */

class HttpManager {

    static String getData(String Uri) {
        BufferedReader reader=null;
        try {
            URL url= new URL(Uri);
            HttpURLConnection con = null;

            con = (HttpURLConnection)url.openConnection();

            StringBuilder sb = new StringBuilder();
            reader= new BufferedReader(new InputStreamReader(con.getInputStream()));

            String line;
            while (( line = reader.readLine()) != null)
            {
                sb.append(line + "\n");
            }
            return sb.toString();
        } catch (IOException e) {
            e.printStackTrace();

            return null;
        }finally {
            if (reader != null){
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    return null;
                }
            }
        }
    }
}