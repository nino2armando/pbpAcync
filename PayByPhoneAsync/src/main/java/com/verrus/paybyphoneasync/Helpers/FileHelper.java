package com.verrus.paybyphoneasync.Helpers;

import android.app.Activity;
import android.content.Context;
import android.widget.TextView;

import com.verrus.paybyphoneasync.R;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

/**
 * Created by nkhodabandeh on 13/01/14.
 */
public class FileHelper {
    public static String readFromFile(Context context, Activity activity){
        File file = new File(context.getFilesDir(),"test");

        StringBuilder sb = new StringBuilder();

        try{
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;

            while ((line = br.readLine()) != null){
                sb.append(line);
                sb.append('\n');
                TextView result = (TextView) activity.findViewById(R.id.result);
                result.setText(sb);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    public static void FileWriter(Map<String, Integer> values, Context context){
        String fileName = "test";
        FileOutputStream outputStream;

        try{
            outputStream = context.openFileOutput(fileName, Context.MODE_APPEND | Context.MODE_PRIVATE);
            outputStream.write(values.toString().getBytes());
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
