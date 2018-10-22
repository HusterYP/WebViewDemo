package com.example.yuanping.webdemo;

import android.content.Context;

/**
 * @created by PingYuan at 10/22/18
 * @email: husteryp@gmail.com
 * @description:
 */
public class Application extends android.app.Application {
    public static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
    }
}
