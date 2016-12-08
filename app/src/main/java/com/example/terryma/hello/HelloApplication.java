package com.example.terryma.hello;

import android.app.Application;

import com.socks.library.KLog;

/**
 * 继承Application类，在AndroidManifest.xml中指定 android:name=".HelloApplication"
 * Created by terryma on 16/12/7.
 */

public class HelloApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        //初始化Log,根据DEBUG是否为true，自动控制是否打印日志
        KLog.init(BuildConfig.DEBUG, "HelloLog");
    }
}
