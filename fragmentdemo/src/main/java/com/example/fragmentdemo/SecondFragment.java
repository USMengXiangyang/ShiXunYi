package com.example.fragmentdemo;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * 作用：
 * 时间：2016/1124
 */
public class SecondFragment extends Fragment {
    public static final String TAG = "SecondFragment";
    private View view;


    /**
     * 加载自布局
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.secondfragment,container,false);
        Log.e(TAG,"onCreateView");
        return view;
    }

    @Override
    public void onAttach(Context context) {
        Log.e(TAG,"onAttach");
        super.onAttach(context);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        Log.e(TAG,"onSaveInstanceState");
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        Log.e(TAG,"onCreate");
        super.onCreate(savedInstanceState);
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
