package org.academiadecodigo.codezillas.services;

import org.academiadecodigo.codezillas.command.SearchDto;
import org.academiadecodigo.codezillas.controller.web.ResultController;
import org.academiadecodigo.codezillas.converters.Airports;

import java.util.LinkedList;

public class ResultService {
    private Airports[] airports;
    private SearchDto searchDto;
    private ResultController resultController; //VER

    public ResultService (){
        airports = Airports.values();
    }

}
