//package com.ifisolution.bussiness_management.services;
//
//import com.ifisolution.bussiness_management.dto.RegisterRequest;
//import com.ifisolution.bussiness_management.models.User;
//import com.ifisolution.bussiness_management.repositories.UserRepo;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.ArgumentCaptor;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
//import static org.mockito.BDDMockito.given;
//import static org.mockito.Mockito.verify;
//
//
//@ExtendWith(MockitoExtension.class)
//public class AuthServiceTest {
//    @Mock
//    private UserRepo userRepo;
//    @Mock
//    private PasswordEncoder passwordEncoder;
//    private AuthService underTest;
//
//    @BeforeEach
//    void setUp() {
//        underTest = new AuthService(passwordEncoder, userRepo, null, null);
//    }
//
//    @Test
//    void itWillRegister() {
//        RegisterRequest registerRequest = new RegisterRequest("user1@example.com", "user1", "pwd1");
//        underTest.signup(registerRequest);
//        User user = new User();
//        user.setUsername(registerRequest.getUsername());
//        user.setEmail(registerRequest.getEmail());
//        user.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
//        user.setCreateAt(null);
//        ArgumentCaptor<User> userArgumentCaptor = ArgumentCaptor.forClass(User.class);
//
//        verify(userRepo).save(userArgumentCaptor.capture());
//        userArgumentCaptor.getValue().setCreateAt(null);
//        assertThat(userArgumentCaptor.getValue()).isEqualTo(user);
//    }
//
//    @Test
//    void isWillReturnFalse() {
//        RegisterRequest registerRequest = new RegisterRequest("user1@example.com", "user1", "pwd1");
//        given(userRepo.existsByUsername(registerRequest.getUsername())).willReturn(true);
//
//        assertThat(underTest.signup(registerRequest)).isFalse();
//    }
//}