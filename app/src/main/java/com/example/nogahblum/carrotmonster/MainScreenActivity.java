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

        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction()
                    .add(R.id.container, new CustomAnimationDemoFragment())
                    .commit();
        }

        Toolbar toolbar = findViewById(R.id.this_toolbar);
        setSupportActionBar(toolbar);

        if (Session.curmonster != null){
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
            if(satet.equals("OK")){
                Toast.makeText(MainScreenActivity.this,
                        " Nice to see you again "+Session.USER_NAME, Toast.LENGTH_LONG).show();


            }
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

        TextView[] textToButtons = new TextView[goodFoodArr.size() + badFoodArr.size()];
        String[] buttonsNames = new String[goodFoodArr.size() + badFoodArr.size()];

        for( int i = 0; i < goodFoodArr.size(); i++ )
        {
            TextView textView = new TextView(this.getContext());
            textView.setText(Session.curmonster.getGoodFood().get(i));
            textToButtons[i] = textView;

            buttonsNames[i] = Session.curmonster.getGoodFood().get(i);
        }

        for( int i = 0; i < badFoodArr.size(); i++ )
        {
            TextView textView = new TextView(this.getContext());
            textView.setText(Session.curmonster.getBadFood().get(i));
            textToButtons[goodFoodArr.size() + i] = textView;

            buttonsNames[goodFoodArr.size() + i] = Session.curmonster.getBadFood().get(i);

        }

            SubActionButton.Builder rLSubBuilder = new SubActionButton.Builder(getActivity())
                    .setTheme(SubActionButton.ACCESSIBILITY_LIVE_REGION_NONE);

            // Set all SubActionButtons
            FloatingActionMenu centerBottomMenu;

            switch (textToButtons.length) {
                case 1:
                    centerBottomMenu = new FloatingActionMenu.Builder(getActivity())
                            .setStartAngle(0)
                            .setEndAngle(-180)
                            .setAnimationHandler(new SlideInAnimationHandler())
                            .addSubActionView(rLSubBuilder.setContentView(textToButtons[0]).build())
                            .attachTo(darkButton)
                            .build();
                    break;
                case 2:
                    centerBottomMenu = new FloatingActionMenu.Builder(getActivity())
                            .setStartAngle(0)
                            .setEndAngle(-180)
                            .setAnimationHandler(new SlideInAnimationHandler())
                            .addSubActionView(rLSubBuilder.setContentView(textToButtons[0]).build())
                            .addSubActionView(rLSubBuilder.setContentView(textToButtons[1]).build())
                            .attachTo(darkButton)
                            .build();
                    break;
                case 3:
                    centerBottomMenu = new FloatingActionMenu.Builder(getActivity())
                            .setStartAngle(0)
                            .setEndAngle(-180)
                            .setAnimationHandler(new SlideInAnimationHandler())
                            .addSubActionView(rLSubBuilder.setContentView(textToButtons[0]).build())
                            .addSubActionView(rLSubBuilder.setContentView(textToButtons[1]).build())
                            .addSubActionView(rLSubBuilder.setContentView(textToButtons[2]).build())
                            .attachTo(darkButton)
                            .build();
                    break;
                case 4:
                    centerBottomMenu = new FloatingActionMenu.Builder(getActivity())
                            .setStartAngle(0)
                            .setEndAngle(-180)
                            .setAnimationHandler(new SlideInAnimationHandler())
                            .addSubActionView(rLSubBuilder.setContentView(textToButtons[0]).build())
                            .addSubActionView(rLSubBuilder.setContentView(textToButtons[1]).build())
                            .addSubActionView(rLSubBuilder.setContentView(textToButtons[2]).build())
                            .addSubActionView(rLSubBuilder.setContentView(textToButtons[3]).build())
                            .attachTo(darkButton)
                            .build();
                    break;
                case 5:
                    centerBottomMenu = new FloatingActionMenu.Builder(getActivity())
                            .setStartAngle(0)
                            .setEndAngle(-180)
                            .setAnimationHandler(new SlideInAnimationHandler())
                            .addSubActionView(rLSubBuilder.setContentView(textToButtons[0]).build())
                            .addSubActionView(rLSubBuilder.setContentView(textToButtons[1]).build())
                            .addSubActionView(rLSubBuilder.setContentView(textToButtons[2]).build())
                            .addSubActionView(rLSubBuilder.setContentView(textToButtons[3]).build())
                            .addSubActionView(rLSubBuilder.setContentView(textToButtons[4]).build())
                            .attachTo(darkButton)
                            .build();
                    break;
                case 6:
                    centerBottomMenu = new FloatingActionMenu.Builder(getActivity())
                            .setStartAngle(0)
                            .setEndAngle(-180)
                            .setAnimationHandler(new SlideInAnimationHandler())
                            .addSubActionView(rLSubBuilder.setContentView(textToButtons[0]).build())
                            .addSubActionView(rLSubBuilder.setContentView(textToButtons[1]).build())
                            .addSubActionView(rLSubBuilder.setContentView(textToButtons[2]).build())
                            .addSubActionView(rLSubBuilder.setContentView(textToButtons[3]).build())
                            .addSubActionView(rLSubBuilder.setContentView(textToButtons[4]).build())
                            .addSubActionView(rLSubBuilder.setContentView(textToButtons[5]).build())
                            .attachTo(darkButton)
                            .build();
                    break;
            }

            return rootView;
        }
    }
}
