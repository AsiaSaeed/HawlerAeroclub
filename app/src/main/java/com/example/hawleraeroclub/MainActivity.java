package com.example.hawleraeroclub;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawerLayout = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_bar);
        navigationView.setNavigationItemSelectedListener(this);
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment()).commit();
            navigationView.setCheckedItem(R.id.home);
        }
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else
            super.onBackPressed();

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.players:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new YarizananFragment()).commit();

                break;
            case R.id.games:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new YaryakanFragment()).commit();

                break;
            case R.id.league:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new XwlakananFragment()).commit();

                break;
            case R.id.gallery:
                ArrayList<Integer> images=new ArrayList<>();
                images.add(R.drawable.home);
                images.add(R.drawable.home);
                images.add(R.drawable.home);
                images.add(R.drawable.home);
                images.add(R.drawable.home);
                images.add(R.drawable.home);
                images.add(R.drawable.home);
                images.add(R.drawable.home);
                images.add(R.drawable.home);
                images.add(R.drawable.home);
                images.add(R.drawable.home);
                images.add(R.drawable.home);
                images.add(R.drawable.home);
                images.add(R.drawable.home);
                images.add(R.drawable.home);
                images.add(R.drawable.home);
                Log.d("Error founder", "onNavigationItemSelected: ");
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new GalleryFragment(images,getApplicationContext() )).commit();

                break;
            case R.id.weather:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new WeatherFragment()).commit();

                break;
            case R.id.contact:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new ContactFragment()).commit();

                break;
            case R.id.about_us:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new AboutUsFragment()).commit();

                break;
                case R.id.home:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment()).commit();

                break;

        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}
