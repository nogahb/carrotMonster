package com.example.nogahblum.carrotmonster;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.oguzdev.circularfloatingactionmenu.library.FloatingActionMenu;
//import com.oguzdev.circularfloatingactionmenu.library.SubActionButton;

import java.util.ArrayList;

public class MainScreenActivity extends AppCompatActivity {

    private SharedPreferences prefs;


    @Override
    protected void onPause()
    {
        super.onPause();
        prefs = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = prefs.edit();
        Gson gson = new Gson();
        String json = gson.toJson(Session.curmonster);
        editor.putString(Session.USER_NAME+"monster", json);
        editor.apply();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);

        ImageView img= (ImageView) findViewById(R.id.imageViewmain);
        img.setImageResource(R.drawable.image_1);
        //todo image_dufault

        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction()
                    .add(R.id.container, new CustomAnimationDemoFragment())
                    .commit();
        }

        Toolbar toolbar = findViewById(R.id.this_toolbar);
        setSupportActionBar(toolbar);

        if (Session.curmonster != null){

            if (Session.curmonster.getGrowthCounter() > 5) {
                Session.curmonster.changeLevel(1);
                img.setImageResource(R.drawable.image_2);//todo good img
            }

            if (Session.curmonster.getGrowthCounter() < -3) {
                Session.curmonster.changeLevel(-1);
                img.setImageResource(R.drawable.image_2);//todo bad img
            }


            String satet  = Session.curmonster.check_on_monster();
            if (satet.equals("hungry")){
                Toast.makeText(MainScreenActivity.this,
                        "Feed Me", Toast.LENGTH_LONG).show();
            }
            if (satet.equals(("ded"))){
                Toast.makeText(MainScreenActivity.this,
                        "your monster is dead and reborn ", Toast.LENGTH_LONG).show();
                Monster reborn_m = new Monster(Session.curmonster.getGoodFood(),Session.curmonster.getGoodFood(),
                        Session.curmonster.type);
                Session.curmonster =reborn_m;
            }
//            if(satet.equals("OK")){
////                Toast.makeText(MainScreenActivity.this,
////                        " Nice to see you "+Session.USER_NAME, Toast.LENGTH_LONG).show();
//
//                }

        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.example_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent;
        switch (item.getItemId()) {
            case R.id.monster_info:
                intent = new Intent(this, MonsterInfo.class);
                this.startActivity(intent);
                return true;
            case R.id.user_info:
                intent = new Intent(this, UserInfo.class);
                this.startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    /**
     * A fragment for the FEED_ME! button
     * (A placeholder fragment containing a simple view).
     */
    public static class CustomAnimationDemoFragment extends Fragment {

        public final int GOOD_FOOD = 1;
        public final int BAD_FOOD = -1;
        public final int LEVEL_UP = 5;
        public final int LEVEL_DOWN = -3;



        public CustomAnimationDemoFragment() {
        }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_main_screen, container, false);

        ImageView fabContent = new ImageView(getActivity());
        fabContent.setImageDrawable(getResources().getDrawable(R.drawable.ic_action_user));


        com.oguzdev.circularfloatingactionmenu.library.FloatingActionButton darkButton =
                new com.oguzdev.circularfloatingactionmenu.library.FloatingActionButton.Builder(getActivity())
                        .setTheme(com.oguzdev.circularfloatingactionmenu.library.FloatingActionButton.THEME_DARK)
                        .setContentView(fabContent)
                        .setPosition(com.oguzdev.circularfloatingactionmenu.library.FloatingActionButton.POSITION_BOTTOM_CENTER)
                        .build();

        // Create menu items:
        ArrayList<String> goodFoodArr = Session.curmonster.getGoodFood();
        ArrayList<String> badFoodArr = Session.curmonster.getBadFood();

        final TextView good1 = new TextView(this.getContext());
        final TextView good2 = new TextView(this.getContext());
        final TextView good3 = new TextView(this.getContext());
        final TextView bad1 = new TextView(this.getContext());
        final TextView bad2 = new TextView(this.getContext());
        final TextView bad3 = new TextView(this.getContext());

        good1.setText(goodFoodArr.get(0));
        good2.setText(goodFoodArr.get(1));
        good3.setText(goodFoodArr.get(2));
        bad1.setText(badFoodArr.get(0));
        bad2.setText(badFoodArr.get(1));
        bad3.setText(badFoodArr.get(2));


        SubActionButton.Builder rLSubBuilder = new SubActionButton.Builder(getActivity())
                .setTheme(SubActionButton.ACCESSIBILITY_LIVE_REGION_NONE);

        FloatingActionMenu centerBottomMenu = new FloatingActionMenu.Builder(getActivity())
                .setStartAngle(0)
                .setEndAngle(-180)
                .setAnimationHandler(new SlideInAnimationHandler())
                .addSubActionView(rLSubBuilder.setContentView(good1).build())
                .addSubActionView(rLSubBuilder.setContentView(good2).build())
                .addSubActionView(rLSubBuilder.setContentView(good3).build())
                .addSubActionView(rLSubBuilder.setContentView(bad1).build())
                .addSubActionView(rLSubBuilder.setContentView(bad2).build())
                .addSubActionView(rLSubBuilder.setContentView(bad3).build())
                .attachTo(darkButton)
                .build();

        // OnClickListeners for each menu item
        good1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                feedGoodFood(good1.getText(), 1);
            }
        });

        good2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                feedGoodFood(good2.getText(), 2);
            }
        });

        good3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                feedGoodFood(good3.getText(), 3);
            }
        });

        bad1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                feedBadFood(bad1.getText(), 1);
            }
        });

        bad2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                feedBadFood(bad2.getText(), 2);
            }
        });

        bad3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                feedBadFood(bad3.getText(), 3);
            }
        });


        return rootView;
    }


        public void feedGoodFood(CharSequence goodFood, int msgNum) {
            Toast.makeText(getContext(), "I love " + goodFood + "! YAM!",
                    Toast.LENGTH_SHORT).show(); // todo add more msg

            Session.curmonster.update_when_fed();

            Session.curmonster.changeGrowthCounter(GOOD_FOOD);


            if (Session.curmonster.getGrowthCounter() > 5) {
                //restart
                getActivity().recreate();
            }

        }

        public void feedBadFood(CharSequence badFood, int msgNum) {
            Toast.makeText(getContext(), badFood + "! YUCK! Why did you do this to me? :(",
                    Toast.LENGTH_SHORT).show(); // todo add more msg

            Session.curmonster.update_when_fed();

            Session.curmonster.changeGrowthCounter(BAD_FOOD);
            if (Session.curmonster.getGrowthCounter() < -3) {
                //restart
                getActivity().recreate();

            }

        }


    }
}
