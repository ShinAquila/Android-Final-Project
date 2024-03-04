package com.example.bottomnav;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import com.example.bottomnav.databinding.ActivityMainBinding;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Inflate the layout using view binding
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Set FLAG_FULLSCREEN to hide the status bar
        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
        );

        // Initialize DrawerLayout after setContentView
        final DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);

        findViewById(R.id.imageView).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });

        // Set up bottom navigation
        binding.bottomNavView.setOnItemSelectedListener(item -> {
            if (item.getItemId() == R.id.Home) {
                repFragment(new HomeFragment());
            } else if (item.getItemId() == R.id.Profile) {
                repFragment(new ProfileFragment());
            } else if (item.getItemId() == R.id.Settings) {
                repFragment(new SettingsFragment());
            }
            return true;
        });

        // Set up side navigation
        NavigationView navigationView = findViewById(R.id.navigation_view);
        navigationView.setItemIconTintList(null); // If you have custom icons
        NavController navController = Navigation.findNavController(this, R.id.sideNavHostFragment);
        NavigationUI.setupWithNavController(navigationView, navController);
        navigationView.setNavigationItemSelectedListener(item -> {
            if (item.getItemId() == R.id.nav_home) {
                repFragment(new HomeFragment());
            } else if (item.getItemId() == R.id.nav_profile) {
                repFragment(new ProfileFragment());
            } else if (item.getItemId() == R.id.nav_settings) {
                repFragment(new SettingsFragment());
            }
            drawerLayout.closeDrawer(GravityCompat.START); // Close drawer after selection
            return true;
        });
    }



    //navigation bottom
    private void repFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_out,fragment);
        fragmentTransaction.commit();
    }
}