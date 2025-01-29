package com.github.saiaaaaaaa.awpcollectormain;

import android.content.Context;
import android.net.http.SslError;
import android.util.Base64;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import java.nio.charset.StandardCharsets;

public class AWPCollectorQuery {
    WebView webView;

    public AWPCollectorQuery(Context context) {
        webView = new WebView(context);
    }

    public void execute(String query) {
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
                handler.proceed();
            }
        });
        webView.loadUrl("https://awpcollector.rf.gd/awpcollectorquery.php?query=" + new String(Base64.encode(query.getBytes(StandardCharsets.UTF_8), Base64.DEFAULT)));
    }
}
