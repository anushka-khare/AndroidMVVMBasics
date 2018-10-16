package com.example.daffodil_43.learningproject;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class MainActivity extends AppCompatActivity {


    @BindView(R.id.welcome_txt)
    public TextView welcomeTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initializeView();



    }


    private void initializeView()
    {
        welcomeTxt.setText(R.string.hello_world);
    }


    @OnClick(R.id.welcome_txt)
    public void onClickText()
    {
        new Thread(new Runnable() {
            @Override
            public void run() {
                welcomeTxt.post(new Runnable() {
                    @Override
                    public void run() {
                        ObjectAnimator animation = ObjectAnimator.ofFloat(welcomeTxt,  "rotation", 360f, 0f);
                        animation.setDuration(1000);
                        animation.start();
                    }
                });

            }
        }).start();


    }
}
