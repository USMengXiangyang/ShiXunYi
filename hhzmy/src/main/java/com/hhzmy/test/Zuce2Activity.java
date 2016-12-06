package com.hhzmy.test;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Zuce2Activity extends AppCompatActivity implements View.OnClickListener {

    private TextView phone;
    private ImageView zuce_back2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zuce2);
        Intent intent = getIntent();

        phone = (TextView) findViewById(R.id.phone);
        phone.setText("短信验证码已发送至"+intent.getStringExtra("phone"));
        zuce_back2 = (ImageView) findViewById(R.id.zuce_back2);
        zuce_back2.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.zuce_back2:
                break;
        }
    }
}
