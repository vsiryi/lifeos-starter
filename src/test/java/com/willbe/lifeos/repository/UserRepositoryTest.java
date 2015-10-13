package com.willbe.lifeos.repository;

import com.willbe.lifeos.LifeOS;
import com.willbe.lifeos.model.UserModel;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Creation date: 10/12/15
 *
 * @author Vitalii Siryi
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = LifeOS.class)
@ActiveProfiles("test")
public class UserRepositoryTest {

    private static final String TEST_USER_NAME = "test-user";
    private static final String TEST_USER_PASSWORD = "pwd";
    private static final String EXPECTED_DESCRIPTION = "some desc";

    @Autowired
    private UserRepository repository;

    @After
    public void tearDown(){
        repository.delete(TEST_USER_NAME);
    }

    @Test
    public void testUserCrud() throws Exception {
        UserModel user = repository.insert(new UserModel(TEST_USER_NAME, TEST_USER_PASSWORD));

        user = repository.findOne(user.getId());
        assertNotNull(user);
        assertEquals(TEST_USER_NAME, user.getName());

        user.setDescription(EXPECTED_DESCRIPTION);
        repository.save(user);

        user = repository.findOne(user.getId());
        assertNotNull(user);
        assertEquals(TEST_USER_NAME, user.getName());
        assertEquals(EXPECTED_DESCRIPTION, user.getDescription());
    }


}
