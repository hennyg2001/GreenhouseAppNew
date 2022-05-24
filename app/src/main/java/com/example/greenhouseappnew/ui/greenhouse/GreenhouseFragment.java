package com.example.greenhouseappnew.ui.greenhouse;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.greenhouseappnew.R;
import com.example.greenhouseappnew.activities.CreateEditGreenhouseActivity;
import com.example.greenhouseappnew.activities.GreenhouseActivity;
import com.example.greenhouseappnew.activities.MainActivity;

public class GreenhouseFragment extends Fragment {

    private TextView nameTextView, locationTextView, descriptionTextView, areaTextView, co2TextView, humidityTextView, tempTextView;
    private Button button;

    private View rootView;

    public GreenhouseFragment() {
        //
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.fragment_greenhouse_info, container, false);

        Bundle bundle = getArguments();

        String name = bundle.getString("name");
        String location = bundle.getString("location");
        String description = bundle.getString("description");
        String area = bundle.getString("area");
        String co2 = bundle.getString("co2");
        String humidity = bundle.getString("humidity");
        String temp = bundle.getString("temp");

        nameTextView = rootView.findViewById(R.id.greenhouseNameTv);
        locationTextView = rootView.findViewById(R.id.greenhouseLocationTv);
        descriptionTextView = rootView.findViewById(R.id.greenhouseDescriptionTv);
        areaTextView = rootView.findViewById(R.id.greenhouseAreaTv);
        co2TextView = rootView.findViewById(R.id.greenhouseCo2Tv);
        humidityTextView = rootView.findViewById(R.id.greenhouseHumidityTv);
        tempTextView = rootView.findViewById(R.id.greenhouseTempTv);
        button = rootView.findViewById(R.id.editGreenhouseButton);

        nameTextView.setText(name);
        locationTextView.setText(location);
        descriptionTextView.setText(description);
        areaTextView.setText(area);
        co2TextView.setText(co2);
        humidityTextView.setText(humidity);
        tempTextView.setText(temp);

        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

}
