package com.example.fragmentdemo;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.View;
import android.widget.Button;
/**
 * autour: 孟向阳
 * date: 2016/11/29 18:28 
 * update: 2016/11/29
 */

public class MainActivity extends FragmentActivity implements View.OnClickListener,FirstFragment.CallbackValue{
   public static final String TAG="MainActivity";
    private Button btn;
    private FirstFragment first;
    private Button hide;
    private Button replace;
    private Button show;
    private Button add;
    private FragmentTransaction transaction;
    private FragmentManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initview();
        hide.setOnClickListener(this);
        btn.setOnClickListener(this);
        replace.setOnClickListener(this);
        show.setOnClickListener(this);
        add.setOnClickListener(this);

    }

    private void initview() {
        hide = (Button) findViewById(R.id.hide_fragment);
        btn = (Button) findViewById(R.id.add_fragment);
        replace = (Button)findViewById(R.id.replace_other);
        show = (Button)findViewById(R.id.show_firstfragment);
        add = (Button)findViewById(R.id.add_other);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e(TAG,"onStart");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e(TAG,"onRestart");
    }

    @Override
    protected void onResume() {
        Log.e(TAG,"onResume");
        super.onResume();
    }

    @Override
    protected void onPause() {
        Log.e(TAG,"onPause");
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.e(TAG,"onStop");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.e(TAG,"onDestroy");
        super.onDestroy();
    }

    @Override
    public void onClick(View view) {
        manager = getSupportFragmentManager();
        transaction = manager.beginTransaction();
        switch (view.getId()){
            case R.id.add_fragment:
                first = new FirstFragment();
                Bundle bundle = new Bundle();
                String name = btn.getText().toString().trim();
                bundle.putString("name",name);
                first.setArguments(bundle);
                transaction.add(R.id.fl,first);
                break;
            case R.id.hide_fragment:
                transaction.hide(first);
                break;
            case R.id.replace_other:
                SecondFragment secondFragment = new SecondFragment();
                transaction.replace(R.id.fl,secondFragment);
                break;
            case R.id.show_firstfragment:
                transaction.show(first);
                break;
            case R.id.add_other:
                SecondFragment secondFragment2 = new SecondFragment();
                transaction.add(R.id.fl,secondFragment2);
                break;
            default:
                break;
        }
        transaction.commit();
    }

    @Override
    public void SendMessageValue(String str) {
        btn.setText(str);
    }
}
