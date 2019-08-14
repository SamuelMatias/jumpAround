package org.academiadecodigo.codezillas.controller.rest.pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.node.ArrayNode;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FlightPOJO implements Serializable {

    @JsonProperty("Quotes")
    private ArrayNode quotes;
    @JsonProperty("Places")
    private ArrayNode places;
    @JsonProperty("Carriers")
    private ArrayNode carriers;
    @JsonProperty("Currencies")
    private ArrayNode currencies;

    @Override
    public String toString() {
        return "FlightPOJO{" +
                "quotes=" + quotes +
                ", places=" + places +
                ", carriers=" + carriers +
                ", currencies=" + currencies +
                '}';
    }

    public ArrayNode getQuotes() {
        return quotes;
    }

    public void setQuotes(ArrayNode quotes) {
        this.quotes = quotes;
    }

    public ArrayNode getPlaces() {
        return places;
    }

    public void setPlaces(ArrayNode places) {
        this.places = places;
    }

    public ArrayNode getCarriers() {
        return carriers;
    }

    public void setCarriers(ArrayNode carriers) {
        this.carriers = carriers;
    }

    public ArrayNode getCurrencies() {
        return currencies;
    }

    public void setCurrencies(ArrayNode currencies) {
        this.currencies = currencies;
    }
}
