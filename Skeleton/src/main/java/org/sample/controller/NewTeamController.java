package org.sample.controller;

import javax.validation.Valid;

import org.sample.controller.pojos.SignupFormTeam;
import org.sample.controller.service.SampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class NewTeamController {

    @Autowired
    SampleService sampleService;


    @RequestMapping(value = "/new-team", method = RequestMethod.GET)
    public ModelAndView newTeam() {
    	ModelAndView model = new ModelAndView("new-team");
    	model.addObject("signupFormTeam", new SignupFormTeam());    	
        return model;
    }
    
    @RequestMapping(value = "/teamCreated", method = RequestMethod.POST)
    public ModelAndView createTeam (@Valid SignupFormTeam signupForm, BindingResult result, RedirectAttributes redirectAttributes) {
    	ModelAndView model = new ModelAndView("teamCreatedPage");; 
    	try{
    		sampleService.saveTeam(signupForm);
    	}
    	
    	catch (Exception e){
    		model = new ModelAndView("new-team");
        	model.addObject("page_error", e.getMessage());
    	}

    	return model;
    }

}


