package com.example.datamanager;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class LifecycleActivity extends AppCompatActivity {

    private final String ON_CREATE = "oncreate";
    private final String ON_START = "onstart";
    private final String ON_RESTART = "onrestart";
    private final String ON_RESUME = "onresume";
    private final String ON_PAUSE = "onpause";
    private final String ON_STOP = "onstop";
    private final String ON_DESTROY = "ondestroy";

    private final String ACTIVITY_LIFECYCLE = "activity_lifecycle";

    private String mActivityLifeCycle = "";
    private SharedPreferences.Editor mPreference = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lifecycle);

        mActivityLifeCycle = ON_CREATE;
        mPreference = this.getPreferences(MODE_PRIVATE).edit();

        setPreferenceValue(mActivityLifeCycle);
    }
    @Override
    protected void onStop() {
        super.onStop();

        mActivityLifeCycle = mActivityLifeCycle + "|" + ON_STOP;
        setPreferenceValue(mActivityLifeCycle);
    }

    @Override
    protected void onRestart() {
        super.onRestart();

        mActivityLifeCycle = mActivityLifeCycle + "|" + ON_RESTART;
        setPreferenceValue(mActivityLifeCycle);
    }

    @Override
    protected void onStart() {
        super.onStart();

        mActivityLifeCycle = mActivityLifeCycle + "|" + ON_START;
        setPreferenceValue(mActivityLifeCycle);
    }

    @Override
    protected void onPause() {
        super.onPause();

        mActivityLifeCycle = mActivityLifeCycle + "|" + ON_PAUSE;
        setPreferenceValue(mActivityLifeCycle);
    }

    @Override
    protected void onResume() {
        super.onResume();

        mActivityLifeCycle = mActivityLifeCycle + "|" + ON_RESUME;
        setPreferenceValue(mActivityLifeCycle);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        mActivityLifeCycle = mActivityLifeCycle + "|" + ON_DESTROY;
        setPreferenceValue(mActivityLifeCycle);
    }

    private void setPreferenceValue(String aValue){
        mPreference.putString(ACTIVITY_LIFECYCLE, aValue);
        mPreference.commit();
    }
}
