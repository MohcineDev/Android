package com.moh.navfragment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        navigationView = findViewById(R.id.bottomNav);
        navigationView.setOnNavigationItemSelectedListener(listener);

        getSupportFragmentManager().beginTransaction().replace(R.id.frame, new Home()).commit();
    }

    BottomNavigationView.OnNavigationItemSelectedListener listener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            Fragment selectedFragment = null;
            switch (menuItem.getItemId()) {
                case R.id.home:
                    selectedFragment = new Home();
                    break;
                    case R.id.archive:
                    selectedFragment = new Archive();
                    break;
                case R.id.location:
                    selectedFragment = new Location();
                    break;
                case R.id.save:
                    selectedFragment = new Save();
                    break;
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.frame, selectedFragment).commit();
            return true;
        }
    };
}
