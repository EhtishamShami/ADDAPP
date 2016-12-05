package com.example.shami.addapp;

import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import com.hanks.htextview.HTextView;
import com.hanks.htextview.HTextViewType;

import java.util.List;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    HTextView slideup;

    ViewPager viewPager;
    ViewFlipper viewFlipper;
    OnSwipeTouchListener onSwipeTouchListener;
    int[] img={R.drawable.dsposter,R.drawable.bckimge};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);





        viewFlipper=(ViewFlipper)findViewById(R.id.viewFlipper);
        for(int i=0;i<img.length;i++)
        {
            AddViewFlipper(i);
        }

        // To handle Swipe touch
        onSwipeTouchListener = new OnSwipeTouchListener(this) {
            public void onSwipeRight() {
                viewFlipper.showNext();
            }
            public void onSwipeLeft() {
                viewFlipper.showPrevious();
            }
        };

        viewFlipper.setOnTouchListener(onSwipeTouchListener);



        slideup=(HTextView)findViewById(R.id.text);
        slideup.setTypeface(null, Typeface.NORMAL);
        // be sure to set custom typeface before setting the animate type, otherwise the font may not be updated.
        slideup.setAnimateType(HTextViewType.TYPER);
        slideup.animateText("Slide up to earn Rs.5");


           }


    // This method is used to add a ImageView to ViewFlipper
    private void AddViewFlipper(int position){
        ImageView imageView = new ImageView(MainActivity.this);
        imageView.setImageResource(img[position]);
        ViewGroup.LayoutParams imageParams = new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        imageView.setLayoutParams(imageParams);

        viewFlipper.addView(imageView);
    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {

            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_user) {

        } else if (id == R.id.nav_activity) {
            Intent intent=new Intent(this,activityscreen.class);
            startActivity(intent);
        } else if (id == R.id.nav_setting) {

        } else if (id == R.id.nav_logout) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void openapp(View view)
    {
        String TAG="Hey YO";
        final PackageManager pm = getPackageManager();
//get a list of installed apps.
        List<ApplicationInfo> packages = pm.getInstalledApplications(PackageManager.GET_META_DATA);

        for (ApplicationInfo packageInfo : packages) {
            Log.d(TAG, "Installed package :" + packageInfo.packageName);
            Log.d(TAG, "Source dir : " + packageInfo.sourceDir);
            Log.d(TAG, "Launch Activity :" + pm.getLaunchIntentForPackage(packageInfo.packageName));
        }
      /*
        try {
            Drawable icon = getPackageManager().getApplicationIcon("com.facebook.katana");
            img1.setImageDrawable(icon);
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        */

               // Intent launchIntent = getPackageManager().getLaunchIntentForPackage("com.facebook.katana");
                  Intent launchIntent = getPackageManager().getLaunchIntentForPackage("com.google.android.play.games");
                if (launchIntent != null) {
                    startActivity(launchIntent);//null pointer check in case package name was not found
                }



    }


}
