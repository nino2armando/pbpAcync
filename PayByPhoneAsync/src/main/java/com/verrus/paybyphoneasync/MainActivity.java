package com.verrus.paybyphoneasync;

import android.app.ActionBar;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.verrus.paybyphoneasync.Services.SharedPreferenceHelper;

import java.util.Map;


public class MainActivity extends ActionBarActivity {

    public final static String EXTRA_MESSAGE = "com.verrus.paybyphoneasync.MESSAGE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //if we wanted to display back all time
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Make sure we're running on Honeycomb or higher to use ActionBar APIs
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB){
            // For the main activity, make sure the app icon in the action bar
            // does not behave as a button
            ActionBar actionBar = getActionBar();
            actionBar.setHomeButtonEnabled(false);
        }

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }

        Map<String, Integer> result = SharedPreferenceHelper.getSharedPref(getApplicationContext());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present.
        //super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.main, menu);

        // configure the searchInfo and add event Listener
/*        MenuItem searchItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);*/
        // then we need to search context

        // action bar
        //getMenuInflater().inflate(R.menu.main_activity_actions, menu);

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

    public void sendMessage(View view){
        Intent sendMessageIntent = new Intent(this, DisplayMessageActivity.class);

        EditText editName = (EditText) findViewById(R.id.edit_name);
        String name = editName.getText().toString();
        if(name.matches("")){
            Toast.makeText(this, "You did not enter a name", Toast.LENGTH_SHORT).show();
            return;
        }

        EditText editNumber = (EditText) findViewById(R.id.edit_number);
        String number = editNumber.getText().toString();
        if(number.matches("")){
            Toast.makeText(this, "You did not enter a number", Toast.LENGTH_SHORT).show();
            return;
        }

        EditText editAddress = (EditText) findViewById(R.id.edit_address);
        String address = editAddress.getText().toString();
        if(address.matches("")){
            Toast.makeText(this, "You did not enter a address", Toast.LENGTH_SHORT).show();
            return;
        }

        String[] userInputs = {name, number, address};

        sendMessageIntent.putExtra(EXTRA_MESSAGE, userInputs);
        startActivity(sendMessageIntent);
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

            View rootView = inflater.inflate(R.layout.fragment_main, container, false);

            return rootView;
        }
    }

}
