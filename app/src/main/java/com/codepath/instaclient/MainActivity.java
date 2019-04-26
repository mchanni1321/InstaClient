package com.codepath.instaclient;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.codepath.instaclient.fragments.ComposeFragment;
import com.codepath.instaclient.fragments.PostsFragment;
import com.codepath.instaclient.fragments.ProfileFragment;

public class MainActivity extends AppCompatActivity {


    private final String TAG = "MainActivity";


    private BottomNavigationView bottomNavigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final FragmentManager fragmentManager = getSupportFragmentManager();

        bottomNavigationView = findViewById(R.id.bottom_navigation);



        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                Fragment fragment;

                switch(menuItem.getItemId()) {
                    case R.id.action_home:
                        fragment = new PostsFragment();
                        //Toast.makeText(MainActivity.this, "home", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.action_compose:
                        fragment = new ComposeFragment();
                        //Toast.makeText(MainActivity.this, "compose", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.action_profile:
                        default:
                            fragment = new ProfileFragment();
                            //Toast.makeText(MainActivity.this, "profile", Toast.LENGTH_SHORT).show();
                            break;

                }
                fragmentManager.beginTransaction().replace(R.id.flContainer, fragment).commit();
                return true;
            }
        });

        bottomNavigationView.setSelectedItemId(R.id.action_home);


    }


}
