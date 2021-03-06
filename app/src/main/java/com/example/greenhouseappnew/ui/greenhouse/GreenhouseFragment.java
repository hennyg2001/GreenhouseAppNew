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
        Double area = bundle.getDouble("area");
        Double co2 = bundle.getDouble("co2");
        Double humidity = bundle.getDouble("humidity");
        Double temp = bundle.getDouble("temp");

        nameTextView = rootView.findViewById(R.id.greenhouseNameTv);
        locationTextView = rootView.findViewById(R.id.greenhouseLocationTv);
        descriptionTextView = rootView.findViewById(R.id.greenhouseDescriptionTv);
        areaTextView = rootView.findViewById(R.id.greenhouseAreaTv);
        co2TextView = rootView.findViewById(R.id.greenhouseCo2Tv);
        humidityTextView = rootView.findViewById(R.id.greenhouseHumidityTv);
        tempTextView = rootView.findViewById(R.id.greenhouseTempTv);

        nameTextView.setText(name);
        locationTextView.setText(location);
        descriptionTextView.setText(description);
        areaTextView.setText(Double.toString(area));
        co2TextView.setText(Double.toString(co2));
        humidityTextView.setText(Double.toString(humidity));
        tempTextView.setText(Double.toString(temp));

        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {

    }

}
