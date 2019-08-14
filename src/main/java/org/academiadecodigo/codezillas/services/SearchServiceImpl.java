package org.academiadecodigo.codezillas.services;

import org.academiadecodigo.codezillas.controller.rest.flightAPI.ResultPOJO;
import org.academiadecodigo.codezillas.controller.rest.flightAPI.FlightAPI;
import org.academiadecodigo.codezillas.controller.web.ResultController;
import org.academiadecodigo.codezillas.converters.Airports;
import org.academiadecodigo.codezillas.converters.LocationtoIataConverter;
import org.academiadecodigo.codezillas.DTO.SearchDto;
import org.academiadecodigo.codezillas.persistence.model.Location;
import org.academiadecodigo.codezillas.persistence.model.SearchDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class SearchServiceImpl implements SearchService {

    private LocationtoIataConverter iataConverter;
    private FlightAPI flightAPI;
    private SearchDto dto;

    //IATA Code - Origin location

    //Budget

    @Override
    public LinkedList<ResultPOJO> searchDestinations(SearchDto searchDetails) {
        SearchDto searchDto = searchDetails;
        searchDto.setIata(convertSearchDetails(searchDetails));
        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd"); //"yyyy-mm-dd hh:mm:ss"

        LinkedList<ResultPOJO> resultPOJOS = new LinkedList<>();
        for (Airports airport: Airports.values()){
            resultPOJOS.add(flightAPI.getResponse(searchDto.getIata(), airport.name(), dateFormat.format(searchDto.getCheckIn())));
        }


        //LinkedList<ResultPOJO> resultPOJOS = flightAPI.getResponse(searchDto.getIata(), "   ", searchDto.getCheckIn());
        //LinkedList<ResultPOJO> resultPOJOS = flightAPI.getResponse(searchDto.getIata() + "/   /", searchDto.getCheckIn());
        LinkedList<ResultPOJO> destinations = filterDestinations(searchDto, resultPOJOS);

        return destinations;
    }

    private String convertSearchDetails(SearchDto searchDetails){

        String origin = searchDetails.getOrigin();
        return iataConverter.converter(origin);
    }

    private LinkedList<ResultPOJO> filterDestinations(SearchDto searchDto, LinkedList<ResultPOJO> ResultPojos) {
        Airports[] airports = Airports.values();
        List<ResultPOJO> found = new ArrayList<>();

        for (ResultPOJO ResultPOJOObject: ResultPojos) {
            if (searchDto.getBudget() > Integer.parseInt(ResultPOJOObject.getPrice())){
                found.add(ResultPOJOObject);
            }
        }
        ResultPojos.removeAll(found);

        found = new ArrayList<>();
        for (ResultPOJO ResultPOJOObject: ResultPojos) {
            for (Airports airport: airports) {
                if (!ResultPOJOObject.getiATAcode().equals(airport.name())){
                    found.add(ResultPOJOObject);
                }
            }
        }
        ResultPojos.removeAll(found);

        return ResultPojos;

    }

    public SearchDto getDto() {
        return dto;
    }

    public void setDto(SearchDto dto) {
        this.dto = dto;
    }
}
