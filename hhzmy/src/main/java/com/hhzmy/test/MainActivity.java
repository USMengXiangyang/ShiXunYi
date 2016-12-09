package com.hhzmy.test;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.widget.ImageView;

import com.hhzmy.twicelogin.TwiceLogin;
import com.umeng.analytics.MobclickAgent;

public class MainActivity extends AppCompatActivity {

    private int count = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        ImageView gpsImg = (ImageView) findViewById(R.id.gpsImg);
        handler.postDelayed(runnable, 2000);
        MobclickAgent.startWithConfigure(new MobclickAgent.UMAnalyticsConfig(MainActivity.this, "584657949f06fd18e4001b80", "mxy"));

        super.onCreate(savedInstanceState);
    }

    Handler handler = new Handler();
    Runnable runnable = new Runnable() {
        @Override
        public void run() {

            Intent intent = new Intent(MainActivity.this, HomeActivity.class);
            startActivity(intent);
            TwiceLogin.setLogin(MainActivity.this, true);
            finish();
        }
    };

    public void onResume() {
        super.onResume();
        MobclickAgent.onResume(this);
    }
    public void onPause() {
        super.onPause();
        MobclickAgent.onPause(this);
    }
}
