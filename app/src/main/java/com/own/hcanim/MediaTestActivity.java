package com.own.hcanim;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class MediaTestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media_test);
        // 插件vitamio框架检查是否可用
//        if (!LibsChecker.checkVitamioLibs(this)) {
//            return;
//        }
        final VideoView vv = (VideoView) findViewById(R.id.vv);
        vv.setVideoPath("http://192.168.1.20:8080/movie.mp4"); //设置播放路径
        vv.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                vv.start();
            }
        });
// 设置video的控制器
        vv.setMediaController(new MediaController(this));
    }
}
