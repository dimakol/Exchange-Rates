package com.dimadev.exchange_rates.splashscreen;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import com.dimadev.exchange_rates.R;
import com.dimadev.exchange_rates.pojo.Currency;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textUSD = (TextView) findViewById(R.id.valueUSD);
        TextView textEUR = (TextView) findViewById(R.id.valueEUR);
        TextView textDate = (TextView) findViewById(R.id.valueDate);

        // Get data from the intent
        Currency currency = (Currency) getIntent().getSerializableExtra("currency");
        String date = getIntent().getStringExtra("date");

        // Display currency in 2 decimal places
        textUSD.setText(new DecimalFormat("##.##").format(currency.getCurrencyUSD()));
        textEUR.setText(new DecimalFormat("##.##").format(currency.getCurrencyEUR()));

        // Display date as dd-MM-yyyy format
        String formattedDate = "";
        try {
            // Set date as yyyy-MM-dd format
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            // Parse the original string value into Date object.
            Date newDate = format.parse(date);
            // Change the date format to dd-MM-yyyy
            format = new SimpleDateFormat("dd-MM-yyyy");
            // Format the date from yyyy-MM-dd format to dd-MM-yyyy format
            formattedDate = format.format(newDate);;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        // Display the formatted date
        textDate.setText(formattedDate);

        // Import font from assets
        String fontPath = "fonts/Paint Peel Initials.ttf";
        // Our Signature
        TextView text = (TextView) findViewById(R.id.signature);
        // Font Face
        Typeface typeface = Typeface.createFromAsset(getAssets(), fontPath);
        // Applying font to signature text
        text.setTypeface(typeface);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
