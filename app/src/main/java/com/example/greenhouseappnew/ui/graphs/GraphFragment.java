package com.example.greenhouseappnew.ui.graphs;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.greenhouseappnew.R;
import com.example.greenhouseappnew.model.LogClass;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;

import java.util.ArrayList;

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
    private ArrayList<LogClass> logList;
    private GraphViewModel viewModel;

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
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.fragment_graph, null);
        viewModel = new ViewModelProvider(this).get(GraphViewModel.class);
        humidityBtn =  root.findViewById(R.id.humidity_btn);
        temperatureBtn = root.findViewById(R.id.temperature_btn);
        co2Btn = root.findViewById(R.id.CO2_btn);
        chart = (LineChart) root.findViewById(R.id.values_chart);


            chart.setDragEnabled(true);
            chart.setScaleEnabled(false);
            chart.setBackgroundColor(Color.WHITE);
            chart.getDescription().setEnabled(false);
            chart.setTouchEnabled(true);

            chart.setDrawGridBackground(false);

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
            yAxis.setAxisMaximum(500f);
            yAxis.setAxisMinimum(0f);
        }

        humidityBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeToHumidity();
            }
        });

        co2Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeToCo2();
            }
        });

        temperatureBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeToTemperature();
            }
        });

        return inflater.inflate(R.layout.fragment_graph, container, false);
    }

    public void changeToHumidity()
    {
        ArrayList<Entry> yValues = new ArrayList<>();

        //Initialize logList with values from viewModel
        logList = (ArrayList<LogClass>) viewModel.getLogList().getValue();

        //Here add value from viewmodel with a for loop
        for(LogClass temp: logList)
        {
            //It can only take float values figure date out
            yValues.add(new Entry(1, Double.valueOf(temp.getHumidity()).floatValue()));
        }
        setData(yValues);

    }

    public void changeToCo2()
    {
        ArrayList<Entry> yValues = new ArrayList<>();
        //Initialize logList with values from viewModel
        //Here add value from viewmodel with a for loop

        for(LogClass temp: logList)
        {
            //It can only take float values figure date out
            yValues.add(new Entry(1, Double.valueOf(temp.getCo2()).floatValue()));
        }
        setData(yValues);
    }


    public void changeToTemperature()
    {
        ArrayList<Entry> yValues = new ArrayList<>();
        //Initialize logList with values from viewModel
        //Here add value from viewmodel with a for loop

        for(LogClass temp: logList)
        {
            //It can only take float values figure date out
            yValues.add(new Entry(1, Double.valueOf(temp.getTemperature()).floatValue()));
        }
        setData(yValues);
    }

    public void setData(ArrayList<Entry> values)
    {
        LineDataSet dataSet = new LineDataSet(values, "Data Set");
        dataSet.setFillAlpha(110);

        ArrayList<ILineDataSet> dataSets = new ArrayList<>();
        dataSets.add(dataSet);
        LineData data = new LineData(dataSets);

        chart.setData(data);
    }
}