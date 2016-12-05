package com.hhzmy.test;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ZuceActivity extends AppCompatActivity {

    private EditText zuce_phone;
    private Button zuce_next;

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
                Intent intent = new Intent(ZuceActivity.this,Zuce2Activity.class);
                intent.putExtra("phone",phone);
                startActivity(intent);
            }
        });
        if(zuce_phone.getText().toString().trim().length()==11){
            zuce_next.setBackgroundColor(Color.YELLOW);
        }
    }
}
