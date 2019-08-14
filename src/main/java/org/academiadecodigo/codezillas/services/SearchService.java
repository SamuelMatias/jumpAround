package org.academiadecodigo.codezillas.services;

import org.academiadecodigo.codezillas.DTO.SearchDto;
import org.academiadecodigo.codezillas.persistence.model.Location;

import java.util.List;

public interface SearchService {

    List<Location> searchDestinations(SearchDto searchDetails);

}
