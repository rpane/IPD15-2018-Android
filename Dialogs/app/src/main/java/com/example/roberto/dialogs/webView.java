package com.example.roberto.dialogs;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

public class webView extends AppCompatActivity implements View.OnClickListener {

    Button button;
    WebView browser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        initialize();
    }

    private void initialize(){
        button = findViewById(R.id.button7);
        button.setOnClickListener(this);

        browser = findViewById(R.id.webBrowser);
    }
    public void backBut(View view) {
        finish();
    }

    @Override
    public void onClick(View v) {
        browser.getSettings().setJavaScriptEnabled(true);

        browser.setWebViewClient(new WebViewClient());
        browser.loadUrl("https://www.google.ca");
    }
}
