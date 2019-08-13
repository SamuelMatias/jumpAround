package org.academiadecodigo.codezillas.controller.rest;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import org.academiadecodigo.codezillas.controller.rest.pojos.RESTUtils;

import java.io.IOException;
import java.net.URL;

public class FlightAPI {

    private ObjectMapper mapper = new ObjectMapper();


    public void convert() throws IOException {
        FlightPOJO pojo = mapper.readValue(new URL("https://api.jikan.moe/v3/anime/10"), FlightPOJO.class);
        mapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
        System.out.println(pojo.toString());

    }

    public Response getResponse(){
        OkHttpClient client = new OkHttpClient();
        ObjectMapper mapper = new ObjectMapper();
        Response response;
        Request request = new Request.Builder()

                .url(RESTUtils.SKYSCANNER_BASE + "NYC/OPO/2019-09-03?inboundpartialdate=2019-12-01")
                .get()
                .addHeader("x-rapidapi-host", "skyscanner-skyscanner-flight-search-v1.p.rapidapi.com")
                .addHeader("x-rapidapi-key", "77cac05b57mshd89bf2e6859e99ap1be1f4jsn13a25e163fc8")
                .build();

        try {
            response = client.newCall(request).execute();
            return response;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
