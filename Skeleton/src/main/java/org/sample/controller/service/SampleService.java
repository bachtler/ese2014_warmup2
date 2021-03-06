package org.sample.controller.service;

import org.sample.controller.exceptions.InvalidUserException;
import org.sample.controller.pojos.SignupForm;
import org.sample.controller.pojos.SignupFormTeam;
import org.sample.model.Team;

public interface SampleService {

    public SignupForm saveFrom(SignupForm signupForm) throws InvalidUserException;
    public SignupFormTeam saveTeam(SignupFormTeam signupForm) throws InvalidUserException;
    public Iterable<Team> getTeamList();


}
