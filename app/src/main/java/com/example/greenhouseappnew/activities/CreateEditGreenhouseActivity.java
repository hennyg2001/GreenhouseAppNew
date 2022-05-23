package com.example.greenhouseappnew.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;

import androidx.appcompat.app.AppCompatActivity;

import com.example.greenhouseappnew.R;
import com.example.greenhouseappnew.network.GreenhouseRepository;

public class CreateEditGreenhouseActivity extends AppCompatActivity {

    public static final String EXTRA_ID = "com.example.and_recipeapp.EXTRA_ID";
    public static final String EXTRA_NAME = "com.example.and_recipeapp.EXTRA_NAME";
    public static final String EXTRA_LOCATION = "com.example.and_recipeapp.EXTRA_LOCATION";
    public static final String EXTRA_DESCRIPTION = "com.example.and_recipeapp.EXTRA_DESCRIPTION";
    public static final String EXTRA_AREA = "com.example.and_recipeapp.EXTRA_AREA";
    public static final String EXTRA_GREENHOUSE_PREFERRED_CO2 = "com.example.and_recipeapp.EXTRA_GREENHOUSE_PREFERRED_CO2";
    public static final String EXTRA_GREENHOUSE_PREFERRED_HUMIDITY = "com.example.and_recipeapp.EXTRA_GREENHOUSE_PREFERRED_HUMIDITY";
    public static final String EXTRA_GREENHOUSE_PREFERRED_TEMPERATURE = "com.example.and_recipeapp.EXTRA_GREENHOUSE_PREFERRED_TEMPERATURE";

    private EditText nameEditText, locationEditText, descriptionEditText, areaEditText, preferredCo2EditText, preferredHumidityEditText, preferredTempEditText;
    private Button createGreenhouseButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_greenhouse);

        nameEditText = findViewById(R.id.greenhouseName);
        locationEditText = findViewById(R.id.greenhouseLocation);
        descriptionEditText = findViewById(R.id.greenhouseDescription);
        areaEditText = findViewById(R.id.greenhouseArea);
        preferredCo2EditText = findViewById(R.id.greenhousePreferredCo2);
        preferredHumidityEditText = findViewById(R.id.greenhousePreferredHumidity);
        preferredTempEditText = findViewById(R.id.greenhousePreferredTemperature);
        createGreenhouseButton = findViewById(R.id.createGreenhouseButton);

        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_close);

        Intent intent = getIntent();

        if(intent.hasExtra(EXTRA_ID)) {

            setTitle("Edit Greenhouse");
            nameEditText.setText(intent.getStringExtra(EXTRA_NAME));
            locationEditText.setText(intent.getStringExtra(EXTRA_LOCATION));
            descriptionEditText.setText(intent.getStringExtra(EXTRA_DESCRIPTION));
            areaEditText.setText(intent.getStringExtra(EXTRA_AREA));
            preferredCo2EditText.setText(intent.getStringExtra(EXTRA_GREENHOUSE_PREFERRED_CO2));
            preferredHumidityEditText.setText(intent.getStringExtra(EXTRA_GREENHOUSE_PREFERRED_HUMIDITY));
            preferredTempEditText.setText(intent.getStringExtra(EXTRA_GREENHOUSE_PREFERRED_TEMPERATURE));

        } else {

            setTitle("Add Greenhouse");

        }

        createGreenhouseButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick (View v){

                saveGreenhouse();

            }

        });

    }

    private void saveGreenhouse() {

        String name = nameEditText.getText().toString().trim();
        String location = locationEditText.getText().toString().trim();
        String description = descriptionEditText.getText().toString().trim();
        String area = areaEditText.getText().toString().trim();
        String preferredCo2 = preferredCo2EditText.getText().toString().trim();
        String preferredHumidity = preferredHumidityEditText.getText().toString().trim();
        String preferredTemp = preferredTempEditText.getText().toString().trim();

        Intent data = new Intent();
        data.putExtra(EXTRA_NAME, name);
        data.putExtra(EXTRA_LOCATION, location);
        data.putExtra(EXTRA_DESCRIPTION, description);
        data.putExtra(EXTRA_AREA, area);
        data.putExtra(EXTRA_GREENHOUSE_PREFERRED_CO2, preferredCo2);
        data.putExtra(EXTRA_GREENHOUSE_PREFERRED_HUMIDITY, preferredHumidity);
        data.putExtra(EXTRA_GREENHOUSE_PREFERRED_TEMPERATURE, preferredTemp);

        int id = getIntent().getIntExtra(EXTRA_ID, -1);
        if(id != -1) {
            data.putExtra(EXTRA_ID, id);
        }

        setResult(RESULT_OK, data);
        finish();

    }

}
