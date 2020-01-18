package com.dimadev.exchange_rates.splashscreen;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import com.dimadev.exchange_rates.R;
import com.dimadev.exchange_rates.parser.JSONParser;
import com.dimadev.exchange_rates.pojo.Currency;
import org.json.JSONException;
import org.json.JSONObject;

public class SplashScreen extends Activity {

    // Link to exchange rates from USD
    private final String URL =
            "https://api.exchangeratesapi.io/latest?base=USD";

    // Our POJO where we put the result obtained by the link
    private Currency currency;

    // The date result obtained by the link
    private String date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_layout);

        currency = new Currency();

        // Start the stream to receive data
        // at that moment will be shown the Splash Screen
        // after the thread completes, we will show MainActivity
        new PrefetchDataCurrency().execute();
    }

    // Create AsyncTask, which will receive the exchange rate in the stream
    private class PrefetchDataCurrency extends AsyncTask<Void, Void, Void > {

        @Override
        protected Void doInBackground(Void... voids) {
            // Get the JSON from the URL
            JSONObject jsonCurrencies = JSONParser.getJSONFromUrl(URL);

            // If we get something, then we will fill our currency with the received data
            if (jsonCurrencies != null) {
                try {
                    // Get the value of the currency with JSON by the currency key
                    Double CurrencyEUR = jsonCurrencies.getJSONObject("rates").getDouble("ILS")/jsonCurrencies.getJSONObject("rates").getDouble("EUR");
                    Double CurrencyUSD = jsonCurrencies.getJSONObject("rates").getDouble("ILS")/jsonCurrencies.getJSONObject("rates").getDouble("USD");
                    // Get the date
                    date = jsonCurrencies.getString("date");
                    // Setting the currencies
                    currency.setCurrencyEUR(CurrencyEUR);
                    currency.setCurrencyUSD(CurrencyUSD);
                } catch (JSONException e) {
                    Log.e(PrefetchDataCurrency.class.getName(), "Not valid JSON data.");
                }
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);

            // Create a new Intent to switch to MainActivity
            Intent intent = new Intent(SplashScreen.this, MainActivity.class);
            // Add our currency POJO to Intent
            // note that the Currency class must implement Serializable interface
            intent.putExtra("currency", currency);
            // Add our dare to Intent
            intent.putExtra("date", date);

            // We launch a new Activity with an Intent that stores our currency object and date
            startActivity(intent);

            // We finish the flow
            finish();
        }
    }

}
