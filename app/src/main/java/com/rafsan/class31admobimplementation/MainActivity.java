package com.rafsan.class31admobimplementation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;

public class MainActivity extends AppCompatActivity {
    AdView mAdView;

    // (Interstitail AD).........>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    Button buttonInterstitial;

    private InterstitialAd mInterstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Banner AD>>>>>>>>>>>>>>>>>>>>>>>>
        mAdView = findViewById(R.id.adView);

        // (Interstitail AD).........>>>>>>>>>>>>>>>>>>>>>>>>>>>>
        buttonInterstitial = findViewById(R.id.buttonInterstitial);


        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        // Banner AD>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);


        // (Interstitail AD).........>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
        AdRequest adRequestInterstitial = new AdRequest.Builder().build();

        InterstitialAd.load(this,"ca-app-pub-3940256099942544/1033173712", adRequestInterstitial,
                new InterstitialAdLoadCallback() {
                    @Override
                    public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
                        // The mInterstitialAd reference will be null until
                        // an ad is loaded.
                        mInterstitialAd = interstitialAd;

                    }

                    @Override
                    public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                        // Handle the error

                        mInterstitialAd = null;
                    }
                });

        buttonInterstitial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mInterstitialAd.show(MainActivity.this);
            }
        });

    }
}