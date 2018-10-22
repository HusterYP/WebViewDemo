package com.example.yuanping.webdemo;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.JsResult;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;

/**
 * Android调用Js
 */
public class JsActivity1 extends AppCompatActivity implements View.OnClickListener {

    private WebView mWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_js1);
        initView();
    }

    private void initView() {
        findViewById(R.id.js_android_load_js_1).setOnClickListener(this);
        findViewById(R.id.js_android_load_js_2).setOnClickListener(this);
        mWebView = findViewById(R.id.js_webview);
        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true);
        mWebView.loadUrl("file:///android_asset/js_1.html"); // 注意Assets目录下文件路径
        mWebView.setWebChromeClient(new WebChromeClient() {
            @Override
            public boolean onJsAlert(WebView view, String url, String message, final JsResult
                    result) {
                AlertDialog.Builder builder = new AlertDialog.Builder(JsActivity1.this);
                builder.setPositiveButton(android.R.string.ok, new DialogInterface
                        .OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        result.confirm();
                    }
                });
                builder.setTitle("Alert");
                builder.setMessage(message);
                builder.setCancelable(false);
                builder.create().show();
                return true;
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.js_android_load_js_1: {
                mWebView.post(new Runnable() {
                    @Override
                    public void run() {
                        mWebView.loadUrl("javascript:callJS();");
                    }
                });
            }
            break;
            case R.id.js_android_load_js_2: {
                mWebView.evaluateJavascript("javascript:callJS();", new ValueCallback<String>() {
                    @Override
                    public void onReceiveValue(String value) {
                        Log.d("@HusterYP", String.valueOf(value));
                    }
                });
            }
            break;
            default:
                break;
        }
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
}
