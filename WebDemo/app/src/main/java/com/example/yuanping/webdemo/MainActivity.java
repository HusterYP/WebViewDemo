package com.example.yuanping.webdemo;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        findViewById(R.id.load_baidu).setOnClickListener(this);
        findViewById(R.id.load_js_1).setOnClickListener(this);
        findViewById(R.id.load_js_2).setOnClickListener(this);
        findViewById(R.id.load_js_3).setOnClickListener(this);
        findViewById(R.id.load_js_4).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.load_baidu: {
                startActivity(BaiduActivity.class);
            }
            break;
            case R.id.load_js_1: {
                startActivity(JsActivity1.class);
            }
            break;
            case R.id.load_js_2: {
                startActivity(JsActivity2.class);
            }
            break;
            case R.id.load_js_3: {
                startActivity(JsActivity3.class);
            }
            break;
            case R.id.load_js_4: {
                startActivity(JsActivity4.class);
            }
            break;
            default:
                break;
        }
    }
}
