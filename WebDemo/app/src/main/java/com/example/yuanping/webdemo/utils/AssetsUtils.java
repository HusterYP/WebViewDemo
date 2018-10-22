package com.example.yuanping.webdemo.utils;

import com.example.yuanping.webdemo.Application;

import java.io.IOException;
import java.io.InputStream;

/**
 * @created by PingYuan at 10/22/18
 * @email: husteryp@gmail.com
 * @description:
 */
public class AssetsUtils {
    public static String getRawFromAssets(String fileName) {
        try {
            InputStream inputStream = Application.context.getAssets().open(fileName);
            byte[] data = new byte[inputStream.available()];
            inputStream.read(data);
            inputStream.close();
            return new String(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
