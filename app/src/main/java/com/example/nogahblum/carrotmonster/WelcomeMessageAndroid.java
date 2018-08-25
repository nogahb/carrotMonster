package com.example.nogahblum.carrotmonster;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;


public class WelcomeMessageAndroid extends AppCompatActivity {

    RelativeLayout introMessage;
    LinearLayout appContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome_message_android);

        Button button= (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startNextActivity();
            }
        });

    }

    private void startNextActivity() {
        Intent it = new Intent(WelcomeMessageAndroid.this, CreateMonsterActivity.class);
        startActivity(it);
    }
}
