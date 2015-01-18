package com.example.hindedfr;

import android.os.Bundle;
import android.preference.PreferenceActivity;

/**
 * Created by vaino on 18/01/15.
 */
public class prefs extends PreferenceActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preferences);
    }
}
