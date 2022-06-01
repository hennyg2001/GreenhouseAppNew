package com.example.greenhouseappnew.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.greenhouseappnew.R;
import com.example.greenhouseappnew.ui.plants.PlantsViewModel;

public class CreateEditPlantActivity extends AppCompatActivity {

    public static final String EXTRA_PLANT_ID = "com.example.greenhouseappnew.EXTRA_PLANT_ID";
    public static final String EXTRA_PLANT_NAME = "com.example.greenhouseappnew.EXTRA_PLANT_NAME";
    public static final String EXTRA_PLANT_TYPE = "com.example.greenhouseappnew.EXTRA_PLANT_TYPE";
    public static final String EXTRA_PLANT_DESCRIPTION = "com.example.greenhouseappnew.EXTRA_PLANT_DESCRIPTION";
    public static final String EXTRA_GREENHOUSE_ID = "com.example.greenhouseappnew.EXTRA_GREENHOUSE_ID";

    private EditText nameEditText, typeEditText, descriptionEditText;
    private Spinner spinner, daySpinner1, daySpinner2, daySpinner3, daySpinner4;
    private Button btn;

    private PlantsViewModel plantsViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_plant);

        setSupportActionBar(findViewById(R.id.add_plant_toolbar));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_close);

        plantsViewModel = new ViewModelProvider(this).get(PlantsViewModel.class);

        // initialising all views through id defined above
        nameEditText = findViewById(R.id.plantName);

        spinner = (Spinner) findViewById(R.id.plantTypeSpinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.plant_types_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        descriptionEditText = findViewById(R.id.description);

        btn = findViewById(R.id.createPlantButton);

        daySpinner1 = (Spinner) findViewById(R.id.daySpinner);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this,
                R.array.days_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        daySpinner1.setAdapter(adapter2);

        daySpinner2 = (Spinner) findViewById(R.id.daySpinner2);
        daySpinner2.setAdapter(adapter2);

        daySpinner3 = (Spinner) findViewById(R.id.daySpinner3);
        daySpinner3.setAdapter(adapter2);

        daySpinner4 = (Spinner) findViewById(R.id.daySpinner4);
        daySpinner4.setAdapter(adapter2);


        Intent intent = getIntent();

        if(intent.hasExtra(EXTRA_PLANT_ID)) {

            setTitle("Edit Plant");
            nameEditText.setText(intent.getStringExtra(EXTRA_PLANT_NAME));
            spinner.setSelection(adapter.getPosition(intent.getStringExtra(EXTRA_PLANT_TYPE)));
            descriptionEditText.setText(intent.getStringExtra(EXTRA_PLANT_DESCRIPTION));

        } else {

            setTitle("Add Plant");

        }

        // Set on Click Listener on Create button
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                savePlant();
            }
        });
    }

    private void savePlant() {

        String name = nameEditText.getText().toString().trim();
        String type = spinner.getSelectedItem().toString().trim();
        String description = descriptionEditText.getText().toString().trim();

        Intent data = new Intent();
        data.putExtra(EXTRA_PLANT_NAME, name);
        data.putExtra(EXTRA_PLANT_TYPE, type);
        data.putExtra(EXTRA_PLANT_DESCRIPTION, description);

        int id = getIntent().getIntExtra(EXTRA_PLANT_ID, -1);
        if(id != -1) {
            data.putExtra(EXTRA_PLANT_ID, id);
        }

        setResult(RESULT_OK, data);

        finish();

    }

}
