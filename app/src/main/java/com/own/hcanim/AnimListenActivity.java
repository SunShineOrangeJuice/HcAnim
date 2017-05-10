package com.own.hcanim;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AnimListenActivity extends AppCompatActivity {

    @BindView(R.id.iv_ball)
    ImageView iv_ball;

    private static final String TAG = AnimListenActivity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anim_listen);
        ButterKnife.bind(this);


    }
    @OnClick(R.id.iv_ball)
    public void animlisten(View view){
        ObjectAnimator anim = ObjectAnimator.ofFloat(view,"rotationX",1.0F,180.0F);
        anim.setDuration(1000);
        anim.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                Log.i(TAG,"动画初始");
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                ViewGroup parent = (ViewGroup) iv_ball.getParent();
                if (parent != null)
                    parent.removeView(iv_ball);
                Toast.makeText(AnimListenActivity.this,"动画执行结束，执行删除操作",Toast.LENGTH_SHORT).show();
                Log.i(TAG,"动画结束");
            }

            @Override
            public void onAnimationCancel(Animator animation) {
                Log.i(TAG,"动画取消");
            }

            @Override
            public void onAnimationRepeat(Animator animation) {
                Log.i(TAG,"动画重新播放");
            }
        });
        anim.start();
    }
}
