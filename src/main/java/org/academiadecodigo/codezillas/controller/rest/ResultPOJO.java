package org.academiadecodigo.codezillas.controller.rest;

import org.academiadecodigo.codezillas.controller.rest.DTO.LocationDTO;
import org.academiadecodigo.codezillas.controller.rest.DTO.QuoteDTO;

import java.util.List;

public class ResultPOJO {

   private String price;
   private String date;
   private List<LocationDTO> list;

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<LocationDTO> getList() {
        return list;
    }

    public void setList(List<LocationDTO> list) {
        this.list = list;
    }
}
