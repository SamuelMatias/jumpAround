package org.academiadecodigo.codezillas.controller.rest.restDTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;

@JsonIgnoreProperties(ignoreUnknown = true)
public class QuoteDTO  {

    @JsonProperty("MinPrice")
    private String price;
    @JsonProperty("Direct")
    private boolean direct;
    @JsonProperty("OutboundLeg")
    private JsonNode outboundLeg;
    private String date;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public boolean isDirect() {
        return direct;
    }

    public void setDirect(boolean direct) {
        this.direct = direct;
    }

    public JsonNode getOutboundLeg() {
        return outboundLeg;
    }

    public void setOutboundLeg(JsonNode outboundLeg) {
        this.outboundLeg = outboundLeg;
    }

}
