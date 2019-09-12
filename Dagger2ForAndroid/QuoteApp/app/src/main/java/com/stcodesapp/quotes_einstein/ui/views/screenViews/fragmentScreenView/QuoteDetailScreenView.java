package com.stcodesapp.quotes_einstein.ui.views.screenViews.fragmentScreenView;

import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.stcodesapp.quotes_einstein.R;
import com.stcodesapp.quotes_einstein.constants.EventTypes;
import com.stcodesapp.quotes_einstein.ui.views.baseScreens.BaseObservableScreenView;
import com.stcodesapp.quotes_einstein.ui.views.screens.fragmentScreen.QuoteDetailScreen;

public class QuoteDetailScreenView extends BaseObservableScreenView<QuoteDetailScreen.Listener> implements QuoteDetailScreen
{

    private TextView listenButton, copyButton, shareButton, quoteText, drawBackgroundButton;


    public QuoteDetailScreenView(LayoutInflater layoutInflater, @Nullable ViewGroup parent)
    {
        setRootView(layoutInflater.inflate(R.layout.quote_detail_layout,parent,false));
        inflateUIElements();
        initUserInteractions();
    }


    @Override
    public void initUserInteractions()
    {
        setClickListener(listenButton,EventTypes.LISTEN_QUOTE_BUTTON_CLICKED);
        setClickListener(copyButton,EventTypes.COPY_QUOTE_BUTTON_CLICKED);
        setClickListener(shareButton,EventTypes.SHARE_QUOTE_BUTTON_CLICKED);
        setClickListener(drawBackgroundButton,EventTypes.DRAW_BACKGROUND_BUTTON_CLICKED);

    }

    @Override
    public void inflateUIElements()
    {
        quoteText = findViewById(R.id.quote_detail_text);
        listenButton = findViewById(R.id.listen_button);
        copyButton = findViewById(R.id.copy_button);
        shareButton = findViewById(R.id.share_button);
        drawBackgroundButton = findViewById(R.id.draw_background_button);

    }

    private void setClickListener(View view, final EventTypes eventTypes)
    {
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(Listener listener : getListeners())
                {
                    switch (eventTypes)
                    {
                        case COPY_QUOTE_BUTTON_CLICKED:
                            listener.onCopyQuoteClicked();
                            break;
                        case SHARE_QUOTE_BUTTON_CLICKED:
                            listener.onShareQuoteClicked();
                            break;
                        case LISTEN_QUOTE_BUTTON_CLICKED:
                            listener.onListenQuoteClicked();
                            break;
                        case DRAW_BACKGROUND_BUTTON_CLICKED:
                            listener.onDrawBackgroundButtonClicked();
                            break;

                    }
                }
            }
        });

    }

    public TextView getListenButton() {
        return listenButton;
    }

    public TextView getCopyButton() {
        return copyButton;
    }

    public TextView getShareButton() {
        return shareButton;
    }

    public TextView getQuoteText() {
        return quoteText;
    }
}
