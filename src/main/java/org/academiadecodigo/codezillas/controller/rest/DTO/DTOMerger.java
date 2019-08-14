package org.academiadecodigo.codezillas.controller.rest.DTO;

import org.academiadecodigo.codezillas.controller.rest.FlightAPI;
import org.academiadecodigo.codezillas.controller.rest.ResultPOJO;
import org.academiadecodigo.codezillas.controller.rest.pojos.FlightPOJO;

import java.util.List;

public class DTOMerger {

    FlightAPI flightAPI;

    public ResultPOJO getResult(){

        flightAPI = new FlightAPI();
        ResultPOJO pojo = new ResultPOJO();
        FlightPOJO fpojo = flightAPI.getResponse();
        List<LocationDTO> list = flightAPI.getDestinationList(fpojo);
        QuoteDTO quoteDTO = flightAPI.getQuotes(fpojo);
        pojo.setList(list);
        pojo.setPrice(quoteDTO.getPrice());
        pojo.setDate(quoteDTO.getDate());
        return pojo;
    }

}
