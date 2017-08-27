package com.example.alinamurmur.myprojektiswork;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Alina on 01.07.2017.
 */

public class SplashActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Thread logoTimer = new Thread()
        {
            public void run()
            {
                try
                {
                    int logoTimer = 0;
                    while(logoTimer < 1000)
                    {
                        sleep(100);
                        logoTimer = logoTimer +100;
                    };
                 //   startActivity(new Intent("com.example.alinamurmur.myprojektiswork.MainActivity"));
                }
                catch (InterruptedException e)
                {
                    // TODO: автоматически сгенерированный блок catch.
                    e.printStackTrace();
                }
                finally
                {
                    Intent intent = new Intent(getBaseContext(), MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        };
        logoTimer.start();
/**
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();**/
    }
}
