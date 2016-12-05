package com.hhzmy.test;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Zuce2Activity extends AppCompatActivity {

    private TextView phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zuce2);
        Intent intent = getIntent();
        phone = (TextView) findViewById(R.id.phone);
        phone.setText("短信验证码已发送至"+intent.getStringExtra("phone"));

    }
}
