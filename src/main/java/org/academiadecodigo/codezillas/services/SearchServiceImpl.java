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

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class SearchServiceImpl implements SearchService {

    private LocationtoIataConverter iataConverter;
    private FlightAPI flightAPI;
    private SearchDto dto;

    //IATA Code - Origin location

    //Budget

    @Override
    public List<Location> searchDestinations(SearchDto searchDetails) {
        SearchDto searchDto = searchDetails;
        searchDto.setIata(convertSearchDetails(searchDetails));
        //LinkedList<ResultPOJO> resultPOJOS = flightAPI.getResponse(searchDto.getIata() + "/" + "   " + "/" + searchDto.getCheckIn());



        return null; // return converted alex result
    }

    private String convertSearchDetails(SearchDto searchDetails){

        String origin = searchDetails.getOrigin();
        return iataConverter.converter(origin);
    }

    private List<ResultPOJO> filterDestinations(SearchDto searchDto, LinkedList<ResultPOJO> ResultPojos) {
        Airports[] airports = Airports.values();

        for (ResultPOJO ResultPOJOObject: ResultPojos) {
        //    if (searchDto.getBudget() > ResultPOJOObject.getPrice()){
        //        ResultPojos.pop(ResultPojos.indexOf(ResultPOJOObject));
        //    }
        }

        for (ResultPOJO quoteDtoObject: ResultPojos) {
            for (Airports airport: airports) {
        //        if (!quoteDtoObject.getIataCode().equals(airport.name())){
        //            ResultPojos.pop(ResultPojos.indexOf(quoteDtoObject));
        //        }
            }
        }

        return ResultPojos;

    }

    public SearchDto getDto() {
        return dto;
    }

    public void setDto(SearchDto dto) {
        this.dto = dto;
    }
}
