package com.hhzmy.test;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

/**
 * 作用：
 * 时间：2016/1124
 */
public class WorksSizeCheckUtil {

    private TextView button;
    private EditText[] editTexts;

    public WorksSizeCheckUtil(TextView button) {
        this.button = button;
    }

    public WorksSizeCheckUtil addAllEditText(EditText... editTexts) {
        this.editTexts = editTexts;
        initEditListener();
        return this;
    }


    private void initEditListener() {
        Log.i("TAG", "调用了遍历editext的方法");
        for (EditText editText : editTexts) {
            editText.addTextChangedListener(new textChange());
        }
    }

    private class textChange implements TextWatcher {

        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            if (checkAllEdit()) {
                Log.i("TAG", "所有edittext有值了");
//                mChangeListener.textChange(true);
                button.setEnabled(true);
            } else {
                button.setEnabled(false);
                Log.i("TAG", "有edittext没值了");
//                mChangeListener.textChange(false);
            }
        }

        @Override
        public void afterTextChanged(Editable editable) {
        }
    }

    /**
     * 检查所有的edit是否输入了数据
     *
     * @return
     */
    private boolean checkAllEdit() {
        for (EditText editText : editTexts) {
            if (!TextUtils.isEmpty(editText.getText() + "")) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }
}
