package com.verrus.paybyphoneasync.Helpers;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import java.util.Map;

/**
 * Created by nkhodabandeh on 24/12/13.
 * This example shows how to use SharedPrefrences API
 */
public class SharedPreferenceHelper {

    public static void writeToSharedPref(Map<String, Integer> values, Context context){
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        for(Map.Entry entry: values.entrySet()){
            editor.putInt(entry.getKey().toString(), (Integer) entry.getValue());
        }
        editor.commit();
    }

    public static Map<String, Integer> getSharedPref(Context context){
        SharedPreferences shrdPref = PreferenceManager.getDefaultSharedPreferences(context);
        return (Map<String, Integer>) shrdPref.getAll();
    }

    public static void Clear(Context context){
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.commit();
    }
}
