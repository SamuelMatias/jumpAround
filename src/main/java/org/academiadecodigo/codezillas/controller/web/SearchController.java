package org.academiadecodigo.codezillas.controller.web;

import org.academiadecodigo.codezillas.command.SearchDto;
import org.academiadecodigo.codezillas.converters.SearchDetailsDtoToSearchDetails;
import org.academiadecodigo.codezillas.persistence.model.SearchDetails;
import org.academiadecodigo.codezillas.services.SearchService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/search")
public class SearchController {

    private SearchService searchService;

    public SearchService getSearchService() {
        return searchService;
    }

    public void setSearchService(SearchService searchService) {
        this.searchService = searchService;
    }

    @RequestMapping(method = RequestMethod.POST, path = {"/"})
    public String findDestination(@Valid @ModelAttribute ("searchDetails") SearchDto searchDto, BindingResult bindingResult, RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("lastAction", "Make a new search");
            return "redirect:/search/";
        }

        return searchService.searchDestinations(searchDto);
    }
}
