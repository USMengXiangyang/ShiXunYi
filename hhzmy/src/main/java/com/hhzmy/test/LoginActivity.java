package com.hhzmy.test;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    private ImageView log_back;
    private EditText user_phone;
    private EditText user_password;
    private RadioButton log_icon1;
    private EditText log_img_yan;
    private ImageView log_icon2;
    private Button my_bt_log;
    private ImageView qq;
    private ImageView weixin;
    private ImageView wangyi;
    private RadioButton zuce;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
        user_phone.addTextChangedListener(new PhoneTextWatcher(user_phone));

    }


    private void initView() {
        log_back = (ImageView) findViewById(R.id.log_back);
        log_back.setOnClickListener(this);
        user_phone = (EditText) findViewById(R.id.user_phone);
        user_password = (EditText) findViewById(R.id.user_password);
        log_icon1 = (RadioButton) findViewById(R.id.log_icon1);
        log_icon1.setOnClickListener(this);
        log_img_yan = (EditText) findViewById(R.id.log_img_yan);
        log_icon2 = (ImageView) findViewById(R.id.log_icon2);
        log_icon2.setOnClickListener(this);
        my_bt_log = (Button) findViewById(R.id.my_bt_login);
        my_bt_log.setOnClickListener(this);
        qq = (ImageView) findViewById(R.id.qq);
        qq.setOnClickListener(this);
        weixin = (ImageView) findViewById(R.id.weixin);
        weixin.setOnClickListener(this);
        wangyi = (ImageView) findViewById(R.id.wangyi);
        wangyi.setOnClickListener(this);
        zuce = (RadioButton) findViewById(R.id.zuce);
        zuce.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.log_back:
                Intent intent = new Intent(LoginActivity.this,HomeActivity.class);
                startActivity(intent);
                break;
            case R.id.log_icon1:
                break;
            case R.id.log_icon2:
                break;
            case R.id.zuce:
                Intent intent1 = new Intent(LoginActivity.this,ZuceActivity.class);
                startActivity(intent1);
                break;
            case R.id.my_bt_login:
               String str_userphone = user_phone.getText().toString().trim();
                Toast.makeText(LoginActivity.this, str_userphone, Toast.LENGTH_SHORT).show();
                break;
            case R.id.qq:
                break;
            case R.id.weixin:
                break;
            case R.id.wangyi:
                break;

        }
    }
}
