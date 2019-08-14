package org.academiadecodigo.codezillas.controller.web;

import org.academiadecodigo.codezillas.DTO.SearchDto;
import org.academiadecodigo.codezillas.controller.rest.flightAPI.ResultPOJO;
import org.academiadecodigo.codezillas.exceptions.JumpAroundException;
import org.academiadecodigo.codezillas.services.SearchService;
import org.academiadecodigo.codezillas.services.SearchServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Controller
@RequestMapping("/search")
public class SearchController {

    @Autowired
    private SearchServiceImpl searchService;

    public SearchService getSearchService() {
        return searchService;
    }

    public void setSearchService(SearchServiceImpl searchService) {
        this.searchService = searchService;
    }

    @RequestMapping(method = RequestMethod.GET, path = "")
    public String showSearch(@ModelAttribute("searchDto") SearchDto searchDto, BindingResult bindingResult, RedirectAttributes redirectAttributes){

        return "index";
    }

    @RequestMapping(method = RequestMethod.POST, path = "")
    public String findDestination(@Valid @ModelAttribute("destinations") SearchDto searchDto, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("lastAction", "Make a new search");
            return "redirect:/search/";
        }

        SearchDto dto = new SearchDto();
        dto.setCountry("Portugal");
        dto.setBudget(100);
        dto.setIata("LIS");

        try {
            model.addAttribute("destinations", searchService.searchDestinations(dto));
        } catch (JumpAroundException e) {
            e.printStackTrace();
        }
        return "result";
       //return searchService.makeRequest(searchDto);
    }

    public List<ResultPOJO> greatThings(){

        ArrayList<ResultPOJO> list = new ArrayList<>();

        int count = 10;

        for (int i = 0; i < count; i++) {
            ResultPOJO pojo = new ResultPOJO();
            pojo.setCity("New York");
            pojo.setDate("03-06-1992");
            pojo.setPrice(42069);
            pojo.setiATAcode("NYC");
            list.add(pojo);
        }

        return list;
    }


}
