package com.example.traveller.common;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.traveller.R;
import com.example.traveller.user.Addtrips;
import com.example.traveller.user.MyTrips;

public class SplashScreen extends AppCompatActivity {

    private static final int SPLASH_Timer = 5000;
    //variables
    ImageView backgroundImage;
    TextView proverdByLine;

    //Variable for the user new or alredy in app


    //Animations
    Animation sideAnim, BottomAnim;
    SharedPreferences OnBoardingScreen;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        getWindow ().setFlags ( WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN );
        setContentView ( R.layout.activity_main );
        //hucks
        backgroundImage = findViewById ( R.id.background_image );
        proverdByLine = findViewById ( R.id.textView1 );

        //Animations
        sideAnim = AnimationUtils.loadAnimation ( this, R.anim.side_anim );
        BottomAnim = AnimationUtils.loadAnimation ( this, R.anim.bottem_anim );


        //set Animations on elements
        backgroundImage.setAnimation ( sideAnim );
        proverdByLine.setAnimation ( BottomAnim );
        //handleer for the controll dilay of


        new Handler ().postDelayed ( () -> {

            OnBoardingScreen = getSharedPreferences ( "OnBoardingScreen", MODE_PRIVATE );
            boolean isFirstTme = OnBoardingScreen.getBoolean ( "firstTime",true );

            if (isFirstTme) {
                SharedPreferences.Editor editor = OnBoardingScreen.edit ();
                editor.putBoolean ( "firstTime", false );
                editor.commit ();

                Intent intent = new Intent ( getApplicationContext (), OnBoarding.class );
                startActivity ( intent );
                finish ();//finish splash screen it does not  display it agin
            } else {
                Intent intent = new Intent ( getApplicationContext (), MyTrips.class );
                startActivity ( intent );
                finish ();
            }
        }, SPLASH_Timer );
    }
}
    
