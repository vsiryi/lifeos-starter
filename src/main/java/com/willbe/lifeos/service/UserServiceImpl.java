package com.willbe.lifeos.service;

import com.willbe.lifeos.model.UserModel;
import com.willbe.lifeos.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * Creation date: 10/9/15
 *
 * @author Vitalii Siryi
 */
public class UserServiceImpl implements UserDetailsService {

    private UserRepository repository;

    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        UserModel model = repository.findByName(s);
        return model.convertToUserDetails();
    }

}
