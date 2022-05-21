package com.example.greenhouseappnew.ui.watering;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.greenhouseappnew.R;

public class WateringFragment extends Fragment {

    private TextView timeRemainingTextView;
    private Button wateringButton;
    private ProgressBar timeRemainingBar;

    private WateringViewModel viewModel;

    public WateringFragment() {
        super(R.layout.fragment_watering);
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {

        int id = requireArguments().getInt("id");

        timeRemainingTextView = getView().findViewById(R.id.time_remaining_tv);

        wateringButton = getView().findViewById(R.id.wateringButton);
        wateringButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                viewModel.activateWatering(id);
            }
        });

        timeRemainingBar = getView().findViewById(R.id.time_remaining_bar);
    }

}
