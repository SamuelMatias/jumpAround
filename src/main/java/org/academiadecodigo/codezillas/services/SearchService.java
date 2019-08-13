package org.academiadecodigo.codezillas.services;

import org.academiadecodigo.codezillas.persistence.model.Location;

import java.util.Date;
import java.util.List;

public interface SearchService {

    List<Location> searchDestinations(/*SearchDetails searchDetails*/Location origin, Location destination, Date checkin, Date checkout);

}
