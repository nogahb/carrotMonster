package com.example.nogahblum.carrotmonster;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.example.nogahblum.carrotmonster.Session;

import static com.example.nogahblum.carrotmonster.BaseActivity.session;


public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

//        if (session.isLoggedIn()) {
//            startNextActivity();
//        }

        if (false) { //TODO sweech to get info from session
            startNextActivity();
        }

        else {
            startRegisterActivity();
        }
    }

    private void startNextActivity() {
        Intent it = new Intent(LoginActivity.this, MainScreenActivity.class);
        startActivity(it);
        finish();
    }

    private void startRegisterActivity() {
        Intent it = new Intent(LoginActivity.this, WelcomeMessageAndroid.class);
        startActivity(it);
    }


}
