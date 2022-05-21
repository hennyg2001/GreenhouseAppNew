package com.example.greenhouseappnew.ui.greenhouse;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.greenhouseappnew.R;

public class GreenhouseFragment extends Fragment {

    private TextView nameTextView, locationTextView, descriptionTextView, areaTextView, co2TextView, humidityTextView, tempTextView;
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
        String area = requireArguments().getString("area");
        String co2 = requireArguments().getString("co2");
        String humidity = requireArguments().getString("humidity");
        String temp = requireArguments().getString("temperature");

        nameTextView = getView().findViewById(R.id.greenhouseNameTv);
        locationTextView = getView().findViewById(R.id.greenhouseLocationTv);
        descriptionTextView = getView().findViewById(R.id.greenhouseDescriptionTv);
        areaTextView = getView().findViewById(R.id.greenhouseAreaTv);
        co2TextView = getView().findViewById(R.id.greenhouseCo2Tv);
        humidityTextView = getView().findViewById(R.id.greenhouseHumidityTv);
        tempTextView = getView().findViewById(R.id.greenhouseTempTv);

        nameTextView.setText(name);
        locationTextView.setText(location);
        descriptionTextView.setText(description);
        areaTextView.setText(area);
        co2TextView.setText(co2);
        humidityTextView.setText(humidity);
        tempTextView.setText(temp);

        button = getView().findViewById(R.id.editGreenhouseButton);
    }

}
