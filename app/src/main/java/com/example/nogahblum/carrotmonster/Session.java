package com.example.nogahblum.carrotmonster;

        import android.content.Context;
        import android.content.SharedPreferences;
        import android.preference.PreferenceManager;
        import android.support.v7.app.AppCompatActivity;
        import android.widget.Toast;

//        import stories.spectrum.huji.ac.il.stories.net.StoryServerURLs;


public class Session extends AppCompatActivity {

    private static final String USER_NAME = "username";
    private static final String USER_ID = "userid";
    private static final String SETTINGS_NAVIGATION = "navigation";
    private static final String SETTINGS_LOCAL_SERVER = "server";
    private static final String SETTINGS_SHOW_ALL_RECORDINGS = "show_all";

    public static final String NO_USER_NAME = "";
    public static final int NO_USER_ID = -1;
    public static final boolean NO_SETTINGS_NAVIGATION = false;
    public static final boolean NO_SETTINGS_LOCAL_SERVER = false;
    public static final boolean NO_SETTINGS_SHOW_ALL_RECORDINGS = false;

    private SharedPreferences prefs;
    private SharedPreferences.Editor editor;

    public Session(Context context) {
        //initialazing data
        prefs = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = prefs.edit();

    }

    //Storing Data

//  bn bn


    public void register(String user_mane,String passvord) {
        String a = prefs.getString(user_mane,"");
//        if !a.equals(""){
//        }
        editor.putString(user_mane, passvord);
        editor.apply();
    }
    public void save_data (String monster_mane,String  data) {
        editor.putString(monster_mane, data);
        editor.apply();
    }
    public Boolean isLoggedIn(String user,String pass_word){
         String a = prefs.getString(user, "");
        return a.equals(pass_word);
    }

    public void logOut() {
        editor.clear();
        editor.apply();
    }
//    public void setUserName(String userName) {
//        prefs.edit().putString(USER_NAME, userName).apply();
//    }
//
//
//
//    public int getUserID() {
//        return prefs.getInt(USER_ID, NO_USER_ID);
//    }
//    public void setUserID(int userID) {
//        prefs.edit().putInt(USER_ID, userID).apply();
//    }
//
//
//    public void logIn(String username, int userID) {
//        setUserName(username);
//        setUserID(userID);
//    }
//    public void logOut() {
//        SharedPreferences.Editor editor = prefs.edit();
//        editor.clear();
//        editor.apply();
//    }
//    public boolean isLoggedIn() {
//        return (prefs.getInt(USER_ID, NO_USER_ID) != NO_USER_ID);
//    }
//
//    public boolean getSettingsNavigation() {
//        return prefs.getBoolean(SETTINGS_NAVIGATION, NO_SETTINGS_NAVIGATION);
//    }
//    public void setSettingsNavigation(boolean navigation) {
//        prefs.edit().putBoolean(SETTINGS_NAVIGATION, navigation).apply();
//    }
//
//    public boolean getSettingsServer() {
//        return prefs.getBoolean(SETTINGS_LOCAL_SERVER, NO_SETTINGS_LOCAL_SERVER);
//    }
//    public void setSettingsServer(boolean server) {
//        prefs.edit().putBoolean(SETTINGS_LOCAL_SERVER, server).apply();
//    }
//
//    public boolean getSettingsShowAllRecordings() {
//        return prefs.getBoolean(SETTINGS_SHOW_ALL_RECORDINGS, NO_SETTINGS_SHOW_ALL_RECORDINGS);
//    }
//    public void setSettingsShowAllRecordings(boolean showAllRecordings) {
//        prefs.edit().putBoolean(SETTINGS_SHOW_ALL_RECORDINGS, showAllRecordings).apply();
//    }
//
////    public void apllySettings() {
////        StoryServerURLs.serverURL = (getSettingsServer() ?  StoryServerURLs.serverURLLocal : StoryServerURLs.serverURLServer);
////    }
}