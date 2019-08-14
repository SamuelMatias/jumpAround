package rest;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import org.academiadecodigo.codezillas.controller.rest.DTO.DTOMerger;
import org.academiadecodigo.codezillas.controller.rest.FlightAPI;
import org.academiadecodigo.codezillas.controller.rest.ResultPOJO;
import org.academiadecodigo.codezillas.controller.rest.pojos.FlightPOJO;
import org.academiadecodigo.codezillas.controller.rest.DTO.LocationDTO;
import org.academiadecodigo.codezillas.controller.rest.DTO.QuoteDTO;
import org.academiadecodigo.codezillas.controller.rest.pojos.RESTUtils;
import org.academiadecodigo.codezillas.exceptions.JumpAroundException;

import java.io.IOException;
import java.util.*;

public class FlightTEST {

    public static void main(String[] args) {
        DTOMerger merger = new DTOMerger();
        try{

        ResultPOJO pojo = merger.getResult();
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
