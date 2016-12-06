package com.hhzmy.test;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Toast;

import com.umeng.analytics.social.UMSocialService;
import com.umeng.socialize.SocializeException;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;

import java.util.Map;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener, TextWatcher {

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
    private String str_userphone;
    private String str_userpass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
        str_userphone = user_phone.getText().toString().trim();
        str_userpass = user_password.getText().toString().trim();
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
        user_phone.addTextChangedListener(this);
        user_password.addTextChangedListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            //返回图标
            case R.id.log_back:
                Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                startActivity(intent);
                break;
            //密码图标
            case R.id.log_icon1:
                break;
            //动态验证码
            case R.id.log_icon2:
                break;
            //注册图标
            case R.id.zuce:
                Intent intent1 = new Intent(LoginActivity.this, ZuceActivity.class);
                startActivity(intent1);
                break;
            //登陆按钮
            case R.id.my_bt_login:

                break;
            //第三方登陆
            case R.id.qq:
                UMShareAPI mShareAPI = UMShareAPI.get(LoginActivity.this );
                mShareAPI.doOauthVerify(LoginActivity.this, SHARE_MEDIA.QQ, umAuthListener);
                break;
            case R.id.weixin:
                UMShareAPI mShareAPI1 = UMShareAPI.get(LoginActivity.this );
                mShareAPI1.doOauthVerify(LoginActivity.this, SHARE_MEDIA.WEIXIN, umAuthListener);
                break;
            case R.id.wangyi:
                break;

        }
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        if (str_userphone != null && str_userpass != null) {
            my_bt_log.setBackground(getResources().getDrawable(R.drawable.bg_edittext_selecter));
        }
    }

    @Override
    public void afterTextChanged(Editable editable) {

    }

    private UMAuthListener umAuthListener = new UMAuthListener() {
        @Override
        public void onComplete(SHARE_MEDIA platform, int action, Map<String, String> data) {
            Toast.makeText(getApplicationContext(), "Authorize succeed", Toast.LENGTH_SHORT).show();

        }

        @Override
        public void onError(SHARE_MEDIA platform, int action, Throwable t) {
            Toast.makeText( getApplicationContext(), "Authorize fail", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onCancel(SHARE_MEDIA platform, int action) {
            Toast.makeText( getApplicationContext(), "Authorize cancel", Toast.LENGTH_SHORT).show();
        }
    };

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
