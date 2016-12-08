package com.hhzmy.test;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.hhzmy.tools.RegisterCodeTimer;

public class Zuce2Activity extends AppCompatActivity {

    private TextView phone;
    private ImageView zuce_back2;
    private Button btn_;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zuce2);
        Intent intent = getIntent();

        phone = (TextView) findViewById(R.id.phone);
        phone.setText("短信验证码已发送至"+intent.getStringExtra("phone"));
        zuce_back2 = (ImageView) findViewById(R.id.zuce_back2);
        btn_ = (Button) findViewById(R.id.btn_);
        //倒计时
        new RegisterCodeTimer(60000,1000,btn_).start();
    }

    @Override
    protected void onDestroy() {
        // TODO Auto-generated method stub
        super.onDestroy();

    }


}
