package com.own.hcanim;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationSet;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CombinationAnimActivity extends AppCompatActivity {

    @BindView(R.id.iv_ball)
    ImageView iv_ball;
    @BindView(R.id.iv_ball_alpha)
    ImageView iv_ball_alpha;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_combination_anim);
        ButterKnife.bind(this);
    }
    @OnClick({R.id.iv_ball,R.id.iv_ball_alpha})
    public void together(View view){
        switch (view.getId()){
            case R.id.iv_ball:
                playTogether(view);
                break;
            case R.id.iv_ball_alpha:
                playWithAfter(view);
                break;
        }

    }

    /**
     * 同步执行动画
     * @param view
     */
    public void playTogether(View view){
        ObjectAnimator anim = ObjectAnimator.ofFloat(view,"scaleX",1.0F,2.0F);
        ObjectAnimator anim2 = ObjectAnimator.ofFloat(view,"scaleY",1.0F,2.0F);
        ObjectAnimator anim3 = ObjectAnimator.ofFloat(view,"alpha",1.0F,0);
        AnimatorSet animSet = new AnimatorSet();
        animSet.setDuration(1000);
        animSet.setInterpolator(new LinearInterpolator());
        animSet.setTarget(view);
        animSet.playTogether(anim,anim2,anim3);
        animSet.start();
    }

    /**
     * 多动画顺序执行
     * @param view
     */
    public void playWithAfter(View view)
    {
        float cx = view.getX();

        ObjectAnimator anim1 = ObjectAnimator.ofFloat(view, "scaleX",
                1.0f, 2f);
        ObjectAnimator anim2 = ObjectAnimator.ofFloat(view, "scaleY",
                1.0f, 2f);
        ObjectAnimator anim3 = ObjectAnimator.ofFloat(view,
                "x",  cx ,  0f);
        ObjectAnimator anim4 = ObjectAnimator.ofFloat(view,
                "x", cx);

        /**
         * anim1，anim2,anim3同时执行
         * anim4接着执行
         */
        AnimatorSet animSet = new AnimatorSet();
        animSet.play(anim1).with(anim2);
        animSet.play(anim2).with(anim3);
        animSet.play(anim4).after(anim3);
        animSet.setDuration(1000);
        animSet.start();
    }

}
