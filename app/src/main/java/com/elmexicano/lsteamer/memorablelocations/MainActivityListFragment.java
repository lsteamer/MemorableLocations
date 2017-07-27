package com.elmexicano.lsteamer.memorablelocations;

import android.app.Activity;
import android.app.ListFragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by lsteamer on 25/07/2017.
 */

public class MainActivityListFragment extends ListFragment {

    private ArrayList<LocationData> locationData;
    private LocationAdapter locationAdapter;

    public MainActivityListFragment(){

    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);


        locationData = getListValues();



        locationAdapter = new LocationAdapter(getActivity(), locationData);
        setListAdapter(locationAdapter);
    }

    public ArrayList<LocationData> getListValues(){
        ArrayList<LocationData> locData = new ArrayList<>();
        locData.add(new LocationData("Set a new Location..."));
        locData.add(new LocationData("Puerto Mulege", -103.325068f, 20.698140f));

        return locData;
    }


    @Override
    public void onListItemClick(ListView l, View v, int position, long id){
        super.onListItemClick(l, v, position, id);
        //a Method to send the intent
        launchNewActivity(position);
    }

    //Launching a new Activity
    private void launchNewActivity(int position){

        //The information of the location clicked
        LocationData locationData = (LocationData) getListAdapter().getItem(position);
        Intent i = new Intent(getContext(), MapsActivity.class);
        i.putExtra("address", locationData.getAddress());
        i.putExtra("longitude", locationData.getLongitude());
        i.putExtra("latitude", locationData.getLatitude());

        if(position==0)
            startActivityForResult(i, 42);
        else
            startActivity(i);


    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (42 == requestCode) {
            if(resultCode == Activity.RESULT_OK){

                //Get the info
                data.getStringExtra("address");
                data.getFloatExtra("latitude", 0f);
                data.getFloatExtra("longitude", 0f);

                locationData.add(new LocationData(data.getStringExtra("address"), data.getFloatExtra("longitude", 0f), data.getFloatExtra("latitude", 0f)));



                locationAdapter = new LocationAdapter(getActivity(), locationData);
                setListAdapter(locationAdapter);
            }
        }
    }


}
