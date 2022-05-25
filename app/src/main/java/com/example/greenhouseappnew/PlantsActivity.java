package com.example.greenhouseappnew;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.Toolbar;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NavUtils;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.greenhouseappnew.activities.CreateEditGreenhouseActivity;
import com.example.greenhouseappnew.activities.CreateEditPlantActivity;
import com.example.greenhouseappnew.activities.GreenhouseActivity;
import com.example.greenhouseappnew.activities.MainActivity;
import com.example.greenhouseappnew.adapters.GreenhouseAdapter;
import com.example.greenhouseappnew.adapters.PlantAdapter;
import com.example.greenhouseappnew.databinding.ActivityMainBinding;
import com.example.greenhouseappnew.model.Greenhouse;
import com.example.greenhouseappnew.model.Plant;
import com.example.greenhouseappnew.ui.greenhouse.GreenhouseFragment;
import com.example.greenhouseappnew.ui.plant_profile.PlantProfileFragment;
import com.example.greenhouseappnew.ui.plants.PlantsViewModel;
import com.example.greenhouseappnew.ui.viewmodel.GreenhousesViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class PlantsActivity extends AppCompatActivity {

    public static final String MAIN_PLANT_ID = "com.example.greenhouseappnew.MAIN_PLANT_ID";
    public static final String MAIN_PLANT_NAME = "com.example.greenhouseappnew.MAIN_PLANT_NAME";
    public static final String MAIN_PLANT_TYPE = "com.example.greenhouseappnew.MAIN_PLANT_TYPE";
    public static final String MAIN_PLANT_DESCRIPTION = "com.example.greenhouseappnew.MAIN_PLANT_DESCRIPTION";

    public static final String CURRENT_GREENHOUSE_ID = "com.example.greenhouseappnew.CURRENT_GREENHOUSE_ID";
    public static final String CURRENT_GREENHOUSE_NAME = "com.example.greenhouseappnew.CURRENT_GREENHOUSE_NAME";
    public static final String CURRENT_GREENHOUSE_LOCATION = "com.example.greenhouseappnew.CURRENT_GREENHOUSE_LOCATION";
    public static final String CURRENT_GREENHOUSE_DESCRIPTION = "com.example.greenhouseappnew.CURRENT_GREENHOUSE_DESCRIPTION";
    public static final String CURRENT_GREENHOUSE_AREA = "com.example.greenhouseappnew.CURRENT_GREENHOUSE_AREA";
    public static final String CURRENT_GREENHOUSE_CO2 = "com.example.greenhouseappnew.CURRENT_GREENHOUSE_CO2";
    public static final String CURRENT_GREENHOUSE_HUMIDITY = "com.example.greenhouseappnew.CURRENT_GREENHOUSE_HUMIDITY";
    public static final String CURRENT_GREENHOUSE_TEMPERATURE = "com.example.greenhouseappnew.CURRENT_GREENHOUSE_TEMPERATURE";

    private PlantsViewModel plantsViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_plants);

        setSupportActionBar(findViewById(R.id.plants_toolbar));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_close);
        setTitle("Plants");

        Intent intent = getIntent();
        int greenhouseId = intent.getIntExtra("greenhouseId", 0);

        // Launcher
        ActivityResultLauncher<Intent> mStartForResult = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {

                    Intent data = result.getData();

                    if(result.getResultCode() == RESULT_OK) {

                        String name = data.getStringExtra(CreateEditPlantActivity.EXTRA_PLANT_NAME);
                        String type = data.getStringExtra(CreateEditPlantActivity.EXTRA_PLANT_TYPE);
                        String description = data.getStringExtra(CreateEditPlantActivity.EXTRA_PLANT_DESCRIPTION);

                        Plant plant = new Plant(name, type, description, greenhouseId);
                        plantsViewModel.insert(plant);
                        Toast.makeText(this, "Plant created...", Toast.LENGTH_SHORT).show();

                    }
                    else {

                        Toast.makeText(this, "Plant not saved...", Toast.LENGTH_SHORT).show();

                    }
                }
        );

        FloatingActionButton addPlantButton = findViewById(R.id.addPlantButton);

        addPlantButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PlantsActivity.this, CreateEditPlantActivity.class);
                mStartForResult.launch(intent);
            }
        });

        RecyclerView recyclerView = findViewById(R.id.plantsRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.hasFixedSize();

        PlantAdapter adapter = new PlantAdapter();
        recyclerView.setAdapter(adapter);

        plantsViewModel = new ViewModelProvider(this).get(PlantsViewModel.class);
        plantsViewModel.getAllPlantsByGreenhouse(greenhouseId).observe(this, (plants) -> {
            adapter.setPlants(plants);
        });

        adapter.setOnItemClickListener(new PlantAdapter.OnItemListClicker() {
            @Override
            public void onItemClick(Plant plant) {
                Bundle plantBundle = new Bundle();
                plantBundle.putInt("id", plant.getId());
                plantBundle.putString("name", plant.getName());
                plantBundle.putString("type", plant.getType());
                plantBundle.putString("description", plant.getDescription());
                Fragment plantProfileFragment = new PlantProfileFragment();
                plantProfileFragment.setArguments(plantBundle);
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, plantProfileFragment).commit();
            }
        });

        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0,
                ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                plantsViewModel.delete(adapter.getPlantAt(viewHolder.getAdapterPosition()));
                Toast.makeText(getApplicationContext(), "Plant successfully deleted...", Toast.LENGTH_SHORT).show();
            }
        }).attachToRecyclerView(recyclerView);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if (id == android.R.id.home) {

            Intent intent = getIntent();

            Intent data = new Intent(PlantsActivity.this, GreenhouseActivity.class);
            data.putExtra(GreenhouseActivity.GREENHOUSE_ID, intent.getIntExtra(CURRENT_GREENHOUSE_ID, 0));
            data.putExtra(GreenhouseActivity.GREENHOUSE_NAME, intent.getStringExtra(CURRENT_GREENHOUSE_NAME));
            data.putExtra(GreenhouseActivity.GREENHOUSE_LOCATION, intent.getStringExtra(CURRENT_GREENHOUSE_LOCATION));
            data.putExtra(GreenhouseActivity.GREENHOUSE_DESCRIPTION, intent.getStringExtra(CURRENT_GREENHOUSE_DESCRIPTION));
            data.putExtra(GreenhouseActivity.GREENHOUSE_AREA, intent.getDoubleExtra(CURRENT_GREENHOUSE_AREA, 1));
            data.putExtra(GreenhouseActivity.GREENHOUSE_PREFERRED_CO2, intent.getDoubleExtra(CURRENT_GREENHOUSE_CO2, 1));
            data.putExtra(GreenhouseActivity.GREENHOUSE_PREFERRED_HUMIDITY, intent.getDoubleExtra(CURRENT_GREENHOUSE_HUMIDITY, 1));
            data.putExtra(GreenhouseActivity.GREENHOUSE_PREFERRED_TEMPERATURE, intent.getDoubleExtra(CURRENT_GREENHOUSE_TEMPERATURE, 1));
            startActivity(data);
            finish();

        }
        return super.onOptionsItemSelected(item);
    }

}
