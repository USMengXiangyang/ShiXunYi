package com.example.fragmentdemo;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class FirstFragment extends Fragment {
    public static final String TAG = "FirstFragment";
    private View view;
    private TextView textView;
    private CallbackValue callbackValue;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment,container,false);
        textView = (TextView) view.findViewById(R.id.textview);
        Bundle name = getArguments();
        if (name!=null){
            textView.setText(name.getString("name"));
        }
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              /*  Intent intent = new Intent(getActivity(),OtherActivity.class);
                intent.putExtra("ksy","孟向阳");
                startActivity(intent);*/
                callbackValue.SendMessageValue("孟向阳");
            }
        });

        Log.e(TAG,"onCreateView");
        return view;
    }

    //定义接口。回调信息。
    public interface CallbackValue{
        public void SendMessageValue(String str);
    }

    //强转对象
    @Override
    public void onAttach(Context context) {
        Log.e(TAG,"onAttch");
        callbackValue = (CallbackValue) getActivity();
        super.onAttach(context);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        Log.e(TAG,"onCreate");
        super.onCreate(savedInstanceState);
    }
    @Override
    public void onSaveInstanceState(Bundle outState) {
        Log.e(TAG,"onSaveInstanceState");
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        Log.e(TAG,"onActivityCreated");
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onStart() {
        Log.e(TAG,"onStart");
        super.onStart();
    }

    @Override
    public void onResume() {
        Log.e(TAG,"onResume");
        super.onResume();
    }

    @Override
    public void onPause() {
        Log.e(TAG,"onPause");
        super.onPause();
    }

    @Override
    public void onStop() {
        Log.e(TAG,"onStop");
        super.onStop();
    }

    @Override
    public void onDestroyView() {
        Log.e(TAG,"onDestroyView");
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        Log.e(TAG,"onDestroy");
        super.onDestroy();
    }

    @Override
    public void onDetach() {
        Log.e(TAG,"onDetach");
        super.onDetach();
    }
}
