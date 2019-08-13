package org.academiadecodigo.codezillas.persistence.repository;

import org.academiadecodigo.codezillas.persistence.model.Location;

import java.util.HashMap;
@org.springframework.stereotype.Repository
public class LocationRepository implements Repository<Location> {

    private HashMap<Integer, Location> locationDB;
    private int locationCounter;

    public Location findById(Integer id) {
        if (locationExist(id)){
            return locationDB.get(id);
        }
        //todo:exception
        return null;
    }

    public void add(Location location) {
        if (!locationExist(location.getId())){
            locationCounter++;
            locationDB.put(locationCounter, location);
        }
        //todo:exception
    }

    public void remove(Location location) {
        if(locationExist(location.getId())){
            locationDB.remove(location);
        }
        //TODO:launch exception
    }

    public void update(Integer id, Location locationUpdated) {
        if (locationExist(id)){
            remove(findById(id));
            locationDB.put(id, locationUpdated);
        }
        //TODO:launch exception
    }

    public boolean locationExist(Integer id) {
        return locationDB.containsKey(id);
    }
}

