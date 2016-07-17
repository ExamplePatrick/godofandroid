package com.example.datamanager;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private final String RUN_COUNT = "RUN_COUNT";
    private final String USER_FILE_NAME = "UserDefineFileName";

    private SharedPreferences.Editor mEditPreference = null;
    private SharedPreferences mPreference = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button)this.findViewById(R.id.settingBtn);
        button.setOnClickListener(this);

        Button runinfobtn = (Button)this.findViewById(R.id.runinfobtn);
        runinfobtn.setOnClickListener(this);

        Button runLifecycleBtn = (Button)this.findViewById(R.id.runlifecycle);
        runLifecycleBtn.setOnClickListener(this);

        mPreference = getSharedPreferences(USER_FILE_NAME, Context.MODE_PRIVATE);
        mEditPreference = mPreference.edit();

        int count = getPreference(RUN_COUNT);
        setPreference(RUN_COUNT, count+1);
    }


    @Override
    public void onClick(View v){
        switch(v.getId()){
            case R.id.settingBtn:
                Intent intent = new Intent(this, SettingsActivity.class);
                startActivity(intent);
                break;
            case R.id.runinfobtn:
                TextView counttxt = (TextView)this.findViewById(R.id.counttxt);
                counttxt.setText(String.valueOf(getPreference(RUN_COUNT)));
                break;
            case R.id.runlifecycle:
                Intent intent2 = new Intent(this, LifecycleActivity.class);
                startActivity(intent2);
                break;
            default:
                break;
        }
    }

    private void setPreference(String aKey, int aValue){
        mEditPreference.putInt(aKey, aValue);
        mEditPreference.commit();
    }

    private int getPreference(String aKey){
        return mPreference.getInt(aKey, 0);
    }
}
