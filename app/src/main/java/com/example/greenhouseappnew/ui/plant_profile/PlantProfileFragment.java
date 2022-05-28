package com.example.greenhouseappnew.ui.plant_profile;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.greenhouseappnew.R;

public class PlantProfileFragment extends Fragment {

    private TextView nameTextView, typeTextView, descriptionTextView;
    private Button button;

    public PlantProfileFragment() {
        super(R.layout.fragment_plant_profile);
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {

        int id = requireArguments().getInt("id");
        String name = requireArguments().getString("name");
        String type = requireArguments().getString("type");
        String description = requireArguments().getString("description");

        nameTextView = getView().findViewById(R.id.plantName);
        typeTextView = getView().findViewById(R.id.plantType);
        descriptionTextView = getView().findViewById(R.id.plantDescription);

        nameTextView.setText(name);
        typeTextView.setText(type);
        descriptionTextView.setText(description);

    }

}
