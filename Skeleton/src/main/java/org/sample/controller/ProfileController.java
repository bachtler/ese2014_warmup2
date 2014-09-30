package org.sample.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.sample.controller.exceptions.InvalidUserException;
import org.sample.controller.service.ProfileService;
import org.sample.controller.service.ProfileServiceImpl;
import org.sample.controller.service.SampleService;
import org.sample.controller.service.SampleServiceImpl;
import org.sample.model.Address;
import org.sample.model.Team;
import org.sample.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ProfileController {

    @Autowired
    ProfileService service;
    //does not work with  "profile.jsp?userId=123" if .jsp is included
    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public ModelAndView profile(@RequestParam(value = "userId", required  = true) long userId ){	
    	
    	ModelAndView model = new ModelAndView("profile");

    	User user =  service.getUser(userId);

    	model.addObject("user", user);   

        return model;
    }

}