package com.hhzmy.tools;

import android.graphics.Color;
import android.os.CountDownTimer;
import android.widget.Button;

/**
 * 作用：
 * 时间：2016/1124
 */
public class RegisterCodeTimer extends CountDownTimer {
    private Button btn_;

    public RegisterCodeTimer(long millisInFuture, long countDownInterval, Button btn) {
        super(millisInFuture, countDownInterval);// 参数依次为总时长,和计时的时间间隔
        this.btn_ = btn;
    }


    @Override
    public void onFinish() {// 计时完毕时触发
       btn_.setText("  重新发送");
        btn_.setEnabled(true);
        btn_.setTextColor(Color.parseColor("#CBCBCB"));
    }

    @Override
    public void onTick(long millisUntilFinished) {// 计时过程显示
        btn_.setText((millisUntilFinished / 1000) + "S");
        btn_.setEnabled(false);
    }

}
