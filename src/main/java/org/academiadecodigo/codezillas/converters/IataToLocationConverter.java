package org.academiadecodigo.codezillas.converters;

public class IataToLocationConverter {
    Airports[] airports;

    public IataToLocationConverter(){
        airports = Airports.values();
    }

    public String converter(String Iata) {
        for (int i = 0; i < airports.length ; i++) {
            if(airports[i].name().equals(Iata)){
                return airports[i].getLocationServed();
            }
        }
        return "NoAirport";
    }
}
