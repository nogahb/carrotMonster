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

import java.util.ArrayList;
import java.util.List;

public class ChooseFoodActivity extends AppCompatActivity {
    private EditText good1_e, good2_e,good3_e,bad1_e,bda2_e,bad3_e;
    private SharedPreferences prefs;
    private String type_m;
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_food);

        Intent intent = getIntent();

        type_m = intent.getStringExtra("KEY_StringName");
        Button Button_apply= (Button) findViewById(R.id.Aply);
        Button_apply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                good1_e= (EditText) findViewById(R.id.good1);
                String good1 = good1_e.getText().toString();
                good2_e= (EditText) findViewById(R.id.good2);
                String good2 = good2_e.getText().toString();
                good3_e= (EditText) findViewById(R.id.good3);
                String good3 = good3_e.getText().toString();

                bad1_e= (EditText) findViewById(R.id.bad1);
                String bad1 = bad1_e.getText().toString();
                bda2_e = (EditText) findViewById(R.id.bad2);
                String bad2 = bda2_e.getText().toString();
                bad3_e= (EditText) findViewById(R.id.bad3);
                String bad3 = bad3_e.getText().toString();

                ArrayList<String> good_list = new ArrayList<>();
                ArrayList<String> bad_list = new ArrayList<>();

                if (!(good1.equals(""))){
//                    Toast.makeText(ChooseFoodActivity.this,
//                            "OK", Toast.LENGTH_LONG).show();
                good_list.add(good1);}
                if (!(good2.equals(""))){
                    good_list.add(good2);}
                if (!(good3.equals(""))){
                    good_list.add(good3);}

                if (!(bad1.equals(""))){
                    bad_list.add(bad1);}
                if (!(bad2.equals(""))){
                    bad_list.add(bad2);}
                if (!(bad3.equals(""))){
                    bad_list.add(bad3);}

                    if ((bad_list.size() == 3) && (good_list.size() == 3)){
                Monster new_m = new Monster(good_list,bad_list,type_m);
                save_monster(new_m);
                Session.set_monster(new_m);
                        Toast.makeText(ChooseFoodActivity.this,
                                "OK", Toast.LENGTH_LONG).show();
                        startNextActivity();
                }
                else {
                        Toast.makeText(ChooseFoodActivity.this,
                                "Failed please fill all the fields above before continuing ", Toast.LENGTH_LONG).show();
                    }
            }
        });
    }

    private void save_monster(Monster monster){
        prefs = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = prefs.edit();
        Gson gson = new Gson();
        String json = gson.toJson(monster);
        editor.putString(Session.USER_NAME+"monster", json);
        editor.apply();
    }
    private void save_list(int[] l ){
        prefs = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = prefs.edit();
        Gson gson = new Gson();
        String json = gson.toJson(l);
        editor.putString(Session.USER_NAME+"monster", json);
        editor.apply();
    }
    private void startNextActivity() {

        Intent it = new Intent(ChooseFoodActivity.this, MainScreenActivity.class);
        startActivity(it);
    }

}
