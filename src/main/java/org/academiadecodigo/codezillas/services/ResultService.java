package org.academiadecodigo.codezillas.services;

import org.academiadecodigo.codezillas.command.SearchDto;
import org.academiadecodigo.codezillas.controller.web.ResultController;
import org.academiadecodigo.codezillas.converters.Airports;

import java.util.LinkedList;

public class ResultService {
    private Airports[] airports;
    private SearchDto searchDto;
    private LinkedList<QuoteDto> quoteDto;
    private ResultController resultController; //VER

    public ResultService (){
        airports = Airports.values();
    }

    public void filterQuotes(LinkedList<QuoteDto> quoteDto) {
        for (QuoteDto quoteDtoObject: quoteDto) {
            if (searchDto.getBudget() > quoteDtoObject.getPrice()){
                quoteDto.pop(quoteDto.indexOf(quoteDtoObject));
            }
        }

        for (QuoteDto quoteDtoObject: quoteDto) {
            for (Airports airport: airports) {
                if (!quoteDtoObject.getIataCode().equals(airport.name())){
                    quoteDto.pop(quoteDto.indexOf(quoteDtoObject));
                }
            }
        }

        //Decision on where to do
    }

}
