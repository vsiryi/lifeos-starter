package com.willbe.lifeos.service;

import com.willbe.lifeos.model.UserModel;
import com.willbe.lifeos.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Creation date: 10/14/15
 *
 * @author Vitalii Siryi
 */
@Component
public class UserCrudServiceImpl {

    @Autowired
    private UserRepository userRepository;

    public UserModel findByName(String firstName) {
        return userRepository.findByName(firstName);
    }

}
