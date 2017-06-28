package com.dqs.kotlinnote.app;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

/**
 * 作者：Denqs on 2017/6/28.
 */

public class BaseApplication extends Application {
    public static Context context;
    public static BaseApplication instance;
    public static SharedPreferences sp;//当前用户的设置，针对不同用户

    public static Context getContext() {
        return instance;
    }

    public static BaseApplication getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        context = getApplicationContext();
        sp = this.getSharedPreferences("lock", MODE_PRIVATE);
    }
}
