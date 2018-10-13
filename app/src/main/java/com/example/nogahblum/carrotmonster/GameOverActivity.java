package com.example.nogahblum.carrotmonster;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class GameOverActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_over);
        ImageView img= (ImageView) findViewById(R.id.imageView);

        if (Session.curmonster != null) {
            if (Session.curmonster.type.equals("0")) {
                Picasso.get().load(R.drawable.fenratarir_2)
                        .resize(2048, 2048)
                        .onlyScaleDown() // the image will only be resized if it's bigger than 2048x 1600 pixels.
                        .into(img);

            } else {
                Picasso.get().load(R.drawable.hiakango_2)
                        .resize(2048, 2048)
                        .onlyScaleDown() // the image will only be resized if it's bigger than 2048x 1600 pixels.
                        .into(img);
            }
        }

        Session.curmonster.setLevel(0);

        Button button= (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startNextActivity();
            }
        });
    }

    private void startNextActivity() {
        Intent it = new Intent(GameOverActivity.this, CreateMonsterActivity.class);
        startActivity(it);
        finish();
    }

}
