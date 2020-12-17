package com.helha.mobilejustdogit;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });




        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_adoption, R.id.nav_pension,R.id.nav_login,R.id.nav_inscription,R.id.nav_actuality)
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

                String loginToken = loginUser.getString("loginKey","oui");
                Log.i("CallAPIactuality", loginToken);
                final int idUser = loginUser.getInt("idKey",0);

                if(idUser == 0 || loginToken ==null){
                    menu.findItem(R.id.nav_actuality).setEnabled(false);
                    menu.findItem(R.id.nav_pension).setEnabled(false);
                    menu.findItem(R.id.nav_logout).setVisible(false);
                    menu.findItem(R.id.nav_profile).setVisible(false);
                }
                else {
                    menu.findItem(R.id.nav_actuality).setEnabled(true);
                    menu.findItem(R.id.nav_pension).setEnabled(true);
                    menu.findItem(R.id.nav_logout).setVisible(true);
                    menu.findItem(R.id.nav_profile).setVisible(true);
                    menu.findItem(R.id.nav_login).setVisible(false);
                    menu.findItem(R.id.nav_inscription).setVisible(false);
                }
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.navigation, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }


    public Menu getMenu() {
        return menu;
    }
}