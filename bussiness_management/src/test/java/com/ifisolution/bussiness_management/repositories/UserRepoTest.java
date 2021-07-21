//package com.ifisolution.bussiness_management.repositories;
//
//import com.ifisolution.bussiness_management.models.User;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//
//import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
//
//
//@DataJpaTest
//public class UserRepoTest {
//    @Autowired
//    private UserRepo underTest;
//
//    @AfterEach
//    void tearDown() {
//        underTest.deleteAll();
//    }
//
//    @Test
//    void existsByUsernameShouldTrue() {
//        String username = "user1";
//        User user = new User(null, username, "pwd1", "user1@example.com", null);
//        underTest.save(user);
//
//        boolean expected = underTest.existsByUsername(username);
//
//        assertThat(expected).isTrue();
//    }
//
//    @Test
//    void existsByUsernameShouldFalse() {
//        String username = "user1";
//        boolean expected = underTest.existsByUsername(username);
//        assertThat(expected).isFalse();
//    }
//
//}