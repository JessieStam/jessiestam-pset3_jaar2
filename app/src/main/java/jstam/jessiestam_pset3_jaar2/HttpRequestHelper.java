package jstam.jessiestam_pset3_jaar2;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Jessie on 22/09/2016.
 */

public class HttpRequestHelper {

    // developer key for poster
    private static final String developer_key = "f8b232b0";

    // strings for URL
    private static final String url1 = "http://www.omdbapi.com/?t=";
    private static final String url2 = "&plot=short&r=json";

    // strings for image URL
    private static final String url3 = "http://img.omdbapi.com/?apikey=";
    private static final String url4 = "&";

    /*
     * Downloads information from the server and puts it into a string object.
     */
    protected static synchronized String downloadFromServer(String[] title) {

        // create result String
        String result = "";

        // complete URL string and turn into URL
        String complete_URL_string = url1 + title + url2;
        URL complete_URL = null;

        try {
            complete_URL = new URL(complete_URL_string);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        // make the connection
        HttpURLConnection connection;
        if (complete_URL != null) {
            try {
                connection = (HttpURLConnection) complete_URL.openConnection();

                // open connection, set request method
                connection.setRequestMethod("GET");

                // get response code
                Integer responce_code = connection.getResponseCode();

                // if 200-300, read inputstream
                if (200 <= responce_code && responce_code <= 299) {
                    BufferedReader bufferedReader = new BufferedReader
                            (new InputStreamReader(connection.getInputStream()));
                    String line;
                    while ((line = bufferedReader.readLine()) != null) {
                        result = result + line;
                    }
                }
                // when error occures, read errorstream
                else {
                    BufferedReader bufferedReader = new BufferedReader
                            (new InputStreamReader(connection.getErrorStream()));
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // return result string
        return result;
    }

    /*
    * Downloads picture from the server and puts it into an ImageView object
    */
    protected static synchronized ImageView downloadImageFromServer(String title) {

        // create result string
        ImageView result = new ImageView(null);

        // complete URL string and turn into URL
        String complete_URL_image_string = url3 + developer_key + url4 + title;
        URL complete_image_URL = null;

        try {
            complete_image_URL = new URL(complete_URL_image_string);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        // make the connection
        HttpURLConnection connection;
        if (complete_image_URL != null) {
            try {
                connection = (HttpURLConnection) complete_image_URL.openConnection();

                Bitmap film_image = BitmapFactory.decodeStream(connection.getInputStream());

                result.setImageBitmap(film_image);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // return result string
        return result;
    }
}
