package com.hhzmy.test;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class OtherActivity extends AppCompatActivity {

    private TextView name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other);
        name = (TextView) findViewById(R.id.namename);
        initdata();
    }

    private void initdata() {
        try {
            InputStream inputStream = getResources().getAssets().open("category.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
            StringBuffer stringBuffer = new StringBuffer();
            String str = null;
            while((str = br.readLine())!=null){
                stringBuffer.append(str);
            }
            name.setText(stringBuffer.toString());
            Log.e("meng",stringBuffer.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
