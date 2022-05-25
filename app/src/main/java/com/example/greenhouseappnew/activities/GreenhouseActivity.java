package com.example.greenhouseappnew.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.greenhouseappnew.PlantsActivity;
import com.example.greenhouseappnew.model.Plant;
import com.example.greenhouseappnew.ui.graphs.GraphFragment;
import com.example.greenhouseappnew.ui.greenhouse.GreenhouseFragment;
import com.example.greenhouseappnew.ui.plants.PlantsViewModel;
import com.example.greenhouseappnew.ui.viewmodel.GreenhousesViewModel;
import com.example.greenhouseappnew.R;
import com.example.greenhouseappnew.model.Greenhouse;
import com.example.greenhouseappnew.ui.plants.PlantsFragment;
import com.example.greenhouseappnew.ui.watering.WateringFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class GreenhouseActivity extends AppCompatActivity {

    public static final String GREENHOUSE_ID = "com.example.greenhouseappnew.GREENHOUSE_ID";
    public static final String GREENHOUSE_NAME = "com.example.greenhouseappnew.GREENHOUSE_NAME";
    public static final String GREENHOUSE_LOCATION = "com.example.greenhouseappnew.GREENHOUSE_LOCATION";
    public static final String GREENHOUSE_DESCRIPTION = "com.example.greenhouseappnew.GREENHOUSE_DESCRIPTION";
    public static final String GREENHOUSE_AREA = "com.example.greenhouseappnew.GREENHOUSE_AREA";
    public static final String GREENHOUSE_PREFERRED_CO2 = "com.example.greenhouseappnew.GREENHOUSE_PREFERRED_CO2";
    public static final String GREENHOUSE_PREFERRED_HUMIDITY = "com.example.greenhouseappnew.GREENHOUSE_PREFERRED_HUMIDITY";
    public static final String GREENHOUSE_PREFERRED_TEMPERATURE = "com.example.greenhouseappnew.GREENHOUSE_PREFERRED_TEMPERATURE";

    private GreenhousesViewModel greenhousesViewModel;
    private PlantsViewModel plantsViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_greenhouse_main);

        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnItemSelectedListener(navListener);

        setSupportActionBar(findViewById(R.id.greenhouse_toolbar));
        setTitle("Greenhouse");

        Intent intent = getIntent();

        Bundle greenhouseBundle = new Bundle();
        greenhouseBundle.putInt("id", intent.getIntExtra(MainActivity.MAIN_GREENHOUSE_ID, 0));
        greenhouseBundle.putString("name", intent.getStringExtra(MainActivity.MAIN_GREENHOUSE_NAME));
        greenhouseBundle.putString("location", intent.getStringExtra(MainActivity.MAIN_GREENHOUSE_LOCATION));
        greenhouseBundle.putString("description", intent.getStringExtra(MainActivity.MAIN_GREENHOUSE_DESCRIPTION));
        greenhouseBundle.putString("area", intent.getStringExtra(MainActivity.MAIN_GREENHOUSE_AREA));
        greenhouseBundle.putString("co2", intent.getStringExtra(MainActivity.MAIN_GREENHOUSE_PREFERRED_CO2));
        greenhouseBundle.putString("humidity", intent.getStringExtra(MainActivity.MAIN_GREENHOUSE_PREFERRED_HUMIDITY));
        greenhouseBundle.putString("temp", intent.getStringExtra(MainActivity.MAIN_GREENHOUSE_PREFERRED_TEMPERATURE));

        Fragment greenhouseFragment = new GreenhouseFragment();
        greenhouseFragment.setArguments(greenhouseBundle);

        getSupportFragmentManager()
                .beginTransaction()
                .setReorderingAllowed(true)
                .replace(R.id.fragment_container, greenhouseFragment)
                .commit();

    }

    // Launcher
    ActivityResultLauncher<Intent> mStartForResult = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            result -> {

                Intent data = result.getData();

                if(result.getResultCode() == RESULT_OK) {

                    String name = data.getStringExtra(CreateEditPlantActivity.EXTRA_PLANT_NAME);
                    String type = data.getStringExtra(CreateEditPlantActivity.EXTRA_PLANT_TYPE);
                    String description = data.getStringExtra(CreateEditPlantActivity.EXTRA_PLANT_DESCRIPTION);
                    int greenhouseId = data.getIntExtra(CreateEditPlantActivity.EXTRA_GREENHOUSE_ID, 0);

                    Plant plant = new Plant(name, type, description, greenhouseId);
                    plantsViewModel.insert(plant);
                    Toast.makeText(this, "Greenhouse created...", Toast.LENGTH_SHORT).show();

                }
                else {

                    Toast.makeText(this, "Greenhouse not saved...", Toast.LENGTH_SHORT).show();

                }
            });

    private NavigationBarView.OnItemSelectedListener navListener =
            new NavigationBarView.OnItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;

                    Intent intent = getIntent();

                    switch(item.getItemId()) {

                        case R.id.nav_info:

                            Bundle greenhouseBundle = new Bundle();
                            greenhouseBundle.putInt("id", intent.getIntExtra(MainActivity.MAIN_GREENHOUSE_ID, 0));
                            greenhouseBundle.putString("name", intent.getStringExtra(MainActivity.MAIN_GREENHOUSE_NAME));
                            greenhouseBundle.putString("location", intent.getStringExtra(MainActivity.MAIN_GREENHOUSE_LOCATION));
                            greenhouseBundle.putString("description", intent.getStringExtra(MainActivity.MAIN_GREENHOUSE_DESCRIPTION));
                            greenhouseBundle.putString("area", intent.getStringExtra(MainActivity.MAIN_GREENHOUSE_AREA));
                            greenhouseBundle.putString("co2", intent.getStringExtra(MainActivity.MAIN_GREENHOUSE_PREFERRED_CO2));
                            greenhouseBundle.putString("humidity", intent.getStringExtra(MainActivity.MAIN_GREENHOUSE_PREFERRED_HUMIDITY));
                            greenhouseBundle.putString("temp", intent.getStringExtra(MainActivity.MAIN_GREENHOUSE_PREFERRED_TEMPERATURE));

                            Fragment infoFragment = new GreenhouseFragment();
                            infoFragment.setArguments(greenhouseBundle);

                            selectedFragment = infoFragment;
                            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();

                            break;

                        case R.id.nav_graphs:
                            selectedFragment = new GraphFragment();
                            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();

                            break;

                        case R.id.nav_watering:

                            Bundle wateringBundle = new Bundle();
                            wateringBundle.putInt("greenhouseId", intent.getIntExtra(MainActivity.MAIN_GREENHOUSE_ID, 0));

                            WateringFragment wateringFragment = new WateringFragment();
                            wateringFragment.setArguments(wateringBundle);
                            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, wateringFragment).commit();

                            break;

                        case R.id.nav_plants:

                            Intent data = new Intent(GreenhouseActivity.this, PlantsActivity.class);
                            data.putExtra(PlantsActivity.CURRENT_GREENHOUSE_ID, intent.getIntExtra(GREENHOUSE_ID, 0));
                            data.putExtra(PlantsActivity.CURRENT_GREENHOUSE_NAME, intent.getStringExtra(GREENHOUSE_NAME));
                            data.putExtra(PlantsActivity.CURRENT_GREENHOUSE_LOCATION, intent.getStringExtra(GREENHOUSE_LOCATION));
                            data.putExtra(PlantsActivity.CURRENT_GREENHOUSE_DESCRIPTION, intent.getStringExtra(GREENHOUSE_DESCRIPTION));
                            data.putExtra(PlantsActivity.CURRENT_GREENHOUSE_AREA, intent.getStringExtra(GREENHOUSE_AREA));
                            data.putExtra(PlantsActivity.CURRENT_GREENHOUSE_CO2, intent.getStringExtra(GREENHOUSE_PREFERRED_CO2));
                            data.putExtra(PlantsActivity.CURRENT_GREENHOUSE_HUMIDITY, intent.getStringExtra(GREENHOUSE_PREFERRED_HUMIDITY));
                            data.putExtra(PlantsActivity.CURRENT_GREENHOUSE_TEMPERATURE, intent.getStringExtra(GREENHOUSE_PREFERRED_TEMPERATURE));
                            startActivity(data);

                            break;
                    }

                    return true;

                }
            };

    @Override
    public void onRestart() {

        super.onRestart();

        Intent intent = getIntent();

        Bundle greenhouseBundle = new Bundle();
        greenhouseBundle.putInt("id", intent.getIntExtra(GREENHOUSE_ID, 0));
        greenhouseBundle.putString("name", intent.getStringExtra(GREENHOUSE_NAME));
        greenhouseBundle.putString("location", intent.getStringExtra(GREENHOUSE_LOCATION));
        greenhouseBundle.putString("description", intent.getStringExtra(GREENHOUSE_DESCRIPTION));
        greenhouseBundle.putString("area", intent.getStringExtra(GREENHOUSE_AREA));
        greenhouseBundle.putString("co2", intent.getStringExtra(GREENHOUSE_PREFERRED_CO2));
        greenhouseBundle.putString("humidity", intent.getStringExtra(GREENHOUSE_PREFERRED_HUMIDITY));
        greenhouseBundle.putString("temp", intent.getStringExtra(GREENHOUSE_PREFERRED_TEMPERATURE));

        Fragment greenhouseFragment = new GreenhouseFragment();
        greenhouseFragment.setArguments(greenhouseBundle);

        getSupportFragmentManager()
                .beginTransaction()
                .setReorderingAllowed(true)
                .replace(R.id.fragment_container, greenhouseFragment)
                .commit();

    }

}
