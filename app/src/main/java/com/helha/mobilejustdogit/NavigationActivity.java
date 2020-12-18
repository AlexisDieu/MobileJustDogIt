package com.helha.mobilejustdogit;

import android.content.Intent;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.Menu;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class NavigationActivity extends AppCompatActivity {


    private AppBarConfiguration mAppBarConfiguration;
    Menu menu;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), EmailFragment.class);
                startActivity(i);
            }
        });




        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        //passage de chaque item dans la bar
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_adoption, R.id.nav_pension,R.id.nav_login,R.id.nav_inscription,R.id.nav_admin,R.id.nav_actuality,R.id.nav_profile)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
        menu = navigationView.getMenu();

        drawer.addDrawerListener(new DrawerLayout.DrawerListener() {

            @Override
            public void onDrawerSlide(@NonNull View drawerView, float slideOffset) {

            }

            @Override
            public void onDrawerOpened(@NonNull View drawerView) {

            }

            @Override
            public void onDrawerClosed(@NonNull View drawerView) {

            }
            @Override
            public void onDrawerStateChanged(int newState) {
                SharedPreferences loginUser = getSharedPreferences("user", Context.MODE_PRIVATE);

                String loginToken = loginUser.getString("loginKey","");
                final int idUser = loginUser.getInt("idKey",0);
                final String roleUser = loginUser.getString("roleKey", "");
                if(idUser == 0 || loginToken ==null){
                    menu.findItem(R.id.nav_actuality).setEnabled(false);
                    menu.findItem(R.id.nav_pension).setEnabled(false);
                    menu.findItem(R.id.nav_logout).setVisible(false);
                    menu.findItem(R.id.nav_profile).setVisible(false);
                    menu.findItem(R.id.nav_login).setVisible(true);
                    menu.findItem(R.id.nav_inscription).setVisible(true);
                    menu.findItem(R.id.nav_admin).setVisible(false);
                }
                else {
                    menu.findItem(R.id.nav_actuality).setEnabled(true);
                    menu.findItem(R.id.nav_pension).setEnabled(true);
                    menu.findItem(R.id.nav_logout).setVisible(true);
                    menu.findItem(R.id.nav_profile).setVisible(true);
                    menu.findItem(R.id.nav_login).setVisible(false);
                    menu.findItem(R.id.nav_inscription).setVisible(false);
                    menu.findItem(R.id.nav_admin).setVisible(false);
                }
                if(roleUser.equals("ADMIN")){
                    menu.findItem(R.id.nav_admin).setVisible(true);
                }
            }
        });

    }



    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

}