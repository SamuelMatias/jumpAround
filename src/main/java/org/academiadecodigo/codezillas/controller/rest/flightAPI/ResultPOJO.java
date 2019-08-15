package org.academiadecodigo.codezillas.controller.rest.flightAPI;

import org.academiadecodigo.codezillas.controller.rest.restDTO.LocationDTO;

import java.util.List;

public class ResultPOJO {

   private double price;
   private String date;
   private String city;
   private String iATAcode;
   private String country;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getiATAcode() {
        return iATAcode;
    }

    public void setiATAcode(String iATAcode) {
        this.iATAcode = iATAcode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    private List<LocationDTO> list;


    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
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
