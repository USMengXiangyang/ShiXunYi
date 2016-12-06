package com.hhzmy.test;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class ZuceActivity extends AppCompatActivity {

    private EditText zuce_phone;
    private Button zuce_next;
    private ImageView zuce_back1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zuce);
        zuce_phone = (EditText) findViewById(R.id.zuce_phone);
        zuce_next = (Button) findViewById(R.id.zuce_next);
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

            }
        });
        zuce_back1 = (ImageView) findViewById(R.id.zuce_back1);
        zuce_back1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
}
