package com.dimadev.exchange_rates.parser;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import org.json.JSONObject;

public class JSONParser
{
    public static JSONObject getJSONFromUrl(String str_url) {

        // Our JSONObject that will be returned
        JSONObject jsonObject = null;

        // Using the OkHttp library for HTTP requests
        OkHttpClient client = new OkHttpClient();

        // Creating request object for make network calls
        Request request = new Request.Builder()
                .url(str_url)
                .header("Content-Type", "application/json")
                .build();

        try {
            // Making a synchronous network call to receive the exchange rate of all currencies
            Response response = client.newCall(request).execute();
            // Generating JSON Object from the response
            jsonObject = new JSONObject(response.body().string());
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            // Return the generated JSON object
            return jsonObject;
        }
    }
}
