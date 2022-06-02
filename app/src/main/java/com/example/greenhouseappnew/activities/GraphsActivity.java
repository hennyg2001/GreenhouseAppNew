package com.example.greenhouseappnew.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import com.example.greenhouseappnew.R;
import com.example.greenhouseappnew.ui.graphs.GraphFragment;
import com.example.greenhouseappnew.ui.graphs.TableFragment;
import com.example.greenhouseappnew.ui.greenhouse.GreenhouseFragment;

public class GraphsActivity extends AppCompatActivity {
    Button tableBtn, graphBtn;
    FrameLayout graphLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graphs);

        tableBtn = findViewById(R.id.table_btn);
        graphBtn = findViewById(R.id.graph_btn);
        graphLayout = findViewById(R.id.graph_frame_layout);

        Fragment graphsFragment = new GraphFragment();
        //graphsFragment.setArguments(greenhouseBundle);

        Fragment tableFragment = new TableFragment();


        graphBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replaceFragment(graphsFragment);
            }
        });

        tableBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replaceFragment(tableFragment);
            }
        });

    }

    private void replaceFragment(Fragment fragment)
    {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.graph_frame_layout, fragment);
        fragmentTransaction.commit();

    }

}