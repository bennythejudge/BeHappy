package android.benedetto.com.behappy;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;


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
        TextView byAuthor = quoteText.findViewById(R.id.byAuthor);
        CardView cardView = quoteText.findViewById(R.id.cardview);

        String quote = getArguments().getString("author");
        String author = getArguments().getString("author");

        quoteText.setText(quote);
        byAuthor.setText("-" + author);
        
        return quoteView;
    }

    public static final QuoteFragment newInstance(String quote, String author) {
        QuoteFragment fragment = new QuoteFragment();
        Bundle bundle = new Bundle();
        bundle.putString("quote", quote);
        bundle.putString("author", author);
    }

}
