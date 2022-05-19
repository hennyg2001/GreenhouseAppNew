package com.example.greenhouseappnew;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import com.example.greenhouseappnew.model.Greenhouse;

public class GreenhouseActivity extends AppCompatActivity {

    public static final String GREENHOUSE_ID = "com.example.and_recipeapp.GREENHOUSE_ID";
    public static final String GREENHOUSE_NAME = "com.example.and_recipeapp.GREENHOUSE_NAME";
    public static final String GREENHOUSE_LOCATION = "com.example.and_recipeapp.GREENHOUSE_LOCATION";
    public static final String GREENHOUSE_DESCRIPTION = "com.example.and_recipeapp.GREENHOUSE_DESCRIPTION";

    private TextView nameTextView, locationTextView, descriptionTextView;
    private Button closeButton, editButton;

    private GreenhousesViewModel greenhousesViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_greenhouse);

        nameTextView = findViewById(R.id.greenhouseName);
        locationTextView = findViewById(R.id.greenhouseLocation);
        descriptionTextView = findViewById(R.id.greenhouseDescription);
        editButton = findViewById(R.id.editGreenhouseButton);

        Intent intent = getIntent();

        nameTextView.setText(intent.getStringExtra(GREENHOUSE_NAME));
        locationTextView.setText(intent.getStringExtra(GREENHOUSE_LOCATION));
        descriptionTextView.setText(intent.getStringExtra(GREENHOUSE_DESCRIPTION));

        // Launcher
        ActivityResultLauncher<Intent> mStartForResult = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {

                    Intent data = result.getData();

                    if(result.getResultCode() == RESULT_OK) {

                        String name = data.getStringExtra(CreateEditGreenhouseActivity.EXTRA_NAME);
                        String location = data.getStringExtra(CreateEditGreenhouseActivity.EXTRA_LOCATION);
                        String description = data.getStringExtra(CreateEditGreenhouseActivity.EXTRA_DESCRIPTION);

                        int id = data.getIntExtra(CreateEditGreenhouseActivity.EXTRA_ID, -1);

                        if(id == -1) {
                            Toast.makeText(this, "Recipe can't be updated...", Toast.LENGTH_SHORT).show();
                            return;
                        }

                        Greenhouse greenhouse = new Greenhouse(name, location, description);
                        greenhouse.setId(id);
                        greenhousesViewModel.update(greenhouse);
                        Toast.makeText(this, "Recipe updated...", Toast.LENGTH_SHORT).show();

                    }
                    else {

                        Toast.makeText(this, "Recipe not saved...", Toast.LENGTH_SHORT).show();

                    }
                }
        );

        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v){

                finish();

            }
        });

        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v){

                Intent it = new Intent(GreenhouseActivity.this, CreateEditGreenhouseActivity.class);
                it.putExtra(CreateEditGreenhouseActivity.EXTRA_ID, intent.getStringExtra(GREENHOUSE_ID));
                it.putExtra(CreateEditGreenhouseActivity.EXTRA_NAME, intent.getStringExtra(GREENHOUSE_NAME));
                it.putExtra(CreateEditGreenhouseActivity.EXTRA_LOCATION, intent.getStringExtra(GREENHOUSE_LOCATION));
                it.putExtra(CreateEditGreenhouseActivity.EXTRA_DESCRIPTION, intent.getStringExtra(GREENHOUSE_DESCRIPTION));
                mStartForResult.launch(it);

            }
        });

}
