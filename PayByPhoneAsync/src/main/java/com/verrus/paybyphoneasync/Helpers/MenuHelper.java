package com.verrus.paybyphoneasync.Helpers;

import android.app.Activity;
import android.content.Context;
import android.widget.TextView;

import com.verrus.paybyphoneasync.R;

import java.util.Iterator;
import java.util.Map;

import static android.app.PendingIntent.getActivity;

/**
 * Created by nkhodabandeh on 02/01/14.
 */
public class MenuHelper {

    public static void onActionsettingsSelected(Activity activity, Context context){

        TextView result = (TextView) activity.findViewById(R.id.result);
        result.setText("");
        Map<String, Integer> keyVals = SharedPreferenceHelper.getSharedPref(context);

        Iterator<Map.Entry<String, Integer>> iterator = keyVals.entrySet().iterator();

        while (iterator.hasNext()){
            Map.Entry<String, Integer> pairs = iterator.next();
            String key = pairs.getKey();
            Integer val = pairs.getValue();

            result.append("[" + val + "]" + key + "\n");
            result.append("-------------\n");
        }
    }

    public static void onClearSettingsSelected(Context applicationContext) {
        SharedPreferenceHelper.Clear(applicationContext);
    }
}
