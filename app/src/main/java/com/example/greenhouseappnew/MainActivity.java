package com.example.greenhouseappnew;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.widget.Toast;

import com.example.greenhouseappnew.adapters.GreenhouseAdapter;
import com.example.greenhouseappnew.model.Greenhouse;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.github.*;

import com.example.greenhouseappnew.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityMainBinding binding;

    private GreenhousesViewModel greenhousesViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.appBarMain.toolbar);

        // Launcher
        ActivityResultLauncher<Intent> mStartForResult = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {

                    Intent data = result.getData();

                    if(result.getResultCode() == RESULT_OK) {

                        String name = data.getStringExtra(CreateEditGreenhouseActivity.EXTRA_NAME);
                        String type = data.getStringExtra(CreateEditGreenhouseActivity.EXTRA_LOCATION);
                        String description = data.getStringExtra(CreateEditGreenhouseActivity.EXTRA_DESCRIPTION);

                        Greenhouse greenhouse = new Greenhouse(name, type, description);
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
        greenhousesViewModel.getAll().observe(this, (recipes) -> {
            adapter.setGreenhouses(recipes);
        });

        adapter.setOnItemClickListener(new GreenhouseAdapter.OnItemListClicker() {
            @Override
            public void onItemClick(Greenhouse greenhouse) {
                Intent intent = new Intent(MainActivity.this, GreenhouseActivity.class);
                intent.putExtra(GreenhouseActivity.GREENHOUSE_ID, greenhouse.getId());
                intent.putExtra(GreenhouseActivity.GREENHOUSE_NAME, greenhouse.getName());
                intent.putExtra(GreenhouseActivity.GREENHOUSE_LOCATION, greenhouse.getLocation());
                intent.putExtra(GreenhouseActivity.GREENHOUSE_DESCRIPTION, greenhouse.getDescription());
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