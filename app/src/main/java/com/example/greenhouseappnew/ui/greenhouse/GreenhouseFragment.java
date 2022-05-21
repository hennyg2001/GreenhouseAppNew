package com.example.greenhouseappnew.ui.greenhouse;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.greenhouseappnew.R;

public class GreenhouseFragment extends Fragment {

    private TextView nameTextView, locationTextView, descriptionTextView;
    private Button button;

    public GreenhouseFragment() {
        super(R.layout.fragment_greenhouse_info);
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {

        int id = requireArguments().getInt("id");
        String name = requireArguments().getString("name");
        String location = requireArguments().getString("location");
        String description = requireArguments().getString("description");

        nameTextView = getView().findViewById(R.id.greenhouseName);
        locationTextView = getView().findViewById(R.id.greenhouseLocation);
        descriptionTextView = getView().findViewById(R.id.greenhouseDescription);

        nameTextView.setText(name);
        locationTextView.setText(location);
        descriptionTextView.setText(description);

        button = getView().findViewById(R.id.editGreenhouseButton);
    }

}
