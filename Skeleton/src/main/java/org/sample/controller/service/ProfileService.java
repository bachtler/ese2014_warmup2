package org.sample.controller.service;

import java.util.List;

import org.sample.controller.exceptions.InvalidUserException;
import org.sample.model.User;



public interface ProfileService {

    public User getUser(Long userId) throws InvalidUserException;
    public List<User> getAllUser();
}
