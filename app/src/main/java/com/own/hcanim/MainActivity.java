package com.own.hcanim;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.iv_planet)
    PlanetLayout iv_planet;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        iv_planet.setListener(new PlanetLayout.PlanetListener() {
            @Override
            public void OnPlanetListener(Class<?> clazz) {

            }
        });

    }
}
