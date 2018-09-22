package com.example.nogahblum.carrotmonster;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.content.ContextCompat;
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

import com.oguzdev.circularfloatingactionmenu.library.FloatingActionMenu;
import com.oguzdev.circularfloatingactionmenu.library.SubActionButton;

public class MainScreenActivity extends AppCompatActivity {

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

            // Create a button to attach the menu:
            ImageView fabContent = new ImageView(getActivity());
            fabContent.setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.ic_action_user));

            com.oguzdev.circularfloatingactionmenu.library.FloatingActionButton darkButton = new com.oguzdev.circularfloatingactionmenu.library.FloatingActionButton.Builder(getActivity())
                    .setTheme(com.oguzdev.circularfloatingactionmenu.library.FloatingActionButton.THEME_DARK)
                    .setContentView(fabContent)
                    .setPosition(com.oguzdev.circularfloatingactionmenu.library.FloatingActionButton.POSITION_BOTTOM_CENTER)
                    .build();

            // Create menu items:
            SubActionButton.Builder rLSubBuilder = new SubActionButton.Builder(getActivity())
                    .setTheme(SubActionButton.THEME_DARK);

//            String[] goodFoodArr = Session.curmonster.getGoodFood();
//            String[] badFoodArr = Session.curmonster.getBadFood();
//
//            TextView[] textToButtons = new TextView[goodFoodArr.length + badFoodArr.length];
//
//            for( int i = 0; i < goodFoodArr.length; i++ )
//            {
//                TextView textView = new TextView(this.getContext());
//                textView.setText(Session.curmonster.getGoodFood()[i]);
//                textToButtons[i] = textView;
//            }
//
//            for( int i = goodFoodArr.length; i < goodFoodArr.length + badFoodArr.length; i++ )
//            {
//                TextView textView = new TextView(this.getContext());
//                textView.setText(Session.curmonster.getGoodFood()[i]);
//                textToButtons[i] = textView;
//            }

            ImageView rlIcon1 = new ImageView(getActivity());
            ImageView rlIcon2 = new ImageView(getActivity());
            ImageView rlIcon3 = new ImageView(getActivity());
            ImageView rlIcon4 = new ImageView(getActivity());
            ImageView rlIcon5 = new ImageView(getActivity());
            ImageView rlIcon6 = new ImageView(getActivity());

            rlIcon1.setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.ic_action_pass));
            rlIcon2.setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.ic_action_pass));
            rlIcon3.setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.ic_action_pass));
            rlIcon4.setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.ic_action_pass));
            rlIcon5.setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.ic_action_pass));
            rlIcon6.setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.ic_action_pass));

            // Set all SubActionButtons //TODO: continue here!
            FloatingActionMenu centerBottomMenu = new FloatingActionMenu.Builder(getActivity())
                    .setStartAngle(0)
                    .setEndAngle(-180)
                    .setAnimationHandler(new SlideInAnimationHandler())
                    .addSubActionView(rLSubBuilder.setContentView(rlIcon1).build())
                    .addSubActionView(rLSubBuilder.setContentView(rlIcon2).build())
                    .addSubActionView(rLSubBuilder.setContentView(rlIcon3).build())
                    .addSubActionView(rLSubBuilder.setContentView(rlIcon4).build())
                    .addSubActionView(rLSubBuilder.setContentView(rlIcon5).build())
                    .addSubActionView(rLSubBuilder.setContentView(rlIcon6).build())
                    .attachTo(darkButton)
                    .build();

            return rootView;
        }
    }

}