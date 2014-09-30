package org.sample.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.sample.controller.exceptions.InvalidUserException;
import org.sample.controller.pojos.SignupForm;
import org.sample.controller.pojos.TeamList;
import org.sample.controller.service.SampleService;
import org.sample.controller.service.SampleServiceImpl;
import org.sample.model.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class IndexController {

    @Autowired
    SampleService sampleService;


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView index() {
    	ModelAndView model = new ModelAndView("index");
    	model.addObject("signupForm", new SignupForm());
    	model = addTeamListToModel(model);
        return model;
    }
    private ModelAndView addTeamListToModel(ModelAndView model){
    	List<Team> teamList = new ArrayList<Team>();

		Iterable<Team> teams = sampleService.getTeamList();

		for (Team t : teams){
			teamList.add(t);
		}
    	
    	model.addObject("teamList", teamList);
    	return model;
    }
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ModelAndView create(@Valid SignupForm signupForm, BindingResult result, RedirectAttributes redirectAttributes) {
    	ModelAndView model; 
    	System.out.println(result.hasErrors());
    	if (!result.hasErrors()) {
            try {

            	sampleService.saveFrom(signupForm);
            	model = new ModelAndView("show");
            	addTeamListToModel(model);

            } catch (InvalidUserException e) {
            	model = new ModelAndView("index");
            	model.addObject("page_error", e.getMessage());
            }
            catch (Exception e) {
            	model = new ModelAndView("index");
            	model.addObject("page_error", e.getMessage());
            }
        } else {
        	model = new ModelAndView("index");
        	model = addTeamListToModel(model);
        	model.addObject("page_error", result.getAllErrors());
        }   	
    	return model;
    }
    
    @RequestMapping(value = "/security-error", method = RequestMethod.GET)
    public String securityError(RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("page_error", "You do have have permission to do that!");
        return "redirect:/";
    }
    

}


