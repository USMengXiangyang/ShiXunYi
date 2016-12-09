package com.hhzmy.dataneturl;

import android.app.Application;

import com.hhzmy.test.R;
import com.iflytek.cloud.SpeechConstant;
import com.iflytek.cloud.SpeechUtility;
import com.nostra13.universalimageloader.cache.disc.impl.UnlimitedDiskCache;
import com.nostra13.universalimageloader.cache.memory.impl.UsingFreqLimitedMemoryCache;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.umeng.socialize.PlatformConfig;
import com.umeng.socialize.UMShareAPI;

import cn.jpush.android.api.JPushInterface;


/**
 * Created by asus on 2016/11/9.
 */
public class DataImageLoader extends Application {
    {
//        Config.DEBUG=true;
        PlatformConfig.setWeixin("wx967daebe835fbeac", "5bb696d9ccd75a38c8a0bfe0675559b3");
        PlatformConfig.setSinaWeibo("584657949f06fd18e4001b80", "04b48b094faeb16683c32669824ebdad");
        PlatformConfig.setQQZone("100424468", "c7394704798a158208a74ab60104f0ba");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        SetImage();
        //umeng分享
        UMShareAPI.get(this);
        //极客推送
        JPushInterface.setDebugMode(true);
        JPushInterface.init(this);
        //讯飞语音听写
        SpeechUtility.createUtility(getApplicationContext(), SpeechConstant.APPID+"=584a655b");
    }

    private void SetImage() {
        DisplayImageOptions options = new DisplayImageOptions.Builder()
                .cacheInMemory(true).cacheOnDisc(true)
                .showImageOnFail(R.mipmap.ic_launcher)
                .showImageOnFail(R.mipmap.ic_launcher).considerExifParams(true)
                .showImageOnLoading(R.mipmap.ic_launcher).build();
        int max = (int) (Runtime.getRuntime().maxMemory() / 8);
        ImageLoaderConfiguration configuration = new ImageLoaderConfiguration.Builder(
                getApplicationContext())
                .memoryCache(new UsingFreqLimitedMemoryCache(max))
                .discCache(new UnlimitedDiskCache(getCacheDir()))
                .threadPoolSize(3).threadPriority(Thread.NORM_PRIORITY - 1)
                .defaultDisplayImageOptions(options).build();
        ImageLoader.getInstance().init(configuration);
    }
}
