package com.example.greenhouseappnew;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import com.github.mikephil.charting.charts.BarChart;

public class LogsGraphActivity extends AppCompatActivity {

    private BarChart chart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.graphs_activity);
    }
}