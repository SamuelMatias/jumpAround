package org.academiadecodigo.codezillas.converters;

import org.springframework.stereotype.Component;

@Component
public class LocationtoIataConverter {
    Airports[] airports;

    public LocationtoIataConverter(){
        airports = Airports.values();
    }

    public String converter(String location) {
        for (int i = 0; i < airports.length ; i++) {
            if(airports[i].getLocationServed().equals(location)){
                return airports[i].name();
            }
        }
        return "NoIata";
    }
}
