package com.elmexicano.lsteamer.memorablelocations;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by lsteamer on 25/07/2017.
 */

public class LocationAdapter extends ArrayAdapter<LocationData> {

    /**
     * The View Holder will hold the id's
     */
    public static class ViewHolder{
        TextView address;

    }

    public LocationAdapter(Context context, ArrayList<LocationData> locations){
        super(context, 0, locations);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){

        //Gets the data item for this position
        LocationData locations = getItem(position);

        //creating a ViewHolder
        ViewHolder viewHolder;

        //Checking if an existing view is being reused, otherwise inflate a new view from custom row layout
        if(convertView == null){

            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.location_list_row, parent, false);

            //Set the references to the viewHolder
            viewHolder.address = (TextView) convertView.findViewById(R.id.locationAddress);

            //Using this tag to extract the references
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }


        //Fills each new referenced view with data associated with the note it's referencing
        viewHolder.address.setText(locations.getAddress());

        //returning the view
        return convertView;
    }


}
