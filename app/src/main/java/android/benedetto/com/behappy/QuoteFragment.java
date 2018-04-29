package android.benedetto.com.behappy;


import android.content.Intent;
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
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.concurrent.ThreadLocalRandom;


/**
 * A simple {@link Fragment} subclass.
 */
public class QuoteFragment extends Fragment {

    String quote = null;
    String author = null;

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

        quote = getArguments().getString("quote");
        author = getArguments().getString("author");

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
        Button shareBtn = quoteView.findViewById(R.id.shareButton);
        shareBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "clicked on share button", Toast.LENGTH_SHORT).show();
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, quote + " " + author);
                sendIntent.setType("text/plain");
                startActivity(sendIntent);
            }
        });



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
