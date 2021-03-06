package com.teamosc.collegefests;

import android.app.Activity;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.widget.DrawerLayout;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.teamosc.collegefests.fragments.AboutFragment;
import com.teamosc.collegefests.fragments.ContactFragment;
import com.teamosc.collegefests.fragments.EventsFragment;
import com.teamosc.collegefests.fragments.ReachUsFragment;
import com.teamosc.collegefests.fragments.RegisterFragment;
import com.teamosc.collegefests.fragments.UpdatesFragment;

public class MainActivity extends ActionBarActivity
        implements
        NavigationDrawerFragment.NavigationDrawerCallbacks,
        AboutFragment.OnFragmentInteractionListener,
        ContactFragment.OnFragmentInteractionListener,
        EventsFragment.OnFragmentInteractionListener,
        RegisterFragment.OnFragmentInteractionListener,
        UpdatesFragment.OnFragmentInteractionListener
{

    /**
     * Fragment managing the behaviors, interactions and presentation of the navigation drawer.
     */
    private NavigationDrawerFragment mNavigationDrawerFragment;

    /**
     * Used to store the last screen title. For use in {@link #restoreActionBar()}.
     */
    private CharSequence mTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mNavigationDrawerFragment = (NavigationDrawerFragment)
                getSupportFragmentManager().findFragmentById(R.id.navigation_drawer);
        mTitle = getTitle();

        // Set up the drawer.
        mNavigationDrawerFragment.setUp(
                R.id.navigation_drawer,
                (DrawerLayout) findViewById(R.id.drawer_layout));
    }

    @Override
    public void onNavigationDrawerItemSelected(int position, int eventsPosition) {
        // update the main content by replacing fragments
        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment showFragment = null;
        switch (position){
            case 0: showFragment = AboutFragment.newInstance("a", "a"); break;
            case 1: showFragment = EventsFragment.newInstance(eventsPosition, "a"); break;
            case 2: showFragment = UpdatesFragment.newInstance("a", "a"); break;
            case 3: showFragment = RegisterFragment.newInstance("a", "a"); break;
            case 4: showFragment = ContactFragment.newInstance("a", "a"); break;
            case 5: showFragment = ReachUsFragment.newInstance("a", "a"); break;
        }
        fragmentManager.beginTransaction()
                .replace(R.id.container, showFragment)
                .commit();
    }

    public void onSectionAttached(int number) {
        String[] drawerItems = getResources().getStringArray(R.array.drawer_items);
        mTitle = drawerItems[number-1];
    }

    public void restoreActionBar() {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setTitle(mTitle);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (!mNavigationDrawerFragment.isDrawerOpen()) {
            // Only show items in the action bar relevant to this screen
            // if the drawer is not showing. Otherwise, let the drawer
            // decide what to show in the action bar.
            getMenuInflater().inflate(R.menu.main, menu);
            restoreActionBar();
            return true;
        }
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
