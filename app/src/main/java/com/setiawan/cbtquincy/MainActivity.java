package com.setiawan.cbtquincy;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityManager;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import android.provider.Settings;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {
    String urlString = "http://152541203355.ip-dynamic.com/ubk/";
    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(urlString));
    int countOverview = 0;
    int countBack = 0;

    @Override
    protected void onPause() {
        super.onPause();

        ActivityManager activityManager = (ActivityManager) getApplicationContext()
                .getSystemService(Context.ACTIVITY_SERVICE);
        //Close and reopen app or bringForFront()

        activityManager.moveTaskToFront(getTaskId(), 0);

        countOverview++;

    }

    WebView webviewku;
    WebSettings webSettingku;
    Button Button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webviewku = (WebView)findViewById(R.id.WebView);
        webSettingku = webviewku.getSettings();
        webviewku.setWebViewClient(new WebViewClient());
        webviewku.loadUrl("http://152541203355.ip-dynamic.com/ubk/");

    }

    @Override
    public void onBackPressed() {

        if(countBack > 6 && countOverview > 5) {
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                final Intent intent = new Intent(Settings.ACTION_HOME_SETTINGS);
                startActivity(intent);
            }
            else {
                final Intent intent = new Intent(Settings.ACTION_SETTINGS);
                startActivity(intent);
            }
            countOverview = 0;
            countBack = 0;
        } else {
            countBack++;
        }
    }

}