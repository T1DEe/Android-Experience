package com.example.artemymarkovsky.mylittlebrowser;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebActivity extends Activity {

    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);

        webView = findViewById(R.id.webView);
        String url = getIntent().getStringExtra("address");
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl(url);
    }
}
