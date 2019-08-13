package rest;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import org.academiadecodigo.codezillas.controller.rest.FlightPOJO;
import org.academiadecodigo.codezillas.controller.rest.pojos.LocationDTO;
import org.academiadecodigo.codezillas.controller.rest.pojos.RESTUtils;

import java.io.IOException;
import java.net.URL;
import java.util.*;

public class FlightTEST {
    public static void main(String[] args) {

        OkHttpClient client = new OkHttpClient();
        ObjectMapper mapper = new ObjectMapper();
        Request request = new Request.Builder()

                .url(RESTUtils.SKYSCANNER_BASE + "NYC/OPO/2019-09-03?inboundpartialdate=2019-12-01")
                .get()
                .addHeader("x-rapidapi-host", "skyscanner-skyscanner-flight-search-v1.p.rapidapi.com")
                .addHeader("x-rapidapi-key", "77cac05b57mshd89bf2e6859e99ap1be1f4jsn13a25e163fc8")
                .build();

        try {

            Response response = client.newCall(request).execute();
            FlightPOJO pojo = mapper.readValue(response.body().bytes(), FlightPOJO.class);

            LinkedList<LocationDTO> locationList = new LinkedList<>();
            LocationDTO dto;
            LocationDTO dto2;
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
