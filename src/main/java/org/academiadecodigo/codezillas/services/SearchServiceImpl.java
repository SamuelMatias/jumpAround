package org.academiadecodigo.codezillas.services;

import org.academiadecodigo.codezillas.DTO.SearchDto;
import org.academiadecodigo.codezillas.persistence.model.Location;

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
