package com.example.terryma.hello;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

public class CrashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crash);

        Intent intent = getIntent();
        String message = intent.getStringExtra("AAA");

        if(message != null){
            TextView viewById = (TextView) findViewById(R.id.errView);
            viewById.setText(message);
            viewById.setMovementMethod(new ScrollingMovementMethod());
        }
    }
}
