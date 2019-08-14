package org.academiadecodigo.codezillas.controller.rest;

import org.academiadecodigo.codezillas.controller.rest.flightAPI.FlightAPI;
import org.academiadecodigo.codezillas.controller.rest.flightAPI.ResultPOJO;
import org.academiadecodigo.codezillas.controller.rest.restDTO.LocationDTO;
import org.academiadecodigo.codezillas.controller.rest.restDTO.QuoteDTO;
import org.academiadecodigo.codezillas.controller.rest.flightAPI.FlightPOJO;
import org.academiadecodigo.codezillas.exceptions.JumpAroundException;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DTOMerger {

    FlightAPI flightAPI;

    public ResultPOJO getResult(String orgIATA, String destIATA, String date) throws JumpAroundException {

        flightAPI = new FlightAPI();
        ResultPOJO pojo = new ResultPOJO();
        FlightPOJO fpojo = flightAPI.getResponse(orgIATA, destIATA, date);
        List<LocationDTO> list = flightAPI.getDestinationList(fpojo);
        QuoteDTO quoteDTO = flightAPI.getQuotes(fpojo);
        LocationDTO locationDTO = list.get(0);
        pojo.setList(list);
        try {
            pojo.setPrice(Double.parseDouble(quoteDTO.getPrice()));
            pojo.setDate(quoteDTO.getDate());
            pojo.setCity(locationDTO.getCityName());
            pojo.setCountry(locationDTO.getCountry());
            pojo.setiATAcode(locationDTO.getiATACode());
        } catch (NullPointerException np){
            np.printStackTrace();
            throw new JumpAroundException("RESULT POJO NULLPOINTER");
        }
        return pojo;
    }

}
