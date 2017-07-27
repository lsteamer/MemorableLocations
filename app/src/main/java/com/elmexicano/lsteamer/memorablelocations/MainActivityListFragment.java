package com.elmexicano.lsteamer.memorablelocations;

import android.app.ListFragment;
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
        LocationData loc = new LocationData("Set a new Location...");
        ArrayList<LocationData> locData = new ArrayList<>();
        locData.add(loc);
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
        if(position==0){
            Toast.makeText(getContext(), "wut",Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(getContext(), "wat",Toast.LENGTH_SHORT).show();

        }

    }




}
