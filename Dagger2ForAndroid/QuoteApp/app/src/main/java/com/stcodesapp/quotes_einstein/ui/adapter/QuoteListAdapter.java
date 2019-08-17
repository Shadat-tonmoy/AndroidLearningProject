package com.stcodesapp.quotes_einstein.ui.adapter;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.stcodesapp.quotes_einstein.R;
import com.stcodesapp.quotes_einstein.models.Quotes;
import java.util.List;

public class QuoteListAdapter extends RecyclerView.Adapter<QuoteListAdapter.ViewHolder>
{

    private List<Quotes> quotesList;
    private Activity activity;

    public QuoteListAdapter(Activity activity)
    {
        this.activity = activity;
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        TextView quoteText, lastShowText;
        ImageView addToFavButton;
        View itemView;

        public ViewHolder(@NonNull View itemView)
        {
            super(itemView);
            this.itemView = itemView;
            quoteText = itemView.findViewById(R.id.quote_text);
            lastShowText = itemView.findViewById(R.id.last_view_text);
            addToFavButton = itemView.findViewById(R.id.add_to_fav_button);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i)
    {
        View listItemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.quote_single_row,viewGroup,false);
        return new ViewHolder(listItemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i)
    {
        final Quotes quotes = quotesList.get(i);
        viewHolder.quoteText.setText(quotes.getQuoteText());
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity, "Clicked on "+quotes.getQuoteID(), Toast.LENGTH_SHORT).show();
            }
        });

        viewHolder.addToFavButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity, "Adding to fav "+quotes.getQuoteID(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount()
    {
        if(quotesList!=null)
            return quotesList.size();
        else return 0;
    }


    public void bindQuotes(List<Quotes> quotesList)
    {
        this.quotesList = quotesList;
        notifyDataSetChanged();
    }


}
