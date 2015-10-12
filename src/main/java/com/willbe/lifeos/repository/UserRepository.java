package com.willbe.lifeos.repository;

import com.willbe.lifeos.model.UserModel;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Creation date: 10/9/15
 *
 * @author Vitalii Siryi
 */
public interface UserRepository extends MongoRepository<UserModel, String> {

    UserModel findByName(String firstName);

}
