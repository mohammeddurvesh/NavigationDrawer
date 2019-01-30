package com.example.navigationdrawer;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawer =findViewById(R.id.drawer_layout);
        NavigationView navigationView=findViewById(R.id.view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle=new ActionBarDrawerToggle(this,drawer,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        if(savedInstanceState==null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new messagefragment()).commit();
            navigationView.setCheckedItem(R.id.msg);
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.msg:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new messagefragment()).commit();
                break;
            case R.id.chat:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new chatfragment()).commit();
                break;
            case R.id.person:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new profilefragment()).commit();
                break;
            case R.id.send:
                Toast.makeText(this,"send",Toast.LENGTH_SHORT).show();
                break;
            case R.id.share:
                Toast.makeText(this,"share",Toast.LENGTH_SHORT).show();
                break;
        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        if(drawer.isDrawerOpen(GravityCompat.START)){
            drawer.closeDrawer(GravityCompat.START);
        }
        else {
            super.onBackPressed();
        }
    }
}
