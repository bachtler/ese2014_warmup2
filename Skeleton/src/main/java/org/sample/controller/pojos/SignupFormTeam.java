package org.sample.controller.pojos;


import java.util.Date;

public class SignupFormTeam {


    private Long id;
    private String teamName;
    private Date creationDate;



    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public void setCreationDate(Date date){
    	this.creationDate=date;
    }
    
    public Date getCreationDate(){
    	return creationDate;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
