package com.elmexicano.lsteamer.memorablelocations;

/**
 * Created by lsteamer on 25/07/2017.
 */

public class LocationData {

    private String address;
    private float longitude, latitude;

    public LocationData(String address, float longitude, float latitude){
        this.address = address;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public LocationData(String starting){
        this.address = starting;
        this.longitude = -1;
        this.latitude = -1;
    }

    public String getAddress(){
        return address;
    }

    public float getLongitude(){
        return longitude;
    }

    public float getLatitude(){
        return latitude;
    }

}
