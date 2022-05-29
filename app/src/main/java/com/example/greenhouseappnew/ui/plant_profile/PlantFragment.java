package com.example.greenhouseappnew.ui.plant_profile;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.greenhouseappnew.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PlantFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PlantFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    public static final String PLANT_ID = "com.example.greenhouseappnew.PLANT_ID";
    public static final String PLANT_NAME = "com.example.greenhouseappnew.PLANT_NAME";
    public static final String PLANT_TYPE = "com.example.greenhouseappnew.PLANT_TYPE";
    public static final String PLANT_DESCRIPTION = "com.example.greenhouseappnew.PLANT_DESCRIPTION";

    // TODO: Rename and change types of parameters
    private String mId;
    private String mName;
    private String mType;
    private String mDescription;

    private OnFragmentInteractionListener mListener;

    private TextView nameTextView, typeTextView, descriptionTextView;

    public PlantFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static PlantFragment newInstance(int id, String name, String type, String description) {
        PlantFragment fragment = new PlantFragment();
        Bundle args = new Bundle();
        args.putInt(PLANT_ID, id);
        args.putString(PLANT_NAME, name);
        args.putString(PLANT_TYPE, type);
        args.putString(PLANT_DESCRIPTION, description);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mId = getArguments().getString(PLANT_ID);
            mName = getArguments().getString(PLANT_NAME);
            mType = getArguments().getString(PLANT_TYPE);
            mDescription = getArguments().getString(PLANT_DESCRIPTION);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_plant, container, false);

        nameTextView = view.findViewById(R.id.plantNameTv);
        nameTextView.setText(mName);

        typeTextView = view.findViewById(R.id.plantTypeTv);
        typeTextView.setText(mType);

        descriptionTextView = view.findViewById(R.id.plantDescriptionTv);
        descriptionTextView.setText(mDescription);

        return view;
    }

    public void onButtonPressed(Uri uri) {
        if(mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString());
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }
}