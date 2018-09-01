package com.example.nogahblum.carrotmonster;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class MainScreenActivity extends AppCompatActivity {

    TextView m_toolbar_title;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);
        getSupportActionBar().hide();

        m_toolbar_title = (TextView)findViewById(R.id.toolbar_title);
        m_toolbar_title.setText("Activity Title");

    }

}



//my code:
//import android.support.v7.app.AppCompatActivity;
//import android.support.v7.widget.Toolbar;
//import android.os.Bundle;
////import android.widget.Toolbar;
//
//public class MainScreenActivity extends AppCompatActivity {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main_screen);
////        getSupportActionBar().hide();
//
//        android.support.v7.widget.Toolbar toolbar = findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//    }
//}
