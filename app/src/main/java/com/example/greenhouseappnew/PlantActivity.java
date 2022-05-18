package com.example.greenhouseappnew;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class PlantActivity extends AppCompatActivity {

    private EditText nameTextView, typeTextView, descriptionTextView;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_plant);

        // initialising all views through id defined above
        nameTextView = findViewById(R.id.plantName);
        typeTextView = findViewById(R.id.plantType);
        descriptionTextView = findViewById(R.id.description);
        btn = findViewById(R.id.createPlantButton);

        // Set on Click Listener on Create button
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                setContentView(R.layout.plants_list);
            }
        });
    }

}
