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
import com.example.greenhouseappnew.ui.plants.PlantsViewModel;
import com.example.greenhouseappnew.ui.viewmodel.GreenhousesViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class PlantsActivity extends AppCompatActivity {

    public static final String MAIN_PLANT_ID = "com.example.greenhouseappnew.MAIN_PLANT_ID";
    public static final String MAIN_PLANT_NAME = "com.example.greenhouseappnew.MAIN_PLANT_NAME";
    public static final String MAIN_PLANT_TYPE = "com.example.greenhouseappnew.MAIN_PLANT_TYPE";
    public static final String MAIN_PLANT_DESCRIPTION = "com.example.greenhouseappnew.MAIN_PLANT_DESCRIPTION";

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
            NavUtils.navigateUpFromSameTask(this);
        }
        return super.onOptionsItemSelected(item);
    }

}
