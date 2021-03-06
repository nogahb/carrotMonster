//package com.example.nogahblum.carrotmonster;
//
//import android.content.Intent;
//import android.content.SharedPreferences;
//import android.preference.PreferenceManager;
//import android.support.v7.app.AppCompatActivity;
//import android.os.Bundle;
//import android.support.v7.widget.Toolbar;
//import android.view.Menu;
//import android.view.MenuInflater;
//import android.view.MenuItem;
//import android.view.View;
//
//import android.app.Fragment;
//import android.view.LayoutInflater;
//import android.view.ViewGroup;
//import android.widget.ImageView;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import com.google.gson.Gson;
//import com.oguzdev.circularfloatingactionmenu.library.FloatingActionMenu;
////import com.oguzdev.circularfloatingactionmenu.library.SubActionButton;
//
//import java.util.ArrayList;
//
//
//public class MainScreenActivity extends AppCompatActivity {
//
//    private SharedPreferences prefs;
//
//
//    @Override
//    protected void onPause()
//    {
//        super.onPause();
//        prefs = PreferenceManager.getDefaultSharedPreferences(this);
//        SharedPreferences.Editor editor = prefs.edit();
//        Gson gson = new Gson();
//        String json = gson.toJson(Session.curmonster);
//        editor.putString(Session.USER_NAME+"monster", json);
//        editor.apply();
//    }
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main_screen);
//
//        ImageView img= (ImageView) findViewById(R.id.imageViewmain);
//        img.setImageResource(R.drawable.image_1);
//        //todo image_dufault
//
//        if (savedInstanceState == null) {
//            getFragmentManager().beginTransaction()
//                    .add(R.id.container, new CustomAnimationDemoFragment())
//                    .commit();
//        }
//
//        Toolbar toolbar = findViewById(R.id.this_toolbar);
//        setSupportActionBar(toolbar);
//
//        if (Session.curmonster != null){
//
//            if (Session.curmonster.getGrowthCounter() > 5) {
//                Session.curmonster.changeLevel(1);
//                img.setImageResource(R.drawable.image_2);//todo good img
//            }
//
//            if (Session.curmonster.getGrowthCounter() < -3) {
//                Session.curmonster.changeLevel(-1);
//                img.setImageResource(R.drawable.image_2);//todo bad img
//            }
//
//
//            String satet  = Session.curmonster.check_on_monster();
//            if (satet.equals("hungry")){
//                Toast.makeText(MainScreenActivity.this,
//                        "Feed Me", Toast.LENGTH_LONG).show();
//            }
//            if (satet.equals(("ded"))){
//                Toast.makeText(MainScreenActivity.this,
//                        "your monster is dead and reborn ", Toast.LENGTH_LONG).show();
//                Monster reborn_m = new Monster(Session.curmonster.getGoodFood(),Session.curmonster.getGoodFood(),
//                        Session.curmonster.type);
//                Session.curmonster =reborn_m;
//            }
////            if(satet.equals("OK")){
//////                Toast.makeText(MainScreenActivity.this,
//////                        " Nice to see you "+Session.USER_NAME, Toast.LENGTH_LONG).show();
////
////                }
//
//        }
//
//    }
//
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        MenuInflater inflater = getMenuInflater();
//        inflater.inflate(R.menu.example_menu, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        Intent intent;
//        switch (item.getItemId()) {
//            case R.id.monster_info:
//                intent = new Intent(this, MonsterInfo.class);
//                this.startActivity(intent);
//                return true;
////            case R.id.user_info:
////                intent = new Intent(this, UserInfo.class);
////                this.startActivity(intent);
////                return true;
//            default:
//                return super.onOptionsItemSelected(item);
//        }
//    }
//
//    /**
//     * A fragment for the FEED_ME! button
//     * (A placeholder fragment containing a simple view).
//     */
//    public static class CustomAnimationDemoFragment extends Fragment {
//
//        public final int GOOD_FOOD = 1;
//        public final int BAD_FOOD = -1;
//        public final int LEVEL_UP = 5;
//        public final int LEVEL_DOWN = -3;
//
//
//
//        public CustomAnimationDemoFragment() {
//        }
//
//        @Override
//        public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                                 Bundle savedInstanceState) {
//            View rootView = inflater.inflate(R.layout.activity_base, container, false);
//
//            ImageView fabContent = new ImageView(getActivity());
//            fabContent.setImageDrawable(getResources().getDrawable(R.drawable.ic_feed));
//
//
//            com.oguzdev.circularfloatingactionmenu.library.FloatingActionButton darkButton =
//                    new com.oguzdev.circularfloatingactionmenu.library.FloatingActionButton.Builder(getActivity())
//                            .setTheme(com.oguzdev.circularfloatingactionmenu.library.FloatingActionButton.THEME_DARK)
//                            .setContentView(fabContent)
//                            .setPosition(com.oguzdev.circularfloatingactionmenu.library.FloatingActionButton.POSITION_BOTTOM_CENTER)
//                            .build();
//
//            // Create menu items:
//            ArrayList<String> goodFoodArr = Session.curmonster.getGoodFood();
//            ArrayList<String> badFoodArr = Session.curmonster.getBadFood();
//
//            final TextView good1 = new TextView(this.getContext());
//            final TextView good2 = new TextView(this.getContext());
//            final TextView good3 = new TextView(this.getContext());
//            final TextView bad1 = new TextView(this.getContext());
//            final TextView bad2 = new TextView(this.getContext());
////            final TextView bad3 = new TextView(this.getContext());
//
//            // set text
//            good1.setText(goodFoodArr.get(0));
//            good2.setText(goodFoodArr.get(1));
//            good3.setText(goodFoodArr.get(2));
//            bad1.setText(badFoodArr.get(0));
//            bad2.setText(badFoodArr.get(1));
////            bad3.setText(badFoodArr.get(2));
//
//            SubActionButton.Builder rLSubBuilder = new SubActionButton.Builder(getActivity())
//                    .setTheme(SubActionButton.ACCESSIBILITY_LIVE_REGION_NONE);
//
//            // set menu sub-buttons
//            View good1Button = rLSubBuilder.setContentView(good1).build();
//            View good2Button = rLSubBuilder.setContentView(good2).build();
//            View good3Button = rLSubBuilder.setContentView(good3).build();
//            View bad1Button = rLSubBuilder.setContentView(bad1).build();
//            View bad2Button = rLSubBuilder.setContentView(bad2).build();
//
//
//            FloatingActionMenu centerBottomMenu = new FloatingActionMenu.Builder(getActivity())
//                    .setStartAngle(0)
//                    .setEndAngle(-180)
//                    .setAnimationHandler(new SlideInAnimationHandler())
//                    .addSubActionView(bad1Button)
//                    .addSubActionView(good1Button)
//                    .addSubActionView(good2Button)
//                    .addSubActionView(good3Button)
//                    .addSubActionView(bad2Button)
//                    .attachTo(darkButton)
//                    .build();
//
//            // OnClickListeners for each menu item
//            good1Button.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    feedGoodFood(good1.getText(), 1);
//                }
//            });
//
//            good2Button.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    feedGoodFood(good2.getText(), 2);
//                }
//            });
//
//            good3Button.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    feedGoodFood(good3.getText(), 3);
//                }
//            });
//
//            bad1Button.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    feedBadFood(bad1.getText(), 1);
//                }
//            });
//
//            bad2Button.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    feedBadFood(bad2.getText(), 2);
//                }
//            });
//
////            bad3Button.setOnClickListener(new View.OnClickListener() {
////                @Override
////                public void onClick(View v) {
////                    feedBadFood(bad3.getText(), 3);
////                }
////            });
//
//
//            return rootView;
//        }
//
//
//        public void feedGoodFood(CharSequence goodFood, int msgNum) {
//            Toast.makeText(getContext(), "I love " + goodFood + "! YUM!",
//                    Toast.LENGTH_SHORT).show(); // todo add more msg
//
//            Session.curmonster.update_when_fed();
//
//            Session.curmonster.changeGrowthCounter(GOOD_FOOD);
//
//
//            if (Session.curmonster.getGrowthCounter() > 5) {
//                //restart
//                getActivity().recreate();
//            }
//
//        }
//
//        public void feedBadFood(CharSequence badFood, int msgNum) {
//            Toast.makeText(getContext(), badFood + "! YUCK! Why did you do this to me? :(",
//                    Toast.LENGTH_SHORT).show(); // todo add more msg
//
//            Session.curmonster.update_when_fed();
//
//            Session.curmonster.changeGrowthCounter(BAD_FOOD);
//            if (Session.curmonster.getGrowthCounter() < -3) {
//                //restart
//                getActivity().recreate();
//
//            }
//
//        }
//
//
//    }
//}

//
//
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
import com.squareup.picasso.Picasso;
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
//        img.setImageResource(R.drawable.image_1);
        Picasso.get().load(R.drawable.fenratarir0)
                .resize(2048, 2048)
                .onlyScaleDown() // the image will only be resized if it's bigger than 2048x 2048 pixels.
                .into(img);
        if (Session.curmonster != null){
            int int_level = Session.curmonster.getLevel();
            if(int_level == 0){
                if(Session.curmonster.type.equals("0") ){
    //                img.setImageResource(R.drawable.image_1);

                    Picasso.get().load(R.drawable.fenratarir0)
                            .resize(2048, 2048)
                            .onlyScaleDown() // the image will only be resized if it's bigger than 2048x 2048 pixels.
                            .into(img);
                } else {
                Picasso.get().load(R.drawable.hiakango0)
                        .resize(2048, 2048)
                        .onlyScaleDown() // the image will only be resized if it's bigger than 2048x 2048 pixels.
                        .into(img);
                }
            } else if (int_level == 1) {
                if(Session.curmonster.type.equals("0") ){
                    Picasso.get().load(R.drawable.fenratarir1)
                            .resize(2048, 2048)
                            .onlyScaleDown() // the image will only be resized if it's bigger than 2048x 2048 pixels.
                            .into(img);
                } else {
    //                img.setImageResource(R.drawable.image_2);
                    Picasso.get().load(R.drawable.hiakango1)
                            .resize(2048, 2048)
                            .onlyScaleDown() // the image will only be resized if it's bigger than 2048x 2048 pixels.
                            .into(img);
                }
            }

//            else if (int_level == 2) {
//                if(Session.curmonster.type.equals("0") ){
////                    img.setImageResource(R.drawable.image_1);
//                    Picasso.get().load(R.drawable.fenratarir2)
//                            .resize(2048, 2048)
//                            .onlyScaleDown() // the image will only be resized if it's bigger than 2048x 2048 pixels.
//                            .into(img);
//
//                } else {
//                    Picasso.get().load(R.drawable.hiakango2)
//                            .resize(2048, 2048)
//                            .onlyScaleDown() // the image will only be resized if it's bigger than 2048x 2048 pixels.
//                            .into(img);
//
//
////                    img.setImageResource(R.drawable.image_2);
//                }
//            }

            else if (int_level == -1) {
                if(Session.curmonster.type.equals("0") ) {
//                    img.setImageResource(R.drawable.image_1);
                    Picasso.get().load(R.drawable.image_1)//todo tonice fenirr -1 is called image one atleast in my fplder change its name in yours
                            .resize(2048, 2048)
                            .onlyScaleDown() // the image will only be resized if it's bigger than 2048x 2048 pixels.
                            .into(img);
                } else {

//                    img.setImageResource(R.drawable.image_2);//
                    Picasso.get().load(R.drawable.hiakango_1)
                            .resize(2048, 2048)
                            .onlyScaleDown() // the image will only be resized if it's bigger than 2048x 2048 pixels.
                            .into(img);
                }
            }

//            else if (int_level ==-2) {
//                if(Session.curmonster.type.equals("0") ) {
////                    img.setImageResource(R.drawable.image_1);
//
//                    Picasso.get().load(R.drawable.fenratarir_2)
//                            .resize(2048, 2048)
//                            .onlyScaleDown() // the image will only be resized if it's bigger than 2048x 2048 pixels.
//                            .into(img);
//                } else {
////                    img.setImageResource(R.drawable.image_2);//
//                    Picasso.get().load(R.drawable.hiakango_2)
//                            .resize(2048, 2048)
//                            .onlyScaleDown() // the image will only be resized if it's bigger than 2048x 2048 pixels.
//                            .into(img);
//                }
//            }

        }

        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction()
                    .add(R.id.container, new CustomAnimationDemoFragment())
                    .commit();
        }

        Toolbar toolbar = findViewById(R.id.this_toolbar);
        setSupportActionBar(toolbar);

        if (Session.curmonster != null) {
            int int_level = Session.curmonster.getLevel();
            if ((Session.curmonster.getGrowthCounter() > 3) && (int_level == 0)) {
                Session.curmonster.changeLevel(1);
                Session.curmonster.growthCounter = 0;

                if(Session.curmonster.type.equals("0")){

//              Picasso.with(MainScreenActivity.this).load(R.drawable.fenratarir0).centerCrop().into(img);
                    Picasso.get().load(R.drawable.fenratarir1)
                            .resize(2048, 2048)
                            .onlyScaleDown() // the image will only be resized if it's bigger than 2048x 1600 pixels.
                            .into(img);
//                    img.setImageResource(R.drawable.fenratarir2);
                }
                else{
                    Picasso.get().load(R.drawable.hiakango1)
                            .resize(2048, 2048)
                            .onlyScaleDown() // the image will only be resized if it's bigger than 2048x 1600 pixels.
                            .into(img);
                }

            }

            if ((Session.curmonster.getGrowthCounter() > 3) && (int_level == -1)) {
                Session.curmonster.changeLevel(1);
                Session.curmonster.growthCounter = 0;

                if(Session.curmonster.type.equals("0")){

//              Picasso.with(MainScreenActivity.this).load(R.drawable.fenratarir0).centerCrop().into(img);
                    Picasso.get().load(R.drawable.fenratarir0)
                            .resize(2048, 2048)
                            .onlyScaleDown() // the image will only be resized if it's bigger than 2048x 1600 pixels.
                            .into(img);
//                    img.setImageResource(R.drawable.fenratarir2);
                }
                else{
                    Picasso.get().load(R.drawable.hiakango0)
                            .resize(2048, 2048)
                            .onlyScaleDown() // the image will only be resized if it's bigger than 2048x 1600 pixels.
                            .into(img);
                }

            }
//            if ((Session.curmonster.getGrowthCounter() > 5) && (int_level == -2)) {
//                Session.curmonster.changeLevel(1);
//                Session.curmonster.growthCounter = 0;
//
//                if(Session.curmonster.type.equals("0")){
//
////              Picasso.with(MainScreenActivity.this).load(R.drawable.fenratarir0).centerCrop().into(img);
//                    Picasso.get().load(R.drawable.image_1)
//                            .resize(2048, 2048)
//                            .onlyScaleDown() // the image will only be resized if it's bigger than 2048x 1600 pixels.
//                            .into(img);
////                    img.setImageResource(R.drawable.fenratarir2);
//                }
//                else{
//                    Picasso.get().load(R.drawable.hiakango_1)
//                            .resize(2048, 2048)
//                            .onlyScaleDown() // the image will only be resized if it's bigger than 2048x 1600 pixels.
//                            .into(img);
//                }
//
//            }
            if ((Session.curmonster.getGrowthCounter() > 3) && (int_level == 1)) {
                Session.curmonster.changeLevel(1);
                Session.curmonster.growthCounter = 0;
//                Toast.makeText(MainScreenActivity.this,
//                        "GOOD JOB", Toast.LENGTH_SHORT).show();
//
//                if(Session.curmonster.type.equals("0")){
//
//                    Picasso.get().load(R.drawable.fenratarir2)
//                            .resize(2048, 2048)
//                            .onlyScaleDown() // the image will only be resized if it's bigger than 2048x 1600 pixels.
//                            .into(img);
////                    img.setImageResource(R.drawable.fenratarir2);
//
//                }
//                else{
////                    img.setImageResource(R.drawable.fenratarir2);
//                    Picasso.get().load(R.drawable.hiakango2)
//                            .resize(2048, 2048)
//                            .onlyScaleDown() // the image will only be resized if it's bigger than 2048x 1600 pixels.
//                            .into(img);
//                }

                startNextActivityWin(Session.USER_NAME);


            }
            if ((Session.curmonster.getGrowthCounter() < -3)  && (int_level == 0)) {
                Session.curmonster.changeLevel(-1);
                Session.curmonster.growthCounter = 0;

                if(Session.curmonster.type.equals("0")){
//                    img.setImageResource(R.drawable.fenratarir2);
//                    Session.curmonster.changeGrowthCounter(0);
                    Picasso.get().load(R.drawable.image_1)
                            .resize(2048, 2048)
                            .onlyScaleDown() // the image will only be resized if it's bigger than 2048x 1600 pixels.
                            .into(img);

                }
                else{
//                img.setImageResource(R.drawable.image_2);
                    Picasso.get().load(R.drawable.hiakango_1)
                            .resize(2048, 2048)
                            .onlyScaleDown() // the image will only be resized if it's bigger than 2048x 1600 pixels.
                            .into(img);
                }}
            if ((Session.curmonster.getGrowthCounter() < -3)  && (int_level == -1)) {
                Session.curmonster.changeLevel(-1);
//                Session.curmonster.changeGrowthCounter(0);
//                Toast.makeText(MainScreenActivity.this,
//                        ":( :(", Toast.LENGTH_SHORT).show();
                Session.curmonster.growthCounter = 0;


//                if(Session.curmonster.type.equals("0")){
////                    img.setImageResource(R.drawable.fenratarir2);
//                    Picasso.get().load(R.drawable.fenratarir_2)
//                            .resize(2048, 2048)
//                            .onlyScaleDown() // the image will only be resized if it's bigger than 2048x 1600 pixels.
//                            .into(img);
//
//                }
//                else{
//                    Picasso.get().load(R.drawable.hiakango_2)
//                            .resize(2048, 2048)
//                            .onlyScaleDown() // the image will only be resized if it's bigger than 2048x 1600 pixels.
//                            .into(img);
//
//                }

                startNextActivityLose(Session.USER_NAME);

            }

            if ((Session.curmonster.getGrowthCounter() < -3)  && (int_level == 1)) {
                Session.curmonster.changeLevel(-1);
//                Session.curmonster.changeGrowthCounter(0);
                Session.curmonster.growthCounter = 0;


                if(Session.curmonster.type.equals("0")){
//                    img.setImageResource(R.drawable.fenratarir2);
                    Picasso.get().load(R.drawable.fenratarir0)
                            .resize(2048, 2048)
                            .onlyScaleDown() // the image will only be resized if it's bigger than 2048x 1600 pixels.
                            .into(img);

                }
                else{
                    Picasso.get().load(R.drawable.hiakango0)
                            .resize(2048, 2048)
                            .onlyScaleDown() // the image will only be resized if it's bigger than 2048x 1600 pixels.
                            .into(img);

                }}
            if ((Session.curmonster.getGrowthCounter() < -3)  && (int_level ==2)) {
                Session.curmonster.changeLevel(-1);
//                Session.curmonster.changeGrowthCounter(0);
                Session.curmonster.growthCounter = 0;


                if(Session.curmonster.type.equals("0")){
//                    img.setImageResource(R.drawable.fenratarir2);
                    Picasso.get().load(R.drawable.fenratarir1)
                            .resize(2048, 2048)
                            .onlyScaleDown() // the image will only be resized if it's bigger than 2048x 1600 pixels.
                            .into(img);

                }
                else{
                    Picasso.get().load(R.drawable.hiakango1)
                            .resize(2048, 2048)
                            .onlyScaleDown() // the image will only be resized if it's bigger than 2048x 1600 pixels.
                            .into(img);

                }}


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
//            case R.id.user_info:
//                intent = new Intent(this, UserInfo.class);
//                this.startActivity(intent);
//                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void startNextActivityLose(String user) {
        Intent it = new Intent(MainScreenActivity.this, GameOverActivity.class);
        startActivity(it);
        Session.setUserName(user);
        finish();
    }

    private void startNextActivityWin(String user) {
        Intent it = new Intent(MainScreenActivity.this, WinActivity.class);
        startActivity(it);
        Session.setUserName(user);
        finish();
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
            View rootView = inflater.inflate(R.layout.activity_base, container, false);

            ImageView fabContent = new ImageView(getActivity());
            fabContent.setImageDrawable(getResources().getDrawable(R.drawable.ic_feed));


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
//            final TextView bad3 = new TextView(this.getContext());

            // set text
            good1.setText(goodFoodArr.get(0));
            good2.setText(goodFoodArr.get(1));
            good3.setText(goodFoodArr.get(2));
            bad1.setText(badFoodArr.get(0));
            bad2.setText(badFoodArr.get(1));
//            bad3.setText(badFoodArr.get(2));

            //set textView size
//            good1.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
//            good2.setHeight(190);

            //set text size
//            good1.setAutoSizeTextTypeWithDefaults(TextView.AUTO_SIZE_TEXT_TYPE_UNIFORM);
//            good2.setAutoSizeTextTypeWithDefaults(TextView.AUTO_SIZE_TEXT_TYPE_UNIFORM);
//            good3.setAutoSizeTextTypeWithDefaults(TextView.AUTO_SIZE_TEXT_TYPE_UNIFORM);
//            bad1.setAutoSizeTextTypeWithDefaults(TextView.AUTO_SIZE_TEXT_TYPE_UNIFORM);
//            bad2.setAutoSizeTextTypeWithDefaults(TextView.AUTO_SIZE_TEXT_TYPE_UNIFORM);


            SubActionButton.Builder rLSubBuilder = new SubActionButton.Builder(getActivity())
                    .setTheme(SubActionButton.ACCESSIBILITY_LIVE_REGION_NONE);

            // set menu sub-buttons
            View good1Button = rLSubBuilder.setContentView(good1).build();
            View good2Button = rLSubBuilder.setContentView(good2).build();
            View good3Button = rLSubBuilder.setContentView(good3).build();
            View bad1Button = rLSubBuilder.setContentView(bad1).build();
            View bad2Button = rLSubBuilder.setContentView(bad2).build();


            FloatingActionMenu centerBottomMenu = new FloatingActionMenu.Builder(getActivity())
                    .setStartAngle(0)
                    .setEndAngle(-180)
                    .setAnimationHandler(new SlideInAnimationHandler())
                    .addSubActionView(bad1Button)
                    .addSubActionView(good1Button)
                    .addSubActionView(good2Button)
                    .addSubActionView(good3Button)
                    .addSubActionView(bad2Button)
                    .attachTo(darkButton)
                    .build();

            // OnClickListeners for each menu item
            good1Button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    feedGoodFood(good1.getText(), 1);
                }
            });

            good2Button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    feedGoodFood(good2.getText(), 2);
                }
            });

            good3Button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    feedGoodFood(good3.getText(), 3);
                }
            });

            bad1Button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    feedBadFood(bad1.getText(), 1);
                }
            });

            bad2Button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    feedBadFood(bad2.getText(), 2);
                }
            });

//            bad3Button.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    feedBadFood(bad3.getText(), 3);
//                }
//            });


            return rootView;
        }


        public void feedGoodFood(CharSequence goodFood, int msgNum) {
            Toast.makeText(getContext(), "I love " + goodFood + "! YUM!",
                    Toast.LENGTH_SHORT).show(); // todo add more msg

            Session.curmonster.update_when_fed();
            Session.curmonster.changeGrowthCounter(GOOD_FOOD);


            if (Session.curmonster.getGrowthCounter() > 3) {
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
