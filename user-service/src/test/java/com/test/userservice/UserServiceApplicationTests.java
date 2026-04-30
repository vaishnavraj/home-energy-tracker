package com.test.userservice;

import com.test.userservice.entity.User;
import com.test.userservice.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
class UserServiceApplicationTests {

    public static final int NUMBER_OD_USERS = 10;
    @Autowired
    private UserRepository userRepository;

    @Test
    void contextLoads() {
    }

    @Disabled
    @Test
    void addUserToDb(){
        for(int i = 0; i< NUMBER_OD_USERS; i++){
            User user=User.builder()
                    .name("User"+i)
                    .surname("Surname"+i)
                    .email("user"+i+"@yopmail.com")
                    .address(i+" Example St")
                    .alerting(i%2 == 0)
                    .energyAlertingThreshold(1000 + i)
                    .build();
            userRepository.save(user);
        }
        log.info("User repository populated successfully");
    }

}
