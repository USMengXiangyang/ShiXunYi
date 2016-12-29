package com.mxy.www;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private final String ACTION_NAME = "发送广播";
    private Button mBtnMsgEvent = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //注册广播
        registerBoradcastReceiver();

        LinearLayout mLinearLayout = new LinearLayout(this);
        mBtnMsgEvent = new Button(this);
        mBtnMsgEvent.setText("发送广播");
        mLinearLayout.addView(mBtnMsgEvent);
        setContentView(mLinearLayout);

        mBtnMsgEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mIntent = new Intent(ACTION_NAME);
                mIntent.putExtra("yaner", "发送广播，相当于在这里传送数据");

                //发送广播
                sendBroadcast(mIntent);
            }
        });
    }
    private BroadcastReceiver mBroadcastReceiver = new BroadcastReceiver(){
        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if(action.equals(ACTION_NAME)){
                Toast.makeText(MainActivity.this, "处理action名字相对应的广播", Toast.LENGTH_SHORT).show();
            }
        }

    };
    public void registerBoradcastReceiver(){
        IntentFilter myInter = new IntentFilter();
        myInter.addAction(ACTION_NAME);
        //注册广播
        registerReceiver(mBroadcastReceiver,myInter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(mBroadcastReceiver);
    }
}
