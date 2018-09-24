package com.example.nogahblum.carrotmonster;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MonsterInfo extends AppCompatActivity {
    private TextView info1,info2,info3,info4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monster_info);

        info1 = (TextView)findViewById(R.id.textView1_m_info);
        info2 = (TextView)findViewById(R.id.textView2_m_info);
        info3 = (TextView)findViewById(R.id.textView3_m_info);
        info4 = (TextView)findViewById(R.id.user_n_info);

        if (Session.curmonster != null){
            String type_1 = "Type "+ Session.curmonster.getType();
            info1.setText(type_1);
            String health = "Health "+String.valueOf((Session.curmonster.getHealth()));
            info2.setText(health);
            String level = "Level "+String.valueOf(Session.curmonster.getLevel());
            info3.setText(level);
        }

        if(!(Session.USER_NAME.equals(""))){
            info4.setText(Session.USER_NAME);

        }
    }
}
