package org.academiadecodigo.codezillas.services;

import org.academiadecodigo.codezillas.command.SearchDto;
import org.academiadecodigo.codezillas.persistence.model.Location;

import java.util.List;

public interface SearchService {

    List<Location> searchDestinations(SearchDto searchDetails);

}
