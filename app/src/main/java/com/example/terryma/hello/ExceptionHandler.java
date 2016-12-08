package com.example.terryma.hello;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.socks.library.KLog;

/**
 * Created by terryma on 16/12/6.
 */
public class ExceptionHandler implements Thread.UncaughtExceptionHandler {
    private AppCompatActivity baseActivity;

    public ExceptionHandler(LoginActivity loginActivity) {
        baseActivity = loginActivity;
    }

    @Override
    public void uncaughtException(Thread thread, Throwable throwable) {
        String stackTraceString = Log.getStackTraceString(throwable);
        KLog.e(stackTraceString);

        Intent crashedIntent = new Intent(baseActivity.getApplicationContext(), CrashActivity.class);
        crashedIntent.putExtra("AAA",  stackTraceString);
        crashedIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);
        crashedIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        baseActivity.startActivity(crashedIntent);

        System.exit(0);
    }
}
