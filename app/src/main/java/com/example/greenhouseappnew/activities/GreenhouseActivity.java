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

        //getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new GreenhouseFragment()).commit();

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
                            selectedFragment = new WateringFragment();
                            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();

                            break;

                        case R.id.nav_plants:

                            /*
                            Bundle plantBundle = new Bundle();
                            plantBundle.putInt("id", intent.getIntExtra(MainActivity.MAIN_GREENHOUSE_ID, 0));

                            Fragment plantsFragment = new PlantsFragment();
                            plantsFragment.setArguments(plantBundle);

                            selectedFragment = plantsFragment;

                             */

                            Intent data = new Intent(GreenhouseActivity.this, PlantsActivity.class);
                            mStartForResult.launch(data);

                            break;
                    }

                    return true;

                }
            };

}
