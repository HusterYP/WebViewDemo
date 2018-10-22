package com.example.yuanping.webdemo;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ViewGroup;
import android.webkit.JavascriptInterface;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class JsActivity2 extends AppCompatActivity {

    private WebView mWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_js2);
        initView();
    }

    private void initView() {
        mWebView = findViewById(R.id.js_webview);
        mWebView.loadUrl("file:///android_asset/js_2.html");
        WebSettings settings = mWebView.getSettings();
        settings.setJavaScriptEnabled(true);
        mWebView.addJavascriptInterface(new AndroidToJs(), "test");
    }

    @Override
    protected void onDestroy() {
        if (mWebView != null) {
            mWebView.loadDataWithBaseURL(null, "", "text/html", "utf-8", null);
            mWebView.clearHistory();

            ((ViewGroup) mWebView.getParent()).removeView(mWebView);
            mWebView.destroy();
            mWebView = null;
        }
        super.onDestroy();
    }

    class AndroidToJs extends Object {

        /**
         * 注意该方法要带参数, 否则没有效果
         */
        @JavascriptInterface
        public void hello(String msg) {
            AlertDialog.Builder builder = new AlertDialog.Builder(JsActivity2.this);
            builder.setTitle("Js调用了Android方法");
            builder.setMessage("这是Android对话框");
            builder.setCancelable(true);
            builder.create().show();
        }
    }
}
