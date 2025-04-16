package com.agrisuro.app;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(navListener);

        // Set default fragment
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new WeatherFragment()).commit();
        }
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull android.view.MenuItem item) {
                    Fragment selectedFragment = null;

                    switch (item.getItemId()) {
                        case R.id.nav_weather:
                            selectedFragment = new WeatherFragment();
                            break;
                        case R.id.nav_variants:
                            selectedFragment = new VariantsFragment();
                            break;
                        case R.id.nav_diseases:
                            selectedFragment = new DiseasesFragment();
                            break;
                        case R.id.nav_weeds:
                            selectedFragment = new WeedsFragment();
                            break;
                        case R.id.nav_pesticides:
                            selectedFragment = new PesticidesFragment();
                            break;
                        case R.id.nav_expense:
                            selectedFragment = new ExpenseTrackerFragment();
                            break;
                    }

                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            selectedFragment).commit();

                    return true;
                }
            };
}
