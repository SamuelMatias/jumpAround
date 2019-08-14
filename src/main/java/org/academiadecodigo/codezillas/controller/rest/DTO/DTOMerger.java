package org.academiadecodigo.codezillas.controller.rest.DTO;

import org.academiadecodigo.codezillas.controller.rest.FlightAPI;
import org.academiadecodigo.codezillas.controller.rest.ResultPOJO;
import org.academiadecodigo.codezillas.controller.rest.pojos.FlightPOJO;
import org.academiadecodigo.codezillas.exceptions.JumpAroundException;
import org.academiadecodigo.codezillas.persistence.model.Location;

import java.util.List;

public class DTOMerger {

    FlightAPI flightAPI;

    public ResultPOJO getResult() throws JumpAroundException {

        flightAPI = new FlightAPI();
        ResultPOJO pojo = new ResultPOJO();
        FlightPOJO fpojo = flightAPI.getResponse();
        List<LocationDTO> list = flightAPI.getDestinationList(fpojo);
        QuoteDTO quoteDTO = flightAPI.getQuotes(fpojo);
        LocationDTO locationDTO = list.get(0);
        pojo.setList(list);
        try {
            pojo.setPrice(quoteDTO.getPrice());
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
