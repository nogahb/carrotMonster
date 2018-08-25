package com.example.nogahblum.carrotmonster;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CreateMonsterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_monster);

        Button button= (Button) findViewById(R.id.createMe);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startNextActivity();
            }
        });

    }

    private void startNextActivity() {
        Intent it = new Intent(CreateMonsterActivity.this, MainScreenActivity.class);
        startActivity(it);
    }

}
