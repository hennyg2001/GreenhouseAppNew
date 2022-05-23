package com.example.greenhouseappnew.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.greenhouseappnew.ui.graphs.GraphFragment;
import com.example.greenhouseappnew.ui.greenhouse.GreenhouseFragment;
import com.example.greenhouseappnew.ui.viewmodel.GreenhousesViewModel;
import com.example.greenhouseappnew.R;
import com.example.greenhouseappnew.model.Greenhouse;
import com.example.greenhouseappnew.ui.plants.PlantsFragment;
import com.example.greenhouseappnew.ui.watering.WateringFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class GreenhouseActivity extends AppCompatActivity {

    public static final String GREENHOUSE_ID = "com.example.and_recipeapp.GREENHOUSE_ID";
    public static final String GREENHOUSE_NAME = "com.example.and_recipeapp.GREENHOUSE_NAME";
    public static final String GREENHOUSE_LOCATION = "com.example.and_recipeapp.GREENHOUSE_LOCATION";
    public static final String GREENHOUSE_DESCRIPTION = "com.example.and_recipeapp.GREENHOUSE_DESCRIPTION";
    public static final String GREENHOUSE_AREA = "com.example.and_recipeapp.GREENHOUSE_AREA";
    public static final String GREENHOUSE_PREFERRED_CO2 = "com.example.and_recipeapp.GREENHOUSE_PREFERRED_CO2";
    public static final String GREENHOUSE_PREFERRED_HUMIDITY = "com.example.and_recipeapp.GREENHOUSE_PREFERRED_HUMIDITY";
    public static final String GREENHOUSE_PREFERRED_TEMPERATURE = "com.example.and_recipeapp.GREENHOUSE_PREFERRED_TEMPERATURE";

    private GreenhousesViewModel greenhousesViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_greenhouse_main);

        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnItemSelectedListener(navListener);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new GreenhouseFragment()).commit();

        //Intent intent = getIntent();

        /*
        if (savedInstanceState == null) {

            Bundle plantsBundle = new Bundle();
            plantsBundle.putInt("id", intent.getIntExtra(GREENHOUSE_ID, 0) );

            getSupportFragmentManager().beginTransaction()
                    .setReorderingAllowed(true)
                    .add(R.id.greenhouse_fragment_container_view, PlantsFragment.class, plantsBundle)
                    .commit();
        }
         */

        // Launcher
        ActivityResultLauncher<Intent> mStartForResult = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {

                    Intent data = result.getData();

                    if (result.getResultCode() == RESULT_OK) {

                        String name = data.getStringExtra(CreateEditGreenhouseActivity.EXTRA_NAME);
                        String location = data.getStringExtra(CreateEditGreenhouseActivity.EXTRA_LOCATION);
                        String description = data.getStringExtra(CreateEditGreenhouseActivity.EXTRA_DESCRIPTION);
                        Double area = Double.parseDouble(data.getStringExtra(CreateEditGreenhouseActivity.EXTRA_AREA));
                        Double co2 = Double.parseDouble(data.getStringExtra(CreateEditGreenhouseActivity.EXTRA_GREENHOUSE_PREFERRED_CO2));
                        Double humidity = Double.parseDouble(data.getStringExtra(CreateEditGreenhouseActivity.EXTRA_GREENHOUSE_PREFERRED_HUMIDITY));
                        Double temp = Double.parseDouble(data.getStringExtra(CreateEditGreenhouseActivity.EXTRA_GREENHOUSE_PREFERRED_TEMPERATURE));

                        int id = data.getIntExtra(CreateEditGreenhouseActivity.EXTRA_ID, -1);

                        if (id == -1) {
                            Toast.makeText(this, "Greenhouse can't be updated...", Toast.LENGTH_SHORT).show();
                            return;
                        }

                        Greenhouse greenhouse = new Greenhouse(name, location, description, area, co2, humidity, temp);
                        greenhouse.setIdGreenhouse(id);
                        greenhousesViewModel.update(greenhouse);
                        Toast.makeText(this, "Greenhouse updated...", Toast.LENGTH_SHORT).show();

                    } else {

                        Toast.makeText(this, "Greenhouse not saved...", Toast.LENGTH_SHORT).show();

                    }
                }
        );

    }

    private NavigationBarView.OnItemSelectedListener navListener =
            new NavigationBarView.OnItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;

                    switch(item.getItemId()) {
                        case R.id.nav_info:
                            selectedFragment = new GreenhouseFragment();
                            break;

                        case R.id.nav_graphs:
                            selectedFragment = new GraphFragment();
                            break;

                        case R.id.nav_watering:
                            selectedFragment = new WateringFragment();
                            break;

                        case R.id.nav_plants:
                            selectedFragment = new PlantsFragment();
                            break;
                    }

                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();

                    return true;

                }
            };

}
