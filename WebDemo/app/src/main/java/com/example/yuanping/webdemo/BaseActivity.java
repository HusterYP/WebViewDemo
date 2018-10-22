package com.example.yuanping.webdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

/**
 * @created by PingYuan at 10/22/18
 * @email: husteryp@gmail.com
 * @description:
 */
public class BaseActivity extends AppCompatActivity {
    public void startActivity(Class clazz) {
        Intent intent = new Intent(this, clazz);
        startActivity(intent);
    }
}
