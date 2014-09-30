package org.sample.controller.pojos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.sample.controller.service.SampleService;
import org.sample.controller.service.SampleServiceImpl;
import org.sample.model.Team;
import org.sample.model.dao.*;

public class TeamList {


    private List<Team> teamList;

    public TeamList(){
    	
    }

    public List<Team> getTeamList() {
        return teamList;
    }


    
	public void setTeamList(List<Team> list){
		teamList = list;
	}
}
