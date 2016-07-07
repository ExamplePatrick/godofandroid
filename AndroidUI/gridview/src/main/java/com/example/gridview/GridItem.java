package com.example.gridview;

import android.graphics.drawable.Drawable;

/**
 * Created by Patrick on 2016-07-07.
 */
public class GridItem {

    private String mAppName = null;
    private Drawable mAppIcon = null;

    public GridItem(String aAppName, Drawable aAppIcon){
        this.mAppName = aAppName;
        this.mAppIcon = aAppIcon;
    }

    public String getAppName() {
        return mAppName;
    }

    public Drawable getAppIcon() {
        return mAppIcon;
    }
}
