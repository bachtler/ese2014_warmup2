package org.sample.controller;

import org.sample.controller.service.ProfileService;
import org.sample.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

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