package com.example.nogahblum.carrotmonster;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import com.google.gson.Gson;

public class ChooseFoodActivity extends AppCompatActivity {
    private EditText mName, mPassword;
    private SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_food);
        mName = (EditText) findViewById(R.id.good1);
        //after apply button
//        String name = mName.getText().toString();


    }

    private void save_monster(Monster monster){
        prefs = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = prefs.edit();
        Gson gson = new Gson();
        String json = gson.toJson(monster);
        editor.putString(Session.USER_NAME+"monster", json);
        editor.apply();
    }
}
