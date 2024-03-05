package com.example.bottomnav;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

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
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button button;

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

        // Makes HomeFragment the main layout
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        HomeFragment homeFragment = new HomeFragment();
        fragmentTransaction.replace(R.id.frame_out, homeFragment);
        fragmentTransaction.commit();


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
            } else if (item.getItemId() == R.id.Message) {
                repFragment(new MessageFragment());
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
                repFragment(new SideHomeFragment());
            } else if (item.getItemId() == R.id.nav_profile) {
                repFragment(new SideProfileFragment());
            } else if (item.getItemId() == R.id.nav_msg) {
                repFragment(new SideMessageFragment());
            } else if (item.getItemId() == R.id.nav_settings) {
                repFragment(new SideSettingsFragment());
            }
            drawerLayout.closeDrawer(GravityCompat.START); // Close drawer after selection
            return true;
        });


        // Click on button next activity code
//        button = (Button) findViewById(R.id.next_button);
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                openActivity2();
//            }
//        });
    }

    //Next button method
//    public void openActivity2(){
//        Intent intent = new Intent(this, Activity2.class);
//        startActivity(intent);
//    }

    //navigation bottom
    private void repFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_out,fragment);
        fragmentTransaction.commit();
    }

    @Override
    public void onClick(View view) {

    }
}