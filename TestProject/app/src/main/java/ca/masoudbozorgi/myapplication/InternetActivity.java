package ca.masoudbozorgi.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

public class InternetActivity extends AppCompatActivity implements View.OnClickListener {

    WebView webView;
    Button btnLoad;
    String url="https://www.yahoo.com";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_internet);

        initialize();
    }

    private void initialize() {

        btnLoad = findViewById(R.id.btnLoad);
        btnLoad.setOnClickListener(this);

        webView = findViewById(R.id.webView);
    }

    @Override
    public void onClick(View v) {

        webView.getSettings().setJavaScriptEnabled(true);

        // Set webView element as out browser or WebViewClient,
        // so web pages will be display in same layout instead of a browser
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl(url);
    }


    @Override
    public void onBackPressed() {
        if(webView.canGoBack()){
            webView.goBack();
        }else{
            super.onBackPressed();
        }
    }
}