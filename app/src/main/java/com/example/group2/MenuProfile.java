package com.example.group2;


import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;


import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.navigation.NavigationView;

public class MenuProfile extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {


        //variables
        DrawerLayout drawerLayout;
        NavigationView navigationView;
        Toolbar toolbar;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_menu_profile);


            //hooks
            drawerLayout = findViewById(R.id.drawer_layout);
            navigationView = findViewById(R.id.nav_view);
            toolbar = findViewById(R.id.toolbar);

            //toolbar
            setSupportActionBar(toolbar);

            //nav_drawer menu
            navigationView.bringToFront();
            ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
            drawerLayout.addDrawerListener(toggle);
            toggle.syncState();

            navigationView.setNavigationItemSelectedListener(this);
        }

        @Override
        public void onBackPressed() {

            if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
                drawerLayout.closeDrawer(GravityCompat.START);
            } else {
                super.onBackPressed();
            }
        }

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

            switch (menuItem.getItemId()) {
                case R.id.book: //bookNow
                    startActivity(new Intent(MenuProfile.this, MenuProfile.class));
                    break;

                case R.id.settingsMenu:
                    startActivity(new Intent(MenuProfile.this, ViewProfile.class));
                    break;

                case R.id.AboutUs:
                    startActivity(new Intent(MenuProfile.this, AboutUs.class));
                    break;

                case R.id.clothes_menu:
                    startActivity(new Intent(MenuProfile.this, MenuProfile.class));
                    break;

                case R.id.contactUs: //contactUs punya part
                    startActivity(new Intent(MenuProfile.this, ContactUs.class));
                    break;

                case R.id.history: //Order History punya part
                    startActivity(new Intent(MenuProfile.this, MenuProfile.class));
                    break;

                case R.id.feedback: //customer feedback punya part
                    startActivity(new Intent(MenuProfile.this, MenuProfile.class));
                    break;
            }
            return true;
        }

    }