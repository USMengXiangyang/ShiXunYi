package com.example.fragmentdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class OtherActivity extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other);
        textView = (TextView) findViewById(R.id.textValue);
        Intent intent = getIntent();
        textView.setText(intent.getStringExtra("ksy"));
    }


}
