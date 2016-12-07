package com.hhzmy.test;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Toast;

import com.hhzmy.view.Code;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;
import java.util.Map;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener, TextWatcher {

    private ImageView log_back;
    private EditText user_phone;
    private EditText user_password;
    private RadioButton log_icon1;
    private EditText log_img_yan;//文本框的值
    private ImageView log_icon2; //图标 //确定和刷新验证码
    private Button my_bt_log;
    private ImageView qq;
    private ImageView weixin;
    private ImageView wangyi;
    private RadioButton zuce;
    private String str_userphone;
    private String str_userpass;

    String getCode=null; //获取验证码的值

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
        str_userphone = user_phone.getText().toString().trim();
        str_userpass = user_password.getText().toString().trim();
        user_phone.addTextChangedListener(new PhoneTextWatcher(user_phone));


//        getCode=Code.getInstance().getCode(); //获取显示的验证码
        log_icon2.setImageBitmap(Code.getInstance().getBitmap());
        /*log_icon1.setImageRes(R.mipmap.icon_display,R.mipmap.icon_hidden,R.mipmap.icon_hidden);
        //设置开关的默认状态    true开启状态
        log_icon1.setToggleState(true);*/
        //设置开关的监听
        /*log_icon1.setOnToggleStateListener(new MyToggle.OnToggleStateListener() {
            @Override
            public void onToggleState(boolean state) {
                if(state){
                    Toast.makeText(getApplicationContext(), "开关开启", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "开关关闭", Toast.LENGTH_SHORT).show();
                }
            }
        });*/

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
                log_icon2.setImageBitmap(Code.getInstance().getBitmap());
                getCode=Code.getInstance().getCode();
                break;
            //注册图标
            case R.id.zuce:
                Intent intent1 = new Intent(LoginActivity.this, ZuceActivity.class);
                startActivity(intent1);
                break;
            //登陆按钮
            case R.id.my_bt_login:
                String  v_code=log_img_yan.getText().toString().trim();
                if(v_code==null||v_code.equals("")){
                    Toast.makeText(LoginActivity.this, "没有填写验证码", 2).show();
                }else if(!v_code.equals(getCode)){
                    Toast.makeText(LoginActivity.this, "验证码填写不正确", 2).show();
                }else{
                    Toast.makeText(LoginActivity.this, "操作成功", 2).show();
                }
                break;
            //第三方登陆
            case R.id.qq:
                UMShareAPI mShareAPI = UMShareAPI.get(LoginActivity.this );
                mShareAPI.getPlatformInfo(LoginActivity.this, SHARE_MEDIA.QQ, umAuthListener);
                break;
            case R.id.weixin:
                UMShareAPI mShareAPI1 = UMShareAPI.get(LoginActivity.this );
                mShareAPI1.getPlatformInfo(LoginActivity.this, SHARE_MEDIA.WEIXIN, umAuthListener);
                break;
            case R.id.wangyi:
                Log.e("****","微博登陆");
                UMShareAPI mShareAPI2 = UMShareAPI.get(LoginActivity.this );
                mShareAPI2.getPlatformInfo(LoginActivity.this, SHARE_MEDIA.SINA, umAuthListener);
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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data);

    }
}
