package com.example.greenhouseappnew.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import com.example.greenhouseappnew.R;
import com.example.greenhouseappnew.model.Plant;
import com.example.greenhouseappnew.network.GreenhouseRepository;

public class CreateEditPlantActivity extends AppCompatActivity {

    private EditText nameEditView, typeEditView, descriptionEditView;
    private Spinner spinner;
    private Button btn;

    public static final String EXTRA_PLANT_ID = "com.example.and_recipeapp.EXTRA_PLANT_ID";
    public static final String EXTRA_PLANT_NAME = "com.example.and_recipeapp.EXTRA_PLANT_NAME";
    public static final String EXTRA_PLANT_TYPE = "com.example.and_recipeapp.EXTRA_PLANT_TYPE";
    public static final String EXTRA_PLANT_DESCRIPTION = "com.example.and_recipeapp.EXTRA_PLANT_DESCRIPTION";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_plant);

        // initialising all views through id defined above
        nameEditView = findViewById(R.id.plantName);

        spinner = (Spinner) findViewById(R.id.plantTypeSpinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.plant_types_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        descriptionEditView = findViewById(R.id.description);

        btn = findViewById(R.id.createPlantButton);

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

        String name = nameEditView.getText().toString().trim();
        String type = spinner.getSelectedItem().toString().trim();
        String description = descriptionEditView.getText().toString().trim();

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
