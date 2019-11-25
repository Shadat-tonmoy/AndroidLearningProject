package com.shadattonmoy.mobileadmanager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;

import com.amazon.device.ads.Ad;
import com.amazon.device.ads.AdError;
import com.amazon.device.ads.AdLayout;
import com.amazon.device.ads.AdListener;
import com.amazon.device.ads.AdProperties;
import com.amazon.device.ads.AdRegistration;
import com.amazon.device.ads.AdTargetingOptions;
import com.shadattonmoy.mobileadmanager.R;

public class MainActivity extends AppCompatActivity
{

    private AdLayout adView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AdRegistration.setAppKey("a6604e5b044b4c778a2121d8687bf52c");
        AdRegistration.enableTesting(true);
        AdRegistration.enableLogging(true);



        this.adView = new AdLayout(this);
        LinearLayout layout = (LinearLayout) findViewById(R.id.banner_ad_holder);
        // Set the correct width and height of the ad
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT);
        layout.addView(this.adView,lp);

        // If you declared AdLayout in your xml you would instead
        // replace the 3 lines above with the following line:
        //   this.adView = (AdLayout) findViewById(R.id.adview);

        AdTargetingOptions adOptions = new AdTargetingOptions();
        // Optional: Set ad targeting options here.
        this.adView.loadAd(adOptions);

        adView.setListener(new AdListener() {
            @Override
            public void onAdLoaded(Ad ad, AdProperties adProperties)
            {
                Log.e("AmazonBannerAd","Loaded");

            }

            @Override
            public void onAdFailedToLoad(Ad ad, AdError adError)
            {
                Log.e("AmazonBannerAd","Failed To Load "+adError.getMessage());

            }

            @Override
            public void onAdExpanded(Ad ad) {

            }

            @Override
            public void onAdCollapsed(Ad ad) {

            }

            @Override
            public void onAdDismissed(Ad ad) {

            }
        });
    }
}
