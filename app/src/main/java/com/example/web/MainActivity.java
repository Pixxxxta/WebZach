package com.example.web;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private WebView browser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        browser=findViewById(R.id.webBrowser);



    }

    public void onWeb(View view) {
        browser.loadUrl("https://www.fcufa.pro/");
        browser.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                if (url.contains("fcufa.pro")){view.loadUrl(url);}
                else{
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse(url));
                    startActivity(intent);
                    Toast toast = Toast.makeText(getApplicationContext(),
                            "Внешняя ссылка!", Toast.LENGTH_SHORT);
                    toast.show();
                }
                return true;
            }
        });

    }

    public void onFor(View view) {
        if(browser.canGoForward()) {
            browser.goForward();
        }
        else{
            Toast toast = Toast.makeText(getApplicationContext(),
                    "РУССКИЕ НЕ МОГУТ ИДТИ ВПЁРЁД", Toast.LENGTH_SHORT);
            toast.show();
        }
    }
    public void onBack(View view) {
        if(browser.canGoBack()) {
            browser.goBack();
        }
        else{
            Toast toast = Toast.makeText(getApplicationContext(),
                    "РУССКИЕ НЕ МОГУТ ИДТИ НАЗАД", Toast.LENGTH_SHORT);
            toast.show();
        }
    }

}