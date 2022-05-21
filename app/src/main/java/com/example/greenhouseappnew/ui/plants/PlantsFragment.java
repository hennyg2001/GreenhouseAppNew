package com.example.greenhouseappnew.ui.plants;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.greenhouseappnew.R;
import com.example.greenhouseappnew.adapters.PlantAdapter;
import com.example.greenhouseappnew.model.Plant;
import com.example.greenhouseappnew.ui.plant_profile.PlantProfileFragment;

public class PlantsFragment extends Fragment {

    PlantsViewModel plantsViewModel;

    public PlantsFragment() {
        super(R.layout.fragment_plants);
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {

        plantsViewModel = new ViewModelProvider(requireActivity()).get(PlantsViewModel.class);

        int id = requireArguments().getInt("id");

        RecyclerView recyclerView = getView().findViewById(R.id.plantsRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.hasFixedSize();

        PlantAdapter adapter = new PlantAdapter();
        recyclerView.setAdapter(adapter);

        plantsViewModel.getAll().observe(getViewLifecycleOwner(), (plants) -> {
            adapter.setPlants(plants);
        });

        adapter.setOnItemClickListener(new PlantAdapter.OnItemListClicker() {
            @Override
            public void onItemClick(Plant plant) {

                Bundle plantsBundle = new Bundle();
                plantsBundle.putInt("id", plant.getId());
                plantsBundle.putString("name", plant.getName());
                plantsBundle.putString("type", plant.getType());
                plantsBundle.putString("description", plant.getDescription());

                getParentFragmentManager().beginTransaction()
                        .setReorderingAllowed(true)
                        .add(R.id.plant_profile_Layout, PlantProfileFragment.class, plantsBundle)
                        .commit();
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

    }

}
