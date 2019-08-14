package org.academiadecodigo.codezillas.services;

import org.academiadecodigo.codezillas.DTO.SearchDto;
import org.academiadecodigo.codezillas.controller.rest.flightAPI.ResultPOJO;
import org.academiadecodigo.codezillas.persistence.model.Location;

import java.util.LinkedList;
import java.util.List;

public interface SearchService {

    LinkedList<ResultPOJO> searchDestinations(SearchDto searchDetails);

}
