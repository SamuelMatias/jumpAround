package org.academiadecodigo.codezillas.services;

import org.academiadecodigo.codezillas.command.SearchDto;
import org.academiadecodigo.codezillas.persistence.model.Location;
import org.academiadecodigo.codezillas.persistence.model.SearchDetails;

import java.util.Date;
import java.util.List;

public class SearchServiceImpl implements SearchService {

    //private IataConverter iataConverter;
    //IATA Code - Origin location

    //Budget

    @Override
    public List<Location> searchDestinations(SearchDto searchDetails) {

        convertSearchDetails(searchDetails);

        //send to alex

        return null; // return converted alex result
    }

    private String convertSearchDetails(SearchDto searchDetails){

        String origin = searchDetails.getOrigin();
        return null;
    }
}
