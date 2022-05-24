package com.example.greenhouseappnew.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.widget.Toast;

import com.example.greenhouseappnew.databinding.ActivityMainBinding;
import com.example.greenhouseappnew.ui.viewmodel.GreenhousesViewModel;
import com.example.greenhouseappnew.R;
import com.example.greenhouseappnew.adapters.GreenhouseAdapter;
import com.example.greenhouseappnew.model.Greenhouse;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityMainBinding binding;

    public static final String MAIN_GREENHOUSE_ID = "com.example.and_recipeapp.MAIN_GREENHOUSE_ID";
    public static final String MAIN_GREENHOUSE_NAME = "com.example.and_recipeapp.MAIN_GREENHOUSE_NAME";
    public static final String MAIN_GREENHOUSE_LOCATION = "com.example.and_recipeapp.MAIN_GREENHOUSE_LOCATION";
    public static final String MAIN_GREENHOUSE_DESCRIPTION = "com.example.and_recipeapp.MAIN_GREENHOUSE_DESCRIPTION";
    public static final String MAIN_GREENHOUSE_AREA = "com.example.and_recipeapp.MAIN_GREENHOUSE_AREA";
    public static final String MAIN_GREENHOUSE_PREFERRED_CO2 = "com.example.and_recipeapp.MAIN_GREENHOUSE_PREFERRED_CO2";
    public static final String MAIN_GREENHOUSE_PREFERRED_HUMIDITY = "com.example.and_recipeapp.MAIN_GREENHOUSE_PREFERRED_HUMIDITY";
    public static final String MAIN_GREENHOUSE_PREFERRED_TEMPERATURE = "com.example.and_recipeapp.MAIN_GREENHOUSE_PREFERRED_TEMPERATURE";

    private GreenhousesViewModel greenhousesViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);
        setTitle("Greenhouses");

        Intent intent = getIntent();
        String userId = intent.getStringExtra("userId");

        // Launcher
        ActivityResultLauncher<Intent> mStartForResult = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {

                    Intent data = result.getData();

                    if(result.getResultCode() == RESULT_OK) {

                        String name = data.getStringExtra(CreateEditGreenhouseActivity.EXTRA_NAME);
                        String location = data.getStringExtra(CreateEditGreenhouseActivity.EXTRA_LOCATION);
                        String description = data.getStringExtra(CreateEditGreenhouseActivity.EXTRA_DESCRIPTION);
                        Double area = Double.parseDouble(data.getStringExtra(CreateEditGreenhouseActivity.EXTRA_AREA));
                        Double co2 = Double.parseDouble(data.getStringExtra(CreateEditGreenhouseActivity.EXTRA_GREENHOUSE_PREFERRED_CO2));
                        Double humidity = Double.parseDouble(data.getStringExtra(CreateEditGreenhouseActivity.EXTRA_GREENHOUSE_PREFERRED_HUMIDITY));
                        Double temp = Double.parseDouble(data.getStringExtra(CreateEditGreenhouseActivity.EXTRA_GREENHOUSE_PREFERRED_TEMPERATURE));

                        Greenhouse greenhouse = new Greenhouse(name, location, description, area, co2, humidity, temp);
                        greenhousesViewModel.insert(greenhouse);
                        Toast.makeText(this, "Greenhouse created...", Toast.LENGTH_SHORT).show();

                    }
                    else {

                        Toast.makeText(this, "Greenhouse not saved...", Toast.LENGTH_SHORT).show();

                    }
                }
        );

        binding.addGreenhouseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CreateEditGreenhouseActivity.class);
                mStartForResult.launch(intent);
            }
        });

        RecyclerView recyclerView = binding.greenhousesRecyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.hasFixedSize();

        GreenhouseAdapter adapter = new GreenhouseAdapter();
        recyclerView.setAdapter(adapter);

        greenhousesViewModel = new ViewModelProvider(this).get(GreenhousesViewModel.class);
        greenhousesViewModel.getAll().observe(this, (greenhouses) -> {
            adapter.setGreenhouses(greenhouses);
        });

        adapter.setOnItemClickListener(new GreenhouseAdapter.OnItemListClicker() {
            @Override
            public void onItemClick(Greenhouse greenhouse) {
                Intent intent = new Intent(MainActivity.this, GreenhouseActivity.class);
                intent.putExtra(MAIN_GREENHOUSE_ID, greenhouse.getId());
                intent.putExtra(MAIN_GREENHOUSE_NAME, greenhouse.getName());
                intent.putExtra(MAIN_GREENHOUSE_LOCATION, greenhouse.getLocation());
                intent.putExtra(MAIN_GREENHOUSE_DESCRIPTION, greenhouse.getDescription());
                intent.putExtra(MAIN_GREENHOUSE_AREA, greenhouse.getArea());
                intent.putExtra(MAIN_GREENHOUSE_PREFERRED_CO2, greenhouse.getCo2Preferred());
                intent.putExtra(MAIN_GREENHOUSE_PREFERRED_HUMIDITY, greenhouse.getHumidityPreferred());
                intent.putExtra(MAIN_GREENHOUSE_PREFERRED_TEMPERATURE, greenhouse.getTemperaturePreferred());
                startActivity(intent);
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
                greenhousesViewModel.delete(adapter.getGreenhouseAt(viewHolder.getAdapterPosition()));
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
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        return super.onOptionsItemSelected(item);
    }

}