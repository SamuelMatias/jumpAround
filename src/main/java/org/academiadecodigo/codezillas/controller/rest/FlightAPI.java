package org.academiadecodigo.codezillas.controller.rest;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import org.academiadecodigo.codezillas.controller.rest.DTO.LocationDTO;
import org.academiadecodigo.codezillas.controller.rest.DTO.OutboundDTO;
import org.academiadecodigo.codezillas.controller.rest.DTO.QuoteDTO;
import org.academiadecodigo.codezillas.controller.rest.pojos.FlightPOJO;
import org.academiadecodigo.codezillas.controller.rest.pojos.RESTUtils;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class FlightAPI {
    ObjectMapper mapper;

    public FlightPOJO getResponse(/*String origin, String destination, String date*/){
        mapper = new ObjectMapper();
        OkHttpClient client = new OkHttpClient();
        Response response;
        Request request = new Request.Builder()

                .url(RESTUtils.SKYSCANNER_BASE + "LIS/CDG/2019-09-03")
                .get()
                .addHeader(RESTUtils.SKYSCANNER_HOSTHEADER, RESTUtils.SKYSCANNER_HOSTVALUE)
                .addHeader(RESTUtils.SKYSCANNER_KEYHEADER, RESTUtils.SKYSCANNER_KEY)
                .build();

        try {
            response = client.newCall(request).execute();
            FlightPOJO pojo = mapper.readValue(response.body().bytes(), FlightPOJO.class);
            return pojo;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public List<LocationDTO> getDestinationList(FlightPOJO pojo){

        LinkedList<LocationDTO> locationList = new LinkedList<>();
        try {
            LocationDTO dto;
            for (JsonNode jsonNode : pojo.getPlaces()) {
                dto = mapper.readValue(jsonNode.toString(), LocationDTO.class);
                //System.out.println(dto.getiATACode() + " - " + dto.getCityName() + " - " + dto.getCountry());
                locationList.add(dto);
            }
            return locationList;

        } catch (IOException e) {
            e.printStackTrace();
        }

        return locationList;
    }



    public QuoteDTO getQuotes(FlightPOJO pojo){

        QuoteDTO dto = null;
        try {
            for (JsonNode jsonNode : pojo.getQuotes()) {
                dto = mapper.readValue(jsonNode.toString(), QuoteDTO.class);
                OutboundDTO outbound = mapper.readValue(dto.getOutboundLeg().toString(), OutboundDTO.class);
                String[] date = outbound.getDate().split("[A-Z]");
                dto.setDate(date[0]);
                System.out.println(dto.getPrice() + " - "+ dto.getDate());
            }
            return dto;

        } catch (IOException e) {
            e.printStackTrace();
        }

        return dto;
    }

}
