package com.github.saiaaaaaaa.awpcollectormain;

import android.content.Context;
import android.net.http.SslError;
import android.util.Base64;
import android.webkit.SslErrorHandler;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import java.nio.charset.StandardCharsets;

public class AWPCollectorGet {
    WebView webView;

    public AWPCollectorGet(Context context) {
        webView = new WebView(context);
    }

    public void execute(String query, ValueCallback<String> valueCallback) {
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
                handler.proceed();
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                view.evaluateJavascript("document.getElementsByTagName('body')[0].innerHTML;", valueCallback);
            }
        });
        webView.loadUrl("https://awpcollector.rf.gd/awpcollectorget.php?get=" + new String(Base64.encode(query.getBytes(StandardCharsets.UTF_8), Base64.DEFAULT)));
    }
}
