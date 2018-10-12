package com.example.nogahblum.carrotmonster;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class RgisterActivity extends AppCompatActivity {
    private EditText mName, mPassword;
    private SharedPreferences prefs;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rgister);
        mName = (EditText) findViewById(R.id.user_name);
        mPassword = (EditText) findViewById(R.id.editText2_password__register);
        prefs = PreferenceManager.getDefaultSharedPreferences(this);
//        SharedPreferences.Editor editor = prefs.edit();
//        logOut();


        final Button registerinButton= (Button) findViewById(R.id.loginButton_register);
        registerinButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String password = mPassword.getText().toString();
                String name = mName.getText().toString();
                if (isussernamefree(name)){
                register(name,password);
                    Toast.makeText(RgisterActivity.this,
                            "Registered", Toast.LENGTH_LONG).show();
                    startNextActivity(name);
                }


                else{
                    Toast.makeText(RgisterActivity.this,
                            "User name taken", Toast.LENGTH_LONG).show();
                }


//                isLogin = session.isLoggedIn(name,password);
//                session.logOut();
//                startNextActivity();


            }
        });


//        Button registerButton_n= (Button) findViewById(R.id.Next_register);
//        registerButton_n.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//            }
//        });

    }

    public void register(String user_mane,String passvord) {
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(user_mane, passvord);
        editor.apply();
    }

    private void startNextActivity(String user) {
        Intent it = new Intent(RgisterActivity.this, CreateMonsterActivity.class);
        startActivity(it);
        Session.setUserName(user);
        finish();
    }
    public void logOut() {
        SharedPreferences.Editor editor = prefs.edit();
        editor.clear();
        editor.apply();
    }

    public Boolean isussernamefree(String user){
        String a = prefs.getString(user, "1");
        return a.equals("1");
    }
}
