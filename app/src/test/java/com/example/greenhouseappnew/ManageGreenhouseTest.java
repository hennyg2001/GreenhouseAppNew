package com.example.greenhouseappnew;

import android.app.Activity;
import android.widget.Button;
import android.widget.EditText;

import com.example.greenhouseappnew.activities.GreenhouseActivity;
import com.example.greenhouseappnew.model.Greenhouse;
import com.example.greenhouseappnew.ui.greenhouse.GreenhouseViewModel;

import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.*;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.shadows.ShadowToast;

@RunWith(RobolectricTestRunner.class)
public class ManageGreenhouseTest {
    GreenhouseActivity activity = Robolectric.setupActivity(GreenhouseActivity.class);
    Greenhouse greenhouse = new Greenhouse();
    EditText nameEditText, locationEditText, descriptionEditText, areaEditText, preferredCo2EditText, preferredHumidityEditText, preferredTempEditText;
    GreenhouseViewModel greenhouseViewModel;

    @Test
    public void checkActivityNotNull() throws Exception {
        assertNotNull(activity);
    }

    @Test
    public void addGreenhouse() {
        Button btn = (Button) activity.findViewById(R.id.createGreenhouseButton);
        nameEditText = (EditText) activity.findViewById(R.id.greenhouseName);
        locationEditText = (EditText) activity.findViewById(R.id.greenhouseLocation);
        descriptionEditText = (EditText) activity.findViewById(R.id.greenhouseDescription);
        areaEditText = (EditText) activity.findViewById(R.id.greenhouseArea);
        preferredCo2EditText = (EditText) activity.findViewById(R.id.greenhousePreferredCo2);
        preferredHumidityEditText = (EditText) activity.findViewById(R.id.greenhousePreferredHumidity);
        preferredTempEditText = (EditText) activity.findViewById(R.id.greenhousePreferredTemperature);
        nameEditText.setText("test");
        locationEditText.setText("test");
        descriptionEditText.setText("test");
        areaEditText.setText("800.25");
        preferredCo2EditText.setText("300.25");
        preferredHumidityEditText.setText("300.25");
        preferredTempEditText.setText("300.25");
        btn.performClick();
    }
}
