## Exchange-Rates :currency_exchange:

This is an **Android application** that shows the exchange rates of the **Dollar** :dollar: and the **Euro** :euro: against the **Israeli Shekel**.
The application uses the JSON API of [exchangeratesapi.io](http://exchangeratesapi.io/) and the [OkHttp](https://square.github.io/okhttp/) library for sending and receive HTTP-based network requests.

## Motivation

The motivation behind this project was to create a simple as possible android application that shows the most used exchange rates in Israel, at the request of my parents who do not use the internet and are less technologically advanced.

## Screenshots

![image](/screenshots/layout.png?raw=true "layout")

## Tech/framework used

**Built with**

-   [Android Studio](https://developer.android.com/)

## Code Example

**SplashScreen.java**
~~~
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
	 } 
         catch (JSONException e) {  
            Log.e(PrefetchDataCurrency.class.getName(), "Not valid JSON data.");  
	 }  
    }  
    return null;  
}
~~~

## Installation

 **Running on android mobile**
 
 <a id="raw-url" href="https://raw.githubusercontent.com/dimakol/Exchange-Rates/master/app/release/ExchangeRates.apk">Click here to download the apk file</a>
 
**Running in development environment**

[Android SDK](https://developer.android.com/studio/intro/update) , [Android Studio](https://developer.android.com/studio) should be installed before moving on.
	
 - git clone https://github.com/dimakol/Exchange-Rates.git
 - open the project that currently cloned with some IDE like [Android Studio](https://developer.android.com/studio/install) or [IntelliJ IDEA](https://www.jetbrains.com/idea/)
 - run 'app'
 
## API Reference

- [exchangeratesapi.io](http://exchangeratesapi.io/) - Foreign exchange rates API

## Credits

- https://square.github.io/okhttp/
- https://www.sitepoint.com/consuming-web-apis-in-android-with-okhttp/

## License

MIT © Dima Kolyas
