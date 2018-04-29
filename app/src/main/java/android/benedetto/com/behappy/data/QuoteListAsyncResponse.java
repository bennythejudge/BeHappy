package android.benedetto.com.behappy.data;

import android.benedetto.com.behappy.model.Quote;

import java.util.ArrayList;

public interface QuoteListAsyncResponse {
    void processFinished(ArrayList<Quote> quotes);
}
