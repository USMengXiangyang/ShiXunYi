package com.hhzmy.test;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.SpannedString;
import android.text.method.LinkMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.text.style.URLSpan;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class ZuceActivity extends AppCompatActivity {

    private EditText zuce_phone;
    private Button zuce_next;
    private ImageView zuce_back1;
    private CheckBox checkBox;
    private SpannedString ss;
    private TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zuce);
        initView();
        zuce_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phone = zuce_phone.getText().toString().trim();
                if (phone.equals("")) {
                    System.out.println("不能为空！！");
                } else {
                    Intent intent = new Intent(ZuceActivity.this, Zuce2Activity.class);
                    intent.putExtra("phone", phone);
                    startActivity(intent);
                }
                //初始化
                cn.smssdk.SMSSDK.initSDK(ZuceActivity.this, "19a1dfb34900e", "afd2cd716a3c44ea4d16010f8df066f9");
                //发送短信
                cn.smssdk.SMSSDK.getVerificationCode("86",phone);

            }
        });
        zuce_back1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        span();
    }

    //字体变化
    private void span() {
        SpannableString ss = new SpannableString("同意苏宁易购会员章程和易付宝协议");
        //设置颜色文本
        ss.setSpan(new ForegroundColorSpan(Color.GREEN), 2, 10, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        ss.setSpan(new ForegroundColorSpan(Color.YELLOW), 11, 14, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        //设置下划线
        ss.setSpan(new UnderlineSpan(), 2, 10,
                Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        ss.setSpan(new UnderlineSpan(), 11, 14,
                Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        //设置超链接
        ss.setSpan(new URLSpan("https://www.baidu.com/"), 2, 10, Spanned.SPAN_EXCLUSIVE_INCLUSIVE);
        ss.setSpan(new URLSpan(""), 11, 14, Spanned.SPAN_EXCLUSIVE_INCLUSIVE);
        text.setText(ss);
        text.setMovementMethod(new LinkMovementMethod());
    }

    private void initView() {
        zuce_phone = (EditText) findViewById(R.id.zuce_phone);
        zuce_next = (Button) findViewById(R.id.zuce_next);
        zuce_back1 = (ImageView) findViewById(R.id.zuce_back1);
        checkBox = (CheckBox) findViewById(R.id.checkall);
        text = (TextView) findViewById(R.id.checText);
    }
}
