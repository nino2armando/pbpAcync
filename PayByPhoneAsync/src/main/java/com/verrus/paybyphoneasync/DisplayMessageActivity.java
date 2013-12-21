package com.verrus.paybyphoneasync;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.widget.TextView;

public class DisplayMessageActivity extends ActionBarActivity {

    public static String Name;
    public static String Address;
    public static String Number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getIntentAndDisplay();
        setContentView(R.layout.activity_display_message);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }

    }

    public void getIntentAndDisplay(){
        // get the intent
        Intent intent = getIntent();
        String[] message = intent.getStringArrayExtra(MainActivity.EXTRA_MESSAGE);

        Name = message[0];
        Number = message[1];
        Address = message[2];
/*        TextView nameView = new TextView(this);
        nameView.setTextSize(40);

        nameView.setText("Name: " + message[0]);

        TextView numberView = new TextView(this);
        numberView.setTextSize(40);
        numberView.setText("Number: " +message[1]);

        TextView addressView = new TextView(this);
        addressView.setTextSize(40);
        addressView.setText("address: " +message[1]);*/


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.display_message, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()) {
            case R.id.action_settings:
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_display_message, container, false);

            TextView nameView = (TextView)rootView.findViewById(R.id.name_View);
            nameView.setText("Name: " + Name);

            TextView numberView = (TextView)rootView.findViewById(R.id.number_View);
            numberView.setText("Number: " + Number);

            TextView addressView = (TextView)rootView.findViewById(R.id.address_View);
            addressView.setText("Address: " + Address);

            return rootView;
        }

    }

}
