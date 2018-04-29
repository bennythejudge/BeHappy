package android.benedetto.com.behappy;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.ShareActionProvider;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.concurrent.ThreadLocalRandom;


/**
 * A simple {@link Fragment} subclass.
 */
public class QuoteFragment extends Fragment {


    public QuoteFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View quoteView = inflater.inflate(R.layout.fragment_quote, container, false);
        // now we can control the fragment here with quoteView
        TextView quoteText = quoteView.findViewById(R.id.quoteText);
        TextView byAuthor = quoteView.findViewById(R.id.byAuthor);
        CardView cardView = quoteView.findViewById(R.id.cardview);

        String quote = getArguments().getString("quote");
        String author = getArguments().getString("author");

        int colors[] = new int[] {
                R.color.md_amber_500,
                R.color.md_blue_500,
                R.color.md_red_500,
                R.color.md_yellow_500,
                R.color.md_green_500
        };

        cardView.setBackgroundResource(getRandomQuote(colors));

        Log.d("onCreateView", "quote: " + quote);
        Log.d("onCreateView2", "author: " + author);

        quoteText.setText(quote);
        byAuthor.setText("-" + author);

        // the share button?
        



        return quoteView;
    }

    public static final QuoteFragment newInstance(String quote, String author) {
        QuoteFragment fragment = new QuoteFragment();
        Bundle bundle = new Bundle();
        bundle.putString("quote", quote);
        bundle.putString("author", author);
        fragment.setArguments(bundle);
        return fragment;
    }

    // randomise the color of the viewcard
    int getRandomQuote(int[] colorArray) {
        int color;
        int quotesArrayLen = colorArray.length;

        int randomNum = ThreadLocalRandom.current().nextInt(quotesArrayLen);
        color = colorArray[randomNum];
        return color;
    }

}
