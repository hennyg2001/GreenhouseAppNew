package com.example.greenhouseappnew.ui.plants;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.greenhouseappnew.R;
import com.example.greenhouseappnew.activities.CreateEditGreenhouseActivity;
import com.example.greenhouseappnew.activities.CreateEditPlantActivity;
import com.example.greenhouseappnew.activities.MainActivity;
import com.example.greenhouseappnew.adapters.PlantAdapter;
import com.example.greenhouseappnew.model.Plant;
import com.example.greenhouseappnew.ui.plant_profile.PlantProfileFragment;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class PlantsFragment extends Fragment {

    PlantsViewModel plantsViewModel;

    private View rootView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.fragment_plants, container, false);

        plantsViewModel = new ViewModelProvider(requireActivity()).get(PlantsViewModel.class);

        Bundle bundle = getArguments();

        int greenHouseId = bundle.getInt("id");

        RecyclerView recyclerView = rootView.findViewById(R.id.plantsRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.hasFixedSize();

        PlantAdapter adapter = new PlantAdapter();
        recyclerView.setAdapter(adapter);

        plantsViewModel.getAllPlantsByGreenhouse(greenHouseId).observe(getViewLifecycleOwner(), (plants) -> {
            adapter.setPlants(plants);
        });

        adapter.setOnItemClickListener(new PlantAdapter.OnItemListClicker() {
            @Override
            public void onItemClick(Plant plant) {

                Bundle plantBundle = new Bundle();
                plantBundle.putInt("id", plant.getId());
                plantBundle.putString("name", plant.getName());
                plantBundle.putString("type", plant.getScientificName());
                plantBundle.putString("description", plant.getDescription());

                Fragment plantProfileFragment = new PlantProfileFragment();
                plantProfileFragment.setArguments(plantBundle);

                getParentFragmentManager().beginTransaction()
                        .setReorderingAllowed(true)
                        .replace(R.id.fragment_container, plantProfileFragment)
                        .commit();
            }
        });

        FloatingActionButton addPlantButton = rootView.findViewById(R.id.addPlantButton);
        addPlantButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), CreateEditPlantActivity.class);
                intent.putExtra("greenhouseId", greenHouseId);
                startActivity(intent);
            }
        });

        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0,
                ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                plantsViewModel.delete(adapter.getPlantAt(viewHolder.getAdapterPosition()));
            }
        }).attachToRecyclerView(recyclerView);

        return rootView;
    }

}
