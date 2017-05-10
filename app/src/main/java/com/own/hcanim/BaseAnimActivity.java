package com.own.hcanim;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.graphics.PointF;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class BaseAnimActivity extends AppCompatActivity {

    @BindView(R.id.iv_ball)
    ImageView iv_ball;
    @BindView(R.id.iv_ball_vertical)
    ImageView iv_ball_vertical;
    private int mHeight;
    private int mWeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_anim);
        ButterKnife.bind(this);
        WindowManager wm = this.getWindowManager();
        mHeight = wm.getDefaultDisplay().getHeight();
        mWeight = wm.getDefaultDisplay().getWidth();
    }

    @OnClick({R.id.iv_ball, R.id.iv_ball_vertical})
    public void doanim(View view) {
        switch (view.getId()) {
            case R.id.iv_ball:
//                rotateObjectAnimator(iv_ball,"rotationX", 1.0f, 2.0f, 500);
//                moreObjectAnimator(iv_ball, "hc", 1.0f, 2.0f, 500);
                propertyValuesHolder(iv_ball);
                break;
            case R.id.iv_ball_vertical:
//                valueAnimator(iv_ball_vertical);
                paowuxianValueAnimator(iv_ball_vertical);
                break;
        }


    }

    /**
     * ObjectAnimator实现简易动画
     *
     * @param view 目标view
     * @param name 只能是系统限定的 "scaleX","rotationX"....
     * @param startValue 初始值
     * @param endValue   结束值
     * @param time 动画持续时间
     */
    public void rotateObjectAnimator(View view, String name, float startValue, float endValue,int time) {
        ObjectAnimator.ofFloat(view, name, startValue, endValue)
                .setDuration(time)
                .start();
    }

    /**
     * ObjectAnimator实现多动画
     *
     * @param view       目标view
     * @param name       自定义动画名
     * @param startValue 初始值
     * @param endValue   结束值
     * @param time 动画持续时间
     */
    public void moreObjectAnimator(final View view, String name, float startValue, float endValue,int time) {
        ObjectAnimator anim = ObjectAnimator.ofFloat(view, name, startValue, endValue)
                .setDuration(time);
        anim.start();
        anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float anim = (Float) animation.getAnimatedValue();
                //自定义系统提供的动画样式
                view.setAlpha(anim);
                view.setScaleX(anim);
                view.setScaleY(anim);
            }
        });
    }

    /**
     * propertyValuesHolder实现同步多动画
     *
     * @param view
     */
    public void propertyValuesHolder(View view) {
        PropertyValuesHolder anim = PropertyValuesHolder.ofFloat("alpha", 1f, 0, 1f);
        PropertyValuesHolder anim1 = PropertyValuesHolder.ofFloat("scaleX", 1f, 0, 1f);
        PropertyValuesHolder anim2 = PropertyValuesHolder.ofFloat("scaleY", 1f, 0, 1f);
        ObjectAnimator.ofPropertyValuesHolder(view, anim, anim1, anim2).setDuration(500).start();
    }

    /**
     * ValueAnimator实现动画（自由落体）
     * @param view
     */
    public void valueAnimator(final View view) {
        final ValueAnimator anim = ValueAnimator.ofFloat(0, mHeight - view.getHeight());
        anim.setTarget(view);
        anim.setDuration(1000);
        anim.start();
        anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                view.setTranslationY((Float) animation.getAnimatedValue());
            }
        });
    }

    /**
     * ValueAnimator实现动画自定义动作 抛物线
     * @param view
     */
    public void paowuxianValueAnimator(final View view){
        final ValueAnimator anim = new ValueAnimator();
        anim.setDuration(1000);
        anim.setInterpolator(new LinearInterpolator());
        anim.setObjectValues(new PointF(0,0));
        anim.setEvaluator(new TypeEvaluator<PointF>() {
            @Override
            public PointF evaluate(float fraction, PointF startValue, PointF endValue) {
                PointF point = new PointF();
                point.x = 200 * fraction * 3;
                point.y = 0.5f * 200 * (fraction * 3) * (fraction * 3);
                return point;
            }
        });
        anim.start();
        anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                PointF pointF = (PointF)animation.getAnimatedValue();
                view.setTranslationY(pointF.y);
                view.setTranslationX(pointF.x);
            }
        });
    }

}
