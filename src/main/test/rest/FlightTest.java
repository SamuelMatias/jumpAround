package rest;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import org.academiadecodigo.codezillas.controller.rest.DTOMerger;
import org.academiadecodigo.codezillas.controller.rest.flightAPI.ResultPOJO;
import org.academiadecodigo.codezillas.controller.rest.flightAPI.FlightPOJO;
import org.academiadecodigo.codezillas.controller.rest.restDTO.LocationDTO;
import org.academiadecodigo.codezillas.controller.rest.flightAPI.RESTUtils;
import org.academiadecodigo.codezillas.converters.LocationtoIataConverter;
import org.academiadecodigo.codezillas.exceptions.JumpAroundException;
import org.academiadecodigo.codezillas.services.SearchServiceImpl;

import java.io.IOException;
import java.util.*;

public class FlightTest {

    public static void main(String[] args) {
        DTOMerger merger = new DTOMerger();
        SearchServiceImpl searchService = new SearchServiceImpl();
        searchService.setDtoMerger(merger);
        searchService.setIataConverter(new LocationtoIataConverter());
        try{
        ResultPOJO pojo = merger.getResult("LIS", "OPO", "2019-09-03");
        System.out.println(pojo.getDate() + "-" + pojo.getPrice() +" - " + pojo.getCity() + "-" + pojo.getCountry());

        } catch (JumpAroundException jp){
            jp.printStackTrace();
        }

    }

    public static void garbage(){

        OkHttpClient client = new OkHttpClient();
        ObjectMapper mapper = new ObjectMapper();
        Request request = new Request.Builder()

                .url(RESTUtils.SKYSCANNER_BASE + "/OPO/2019-09-03?inboundpartialdate=2019-12-01")
                .get()
                .addHeader(RESTUtils.SKYSCANNER_HOSTHEADER, RESTUtils.SKYSCANNER_HOSTVALUE)
                .addHeader(RESTUtils.SKYSCANNER_KEYHEADER, RESTUtils.SKYSCANNER_KEY)
                .build();

        try {

            Response response = client.newCall(request).execute();
            FlightPOJO pojo = mapper.readValue(response.body().bytes(), FlightPOJO.class);

            LinkedList<LocationDTO> locationList = new LinkedList<>();
            LocationDTO dto;
            System.out.println(pojo.toString());
            System.out.println(pojo.getPlaces().toString() + "\n");
            Iterator<JsonNode> iterator = pojo.getPlaces().iterator();

            while (iterator.hasNext()){
                dto = mapper.readValue(iterator.next().toString(), LocationDTO.class);
                System.out.println(dto.getiATACode() + " - "+ dto.getCityName() + " - "+ dto.getCountry());
                locationList.add(dto);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
