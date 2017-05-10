package com.own.hcanim;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RotateAnimActivity extends AppCompatActivity {

    @BindView(R.id.iv_mars)
    ImageView iv_mars;

    @BindView(R.id.iv_moon)
    ImageView iv_moon;

    @BindView(R.id.iv_venus)
    ImageView iv_venus;

    @BindView(R.id.iv_ball)
    ImageView iv_ball;

    private boolean flag;
    private static long lastClickTime = 0;//上次点击的时间

    private static int spaceTime = 500;//时间间隔


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rotate_anim);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.iv_ball)
    public void click(View view) {
        if (isFastClick()) {
            return;
        } else {
            if (!flag) {
                BigToNormal(view);
                mars(iv_mars);
                moon(iv_moon);
                venus(iv_venus);
                flag = true;
            } else {
                BigToNormal(view);
                playTogether(iv_mars);
                playTogether(iv_moon);
                playTogether(iv_venus);
                flag = false;
            }

        }


    }
    /**
     * 放大恢复
     *
     * @param view
     */
    public void BigToNormal(View view) {
        ObjectAnimator anim = ObjectAnimator.ofFloat(view, "scaleX", 1.0F, 1.2F,1.0F);
        ObjectAnimator anim2 = ObjectAnimator.ofFloat(view, "scaleY", 1.0F, 1.2F,1.0F);
        AnimatorSet animSet = new AnimatorSet();
        animSet.setDuration(300);
        animSet.setInterpolator(new LinearInterpolator());
        animSet.setTarget(view);
        animSet.playTogether(anim, anim2);
        animSet.start();
    }

    /**
     * 放大渐变消失
     *
     * @param view
     */
    public void playTogether(View view) {
        ObjectAnimator anim = ObjectAnimator.ofFloat(view, "scaleX", 0.8F, 1.0F);
        ObjectAnimator anim2 = ObjectAnimator.ofFloat(view, "scaleY", 0.8F, 1.0F);
        ObjectAnimator anim3 = ObjectAnimator.ofFloat(view, "alpha", 1.0F, 0);
        AnimatorSet animSet = new AnimatorSet();
        animSet.setDuration(500);
        animSet.setInterpolator(new LinearInterpolator());
        animSet.setTarget(view);
        animSet.playTogether(anim, anim2, anim3);
        animSet.start();
    }

    /**
     * mars
     *
     * @param view
     */
    public void mars(final View view) {
        float y = iv_ball.getY();
        ObjectAnimator anim = ObjectAnimator.ofFloat(view, "alpha", 0.0f, 1.0f);
        ObjectAnimator anim2 = ObjectAnimator.ofFloat(view, "rotation", 0, 380);
        ObjectAnimator anim3 = ObjectAnimator.ofFloat(view, "y", y, y - 250);
        ObjectAnimator anim4 = ObjectAnimator.ofFloat(view, "scaleX", 0f, 0.8f);
        ObjectAnimator anim5 = ObjectAnimator.ofFloat(view, "scaleY", 0f, 0.8f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(500);
        animatorSet.setInterpolator(new AccelerateDecelerateInterpolator());
        animatorSet.play(anim).with(anim2);
        animatorSet.play(anim2).with(anim3);
        animatorSet.play(anim3).with(anim4);
        animatorSet.play(anim4).with(anim5);
        animatorSet.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {

            }

            @Override
            public void onAnimationEnd(Animator animator) {
                ObjectAnimator anim7 = ObjectAnimator.ofFloat(view, "rotation", 20, 0);
                anim7.setDuration(100);
                anim7.start();
            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });

        animatorSet.start();
    }

    /**
     * moon
     *
     * @param view
     */
    public void moon(final View view) {
        float y = iv_ball.getY();
        float x = iv_ball.getX();
        ObjectAnimator anim = ObjectAnimator.ofFloat(view, "alpha", 0.0f, 1.0f);
        ObjectAnimator anim2 = ObjectAnimator.ofFloat(view, "rotation", 0, 380);
        ObjectAnimator anim3 = ObjectAnimator.ofFloat(view, "y", y, y - 170);
        ObjectAnimator anim4 = ObjectAnimator.ofFloat(view, "scaleX", 0f, 0.8f);
        ObjectAnimator anim5 = ObjectAnimator.ofFloat(view, "scaleY", 0f, 0.8f);
        ObjectAnimator anim6 = ObjectAnimator.ofFloat(view, "x", x, x - 170);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(500);
        animatorSet.setInterpolator(new AccelerateDecelerateInterpolator());
        animatorSet.play(anim).with(anim2);
        animatorSet.play(anim2).with(anim3);
        animatorSet.play(anim3).with(anim4);
        animatorSet.play(anim4).with(anim5);
        animatorSet.play(anim5).with(anim6);
        animatorSet.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {

            }

            @Override
            public void onAnimationEnd(Animator animator) {
                ObjectAnimator anim7 = ObjectAnimator.ofFloat(view, "rotation", 20, 0);
                anim7.setDuration(100);
                anim7.start();
            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });

        animatorSet.start();
    }

    /**
     * venus
     *
     * @param view
     */
    public void venus(final View view) {
        float y = iv_ball.getY();
        float x = iv_ball.getX();
        ObjectAnimator anim = ObjectAnimator.ofFloat(view, "alpha", 0.0f, 1.0f);
        ObjectAnimator anim2 = ObjectAnimator.ofFloat(view, "rotation", 0, 380);
        ObjectAnimator anim4 = ObjectAnimator.ofFloat(view, "scaleX", 0f, 0.8f);
        ObjectAnimator anim5 = ObjectAnimator.ofFloat(view, "scaleY", 0f, 0.8f);
        ObjectAnimator anim6 = ObjectAnimator.ofFloat(view, "x", x, x - 250);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(500);
        animatorSet.setInterpolator(new AccelerateDecelerateInterpolator());
        animatorSet.play(anim).with(anim2);
        animatorSet.play(anim2).with(anim6);
        animatorSet.play(anim6).with(anim4);
        animatorSet.play(anim4).with(anim5);
        animatorSet.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {

            }

            @Override
            public void onAnimationEnd(Animator animator) {
                ObjectAnimator anim7 = ObjectAnimator.ofFloat(view, "rotation", 20, 0);
                anim7.setDuration(100);
                anim7.start();
            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });

        animatorSet.start();
    }


    public static boolean isFastClick() {

        long currentTime = System.currentTimeMillis();//当前系统时间
        boolean isAllowClick;//是否允许点击
        if (currentTime - lastClickTime > spaceTime) {
            isAllowClick = false;
        } else {
            isAllowClick = true;
        }
        lastClickTime = currentTime;
        return isAllowClick;

    }


}
