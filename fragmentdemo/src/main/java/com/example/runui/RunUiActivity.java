package com.example.runui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.fragmentdemo.R;

public class RunUiActivity extends AppCompatActivity {

    private TextView name;
    private RunUiActivity activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_run_ui);
        name = (TextView) findViewById(R.id.name);
        Button btn = (Button) findViewById(R.id.btn);
        activity=this;
       btn.setOnClickListener(new OnClickListenerImpl());
       /* btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Thread(){
                    @Override
                    public void run() {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                   name.setText("已经更新！！");
                            }
                        });
                        super.run();
                    }
                }.start();
            }
        });*/
    }
    private class OnClickListenerImpl implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(RunUiActivity.this,MyHandlerActivity.class);
            startActivity(intent);
            /*new Thread(){
                public void run() {
                    activity.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            name.setText("My name is mxy , number is 2016");
                        }
                    });
                };
            }.start();*/
        }
    }
}
