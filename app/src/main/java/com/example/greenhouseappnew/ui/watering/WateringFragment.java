package com.example.greenhouseappnew.ui.watering;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.os.CountDownTimer;
import android.widget.ToggleButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.greenhouseappnew.R;

public class WateringFragment extends Fragment {

    private TextView timeRemainingTextView;
    private ToggleButton wateringButton;
    private ProgressBar timeRemainingBar;
    MyCountDownTimer myCountDownTimer;

    private View rootView;

    private WateringViewModel viewModel;

    public WateringFragment() {
        //
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.fragment_watering, container, false);

        Bundle bundle = getArguments();

        int greenhouseId = bundle.getInt("greenhouseId");

        timeRemainingTextView = rootView.findViewById(R.id.time_remaining_tv);

        wateringButton = rootView.findViewById(R.id.wateringButton);

        wateringButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                myCountDownTimer = new MyCountDownTimer(20000, 1000);
                myCountDownTimer.start();
                //viewModel.activateWatering(greenhouseId);
            }
        });

        timeRemainingBar = rootView.findViewById(R.id.time_remaining_bar);

        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {

    }

    public class MyCountDownTimer extends CountDownTimer {

        public MyCountDownTimer(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onTick(long millisUntilFinished) {

            int progress = (int) (millisUntilFinished/1000);

            timeRemainingBar.setProgress(timeRemainingBar.getMax()-progress);
            timeRemainingTextView.setText(String.valueOf(progress));
        }

        @Override
        public void onFinish() {
            wateringButton.setChecked(false);
            timeRemainingBar.setProgress(0);
        }
    }

}


