package com.example.nogahblum.carrotmonster;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;


public class WelcomeMessageAndroid extends AppCompatActivity {

    RelativeLayout introMessage;
    LinearLayout appContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome_message_android);

        introMessage = (RelativeLayout) findViewById(R.id.welcome_message_layout);
        appContent = (LinearLayout) findViewById(R.id.app_content_layout);
    }

    public void dismisWelcomeMessageBox(View view) {
        introMessage.setVisibility(View.INVISIBLE);
        appContent.setVisibility(View.VISIBLE);

    }
}
