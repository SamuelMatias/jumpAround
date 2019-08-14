package org.academiadecodigo.codezillas.controller.web;

import org.academiadecodigo.codezillas.DTO.SearchDto;
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

@Controller
@RequestMapping("/search")
public class SearchController {

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
    public String findDestination(@Valid @ModelAttribute("searchDto") SearchDto searchDto, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("lastAction", "Make a new search");
            return "redirect:/search/";
        }

        model.addAttribute("destinations", searchService.searchDestinations(searchDto));
       //return searchService.makeRequest(searchDto);
        return "result";
    }

}
