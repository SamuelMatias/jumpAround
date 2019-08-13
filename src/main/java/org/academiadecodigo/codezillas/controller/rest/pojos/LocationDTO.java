package org.academiadecodigo.codezillas.controller.rest.pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LocationDTO {

    @JsonProperty("IataCode")
    private String iATACode;
    @JsonProperty("Name")
    private String name;
    @JsonProperty("CityName")
    private String cityName;
    @JsonProperty("CityId")
    private String cityID;
    @JsonProperty("CountryName")
    private String country;

    public String getiATACode() {
        return iATACode;
    }

    public void setiATACode(String iATACode) {
        this.iATACode = iATACode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCityID() {
        return cityID;
    }

    public void setCityID(String cityID) {
        this.cityID = cityID;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
