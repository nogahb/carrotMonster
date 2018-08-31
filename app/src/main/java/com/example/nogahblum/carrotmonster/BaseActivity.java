package com.example.nogahblum.carrotmonster;

import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatDelegate;
//import android.widget.Toolbar;
import android.support.v7.widget.Toolbar;

public class BaseActivity extends AppCompatActivity {

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_base);
//
//    }
    private AppCompatDelegate mDelegate;
    protected static Session session = null;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
//        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
//                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
//        drawer.setDrawerListener(toggle);
//        toggle.syncState();
//
//        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
//        navigationView.setNavigationItemSelectedListener(this);

//
//        // Inject the layout that getLayoutId() returns into the activity_container element
//        LayoutInflater inflater = LayoutInflater.from(context);
//        View inflatedLayout = inflater.inflate(getLayoutId(), null, false);
//
//        // Set the correct width and height retrieved by the getLayoutWidthHeight method
//        CoordinatorLayout.LayoutParams lp = new CoordinatorLayout.LayoutParams(new ViewGroup.LayoutParams(getLayoutWidthHeight(), getLayoutWidthHeight()));
//        (findViewById(R.id.activity_container)).setLayoutParams(lp);
//        ((LinearLayout)(findViewById(R.id.activity_container))).addView(inflatedLayout);
//
//
//        // Set session
//        if (session == null) {
//            session = new Session(context);
//        }
//
//        // Set name
//        View navHeader = navigationView.getHeaderView(0);
//        ((StoriesTextView)navHeader.findViewById(R.id.menuUserName)).setText(session.getUserName());
//
//        crouton = Crouton.makeText(this, getString(R.string.gps_no_signal), Style.ALERT);
//        crouton.setConfiguration(new Configuration.Builder().setDuration(Configuration.DURATION_INFINITE).build());
//
//        if (lastGPSCheckTime != -1) {
//            lastGPSCheckTime = System.currentTimeMillis();
//        }
//
//        // Show Crouton from previous activity
//        if (croutonShown) {
//            showCrouton();
//        }
//
//        //setTimer();
//
//        if (timer == null) {
//            timer = new Timer();
//
//            // Handler that handles the UI manipulations (shows the crouton)
//            final Handler mHandler = new Handler(Looper.getMainLooper()) {
//                @Override
//                public void handleMessage(Message message) {
//                    showCrouton();
//                    croutonShown = true;
//                }
//            };
//
//            // Set timer for GPS check
//            timer.schedule(new TimerTask() {
//                public void run() {
//                    if (lastGPSCheckTime + StoryServerURLs.GPS_CHECK_INTERVAL_MILLISECONDS <= System.currentTimeMillis()) {
//                        //mHandler.obtainMessage(0, 0).sendToTarget();
//                    }
//                }
//            }, 0, StoryServerURLs.GPS_CHECK_INTERVAL_MILLISECONDS);
        }

    public AppCompatDelegate getDelegate() {
        if (mDelegate == null) {
            mDelegate = AppCompatDelegate.create(this, null);
        }
        return mDelegate;
    }

    public void setSupportActionBar(Toolbar toolbar) {
        getDelegate().setSupportActionBar(toolbar);

    }
}



