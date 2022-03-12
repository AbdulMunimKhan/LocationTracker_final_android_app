package com.amkzone.locationtracker;

import androidx.appcompat.app.AppCompatActivity;

import android.location.Location;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.android.material.snackbar.Snackbar;

import java.util.List;

public class ShowSavedLocationsList extends AppCompatActivity {

    ListView lv_savedLocations;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_saved_locations_list);

            lv_savedLocations = findViewById(R.id.lv_wayPoints);

            MyApplication myApplication = (MyApplication)getApplicationContext();
            List<Location> savedLocations = myApplication.getMyLocations();

            //savedLocations.forEach((location)->print(location));
            lv_savedLocations.setAdapter(new ArrayAdapter<Location>(this, android.R.layout.simple_list_item_1, savedLocations));
            //ArrayAdapter<Location> adapter = new ArrayAdapter<>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, savedLocations);

            //lv_savedLocations.setAdapter(adapter);

            }
            private void print(Location location){
                System.out.println("Location is " + location.getLatitude());
            }
    private void showSnackbar(String msg){
        View container = findViewById(R.id.container);

        Snackbar.make(container, msg, Snackbar.LENGTH_LONG)
                .setAction("CLOSE", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                    }
                })
                .setActionTextColor(getResources().getColor(android.R.color.holo_red_light ))
                .show();
    }
}