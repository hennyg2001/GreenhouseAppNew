package com.example.greenhouseappnew;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;

import androidx.appcompat.app.AppCompatActivity;

import com.example.greenhouseappnew.network.GreenhouseRepository;

public class CreateEditGreenhouseActivity extends AppCompatActivity {

    public static final String EXTRA_ID = "com.example.and_recipeapp.EXTRA_ID";
    public static final String EXTRA_NAME = "com.example.and_recipeapp.EXTRA_NAME";
    public static final String EXTRA_LOCATION = "com.example.and_recipeapp.EXTRA_LOCATION";
    public static final String EXTRA_DESCRIPTION = "com.example.and_recipeapp.EXTRA_DESCRIPTION";

    private EditText nameEditText, locationEditText, descriptionEditText;
    private Button createGreenhouseButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_greenhouse);

        nameEditText = findViewById(R.id.greenhouseName);
        locationEditText = findViewById(R.id.greenhouseLocation);
        descriptionEditText = findViewById(R.id.greenhouseDescription);
        createGreenhouseButton = findViewById(R.id.createGreenhouseButton);

        Intent intent = getIntent();

        if(intent.hasExtra(EXTRA_ID)) {

            setTitle("Edit Greenhouse");
            nameEditText.setText(intent.getStringExtra(EXTRA_NAME));
            locationEditText.setText(intent.getStringExtra(EXTRA_LOCATION));
            descriptionEditText.setText(intent.getStringExtra(EXTRA_DESCRIPTION));

        } else {

            setTitle("Add Recipe");

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

        Intent data = new Intent();
        data.putExtra(EXTRA_NAME, name);
        data.putExtra(EXTRA_LOCATION, location);
        data.putExtra(EXTRA_DESCRIPTION, description);

        int id = getIntent().getIntExtra(EXTRA_ID, -1);
        if(id != -1) {
            data.putExtra(EXTRA_ID, id);
        }

        setResult(RESULT_OK, data);
        finish();

    }

}
