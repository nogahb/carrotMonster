package com.example.nogahblum.carrotmonster;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;


public class LoginActivity extends AppCompatActivity {
    private Boolean isLogin;
    private EditText mName, mPassword;


    private SharedPreferences prefs;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
//        my_session = new Session(this);
        mName = (EditText) findViewById(R.id.user_name);
        mPassword = (EditText) findViewById(R.id.editText2_password__register);
        prefs = PreferenceManager.getDefaultSharedPreferences(this);



//        if (session.isLoggedIn()) {
//            startNextActivity();
//        }

        Button loginButton= (Button) findViewById(R.id.loginButton);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String password = mPassword.getText().toString();
                String name = mName.getText().toString();
//                isLogin = session.isLoggedIn(name,password);
                isLogin = isLoggedIn(name,password);
//                session.logOut();
//                startNextActivity();

             if (isLogin){
                 Session.setUserName(name);
                 Monster uset_monster = get_monster(name);
                 Session.set_monster(uset_monster);
                 startNextActivity();

             }
                else{
//                    //todo toast failed
                    Toast.makeText(LoginActivity.this,
                            "Failed to log in", Toast.LENGTH_LONG).show();
                }
            }
        });

        Button registerButton= (Button) findViewById(R.id.Next_register);
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startRegisterActivity();
            }
        });



//        if (isLogin) { //TODO switch to get info from session
//            startNextActivity();
//        }
//
//        else {
//            startRegisterActivity();
//        }
    }

    private void startNextActivity() {
        Intent it = new Intent(LoginActivity.this, MainScreenActivity.class);
        startActivity(it);
        finish();
    }

    private void startRegisterActivity() {
        Intent it = new Intent(LoginActivity.this, WelcomeMessageAndroid.class);
        startActivity(it);
        finish();
    }

    public Boolean isLoggedIn(String user,String pass_word){
        String a = prefs.getString(user, "1");
        return a.equals(pass_word);
    }
    private Monster get_monster(String name){
        Gson gson = new Gson();
        String json = prefs.getString(name+"monster", "");
        Monster obj = gson.fromJson(json, Monster.class);
        return obj;
    }

}
