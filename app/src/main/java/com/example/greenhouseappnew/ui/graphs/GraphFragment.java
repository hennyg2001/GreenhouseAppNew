package com.example.greenhouseappnew.ui.graphs;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.greenhouseappnew.R;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link GraphFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class GraphFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters

    private LineChart chart;
    private Button humidityBtn;
    private Button temperatureBtn;
    private Button co2Btn;

    public GraphFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment GraphFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static GraphFragment newInstance(String param1, String param2) {
        GraphFragment fragment = new GraphFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);





    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.fragment_graph, null);
        humidityBtn = (Button) root.findViewById(R.id.humidity_btn);
        temperatureBtn = root.findViewById(R.id.temperature_btn);
        co2Btn = root.findViewById(R.id.CO2_btn);


        {   // // Chart Style // //
            chart = (LineChart) root.findViewById(R.id.values_chart);

            // background color
            chart.setBackgroundColor(Color.WHITE);

            // disable description text
            chart.getDescription().setEnabled(false);

            // enable touch gestures
            chart.setTouchEnabled(true);

            // set listeners

            chart.setDrawGridBackground(false);

            // create marker to display box when values are selected

            XAxis xAxis;
            {   // // X-Axis Style // //
                xAxis = chart.getXAxis();

                // vertical grid lines
                xAxis.enableGridDashedLine(10f, 10f, 0f);
            }

            YAxis yAxis;
            {   // // Y-Axis Style // //
                yAxis = chart.getAxisLeft();

                // disable dual axis (only use LEFT axis)
                chart.getAxisRight().setEnabled(false);

                // horizontal grid lines
                yAxis.enableGridDashedLine(10f, 10f, 0f);

                // axis range
                yAxis.setAxisMaximum(200f);
                yAxis.setAxisMinimum(-50f);
            }
        }

        return inflater.inflate(R.layout.fragment_graph, container, false);
    }
}