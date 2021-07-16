package com.example.goroster;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private static int SPLASH_SCREEN = 3000;


    // variable for animation
    Animation topAnim,botAnim;
    ImageView imageSplashScreen;
    TextView logo,slogan;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        //Animation
        topAnim = AnimationUtils.loadAnimation(this,R.anim.top_animation);
        botAnim = AnimationUtils.loadAnimation(this,R.anim.bot_animation);
        imageSplashScreen = findViewById(R.id.imageViewSplashScreen);
        logo = findViewById(R.id.textViewSplashScreen);
        slogan = findViewById(R.id.textViewSubSplasScreen);

        imageSplashScreen.setAnimation(topAnim);
        logo.setAnimation(botAnim);
        slogan.setAnimation(botAnim);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this,Login.class );
                startActivity(intent);
                finish();
            }
        },SPLASH_SCREEN);


    }
}