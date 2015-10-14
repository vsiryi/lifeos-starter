package com.willbe.lifeos.service;

import com.willbe.lifeos.LifeOS;
import com.willbe.lifeos.model.UserModel;
import com.willbe.lifeos.repository.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * Creation date: 10/14/15
 *
 * @author Vitalii Siryi
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {LifeOS.class})
public class UserServiceImplTest {

    private static final String USER_NAME = "admin";
    private static final String USER_PASSWORD = "admin";

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    @Autowired
    private UserCrudServiceImpl service;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        when(userRepository.findByName(anyString())).thenReturn(new UserModel(USER_NAME, USER_PASSWORD));
    }

    @Test
    public void testUserService(){
        UserModel user = service.findByName(USER_NAME);
        assertNotNull(user);
        assertEquals(USER_PASSWORD, user.getPassword());
    }

}
