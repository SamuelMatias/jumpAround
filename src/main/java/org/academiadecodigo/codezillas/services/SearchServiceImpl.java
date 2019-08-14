package org.academiadecodigo.codezillas.services;

import org.academiadecodigo.codezillas.controller.rest.DTOMerger;
import org.academiadecodigo.codezillas.controller.rest.flightAPI.ResultPOJO;
import org.academiadecodigo.codezillas.converters.Airports;
import org.academiadecodigo.codezillas.converters.LocationtoIataConverter;
import org.academiadecodigo.codezillas.DTO.SearchDto;
import org.academiadecodigo.codezillas.exceptions.JumpAroundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@Component
public class SearchServiceImpl implements SearchService {

    @Autowired
    private LocationtoIataConverter iataConverter;
    @Autowired
    private DTOMerger dtoMerger;

    //IATA Code - Origin location

    //Budget

    @Override
    public LinkedList<ResultPOJO> searchDestinations(SearchDto searchDetails) {
        SearchDto searchDto = searchDetails;
        searchDto.setIata(convertSearchDetails(searchDetails));
       // DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd"); //"yyyy-mm-dd hh:mm:ss"

        LinkedList<ResultPOJO> resultPOJOS = new LinkedList<>();
        LinkedList<ResultPOJO> destinations = null;
        for (Airports airport: Airports.values()){

            try {
                ResultPOJO pojo = dtoMerger.getResult("LIS", "OPO", "2019-09-03");
                if(pojo != null){
                resultPOJOS.add(pojo);
                }
                destinations = filterDestinations(searchDto, resultPOJOS);
                return destinations;
            } catch (JumpAroundException e) {
                e.printStackTrace();
            }
        }


        //LinkedList<ResultPOJO> resultPOJOS = flightAPI.getResponse(searchDto.getIata(), "   ", searchDto.getCheckIn());
        //LinkedList<ResultPOJO> resultPOJOS = flightAPI.getResponse(searchDto.getIata() + "/   /", searchDto.getCheckIn());


        return destinations;
    }

    private String convertSearchDetails(SearchDto searchDetails){

        String origin = searchDetails.getOrigin();
        return iataConverter
                .converter(
                        origin);
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
}
