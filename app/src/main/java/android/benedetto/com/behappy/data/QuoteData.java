package android.benedetto.com.behappy.data;

import android.benedetto.com.behappy.controller.AppController;
import android.benedetto.com.behappy.model.Quote;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class QuoteData {
    ArrayList<Quote> quoteArrayList = new ArrayList<>();

    // here Paulo created a callback interface to deal with the asynchronous nature of the
    // HTTP call

    public void getQuotes(final QuoteListAsyncResponse callBack) {
        String url =
                "https://raw.githubusercontent.com/pdichone/UIUX-Android-Course/master/Quotes.json%20";

        // singleton only use one instance
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET,
                url, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for (int i = 0; i < response.length(); i++) {
                    try {
                        JSONObject quoteObj = response.getJSONObject(i);
                        Quote quote = new Quote();
                        quote.setQuote(quoteObj.getString("quote"));
                        quote.setAuthor(quoteObj.getString("name"));

                        Log.d("getQuote", quoteObj.getString("name"));

                        quoteArrayList.add(quote);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }

                // only when the HTTP call is done, we call the callback method
                if (null != callBack) callBack.processFinished(quoteArrayList);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        AppController.getmInstance().addToRequestQueue(jsonArrayRequest);

    }
}
