package com.betonirlite.nikolay.betonir;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebArmaturaActivity extends AppCompatActivity {
    private WebView mWebView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_armatura);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        Toolbar my_toolbar4 = (Toolbar)findViewById(R.id.toolbar2);
        setSupportActionBar(my_toolbar4);

        getSupportActionBar().setTitle(R.string.activity_web_armatura);


        my_toolbar4.setNavigationIcon(R.mipmap.ic_12);

        my_toolbar4.setNavigationOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {

                Intent a = new Intent(WebArmaturaActivity.this,MainActivity.class);
                a.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(a);

            }
        });

        mWebView = (WebView) findViewById(R.id.webView);
        // включаем поддержку JavaScript
        mWebView.getSettings().setJavaScriptEnabled(true);
        // указываем страницу загрузки

        mWebView.setWebViewClient(new MyWebViewClient());

        //EditText textView008 = (EditText) findViewById(R.id.editText);
        //aetText008 = (Button) findViewById(R.id.button38);
        // String b = String.(textView008.getText().toString());
        //String a = "https://www.google.com.ua/maps/search/бетон";
        //EditText b = textView008;
        //float num0010 = Float.parseFloat(String("https://www.google.com.ua/maps/search/бетон"));
        //float w8 = (float) num008;
        //float w9 = (int) "https://www.google.com.ua/maps/search/бетон";
        // textView008.setText(String.format(Locale.US, "%.2f", w8) + "");



        String a = "https://uk.m.wikipedia.org/wiki/бетон";
        mWebView.loadUrl (a + " ");

        //mWebView.loadUrl("https://www.google.com.ua/maps/search/бетон");Киев

    }
    private class MyWebViewClient extends WebViewClient
    {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url)
        {
            view.loadUrl(url);
            return true;
        }
    }
    @Override
    public void onBackPressed() {
        // do something on back.

        Intent a = new Intent(this,MainActivity.class);
        a.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(a);
    }

}