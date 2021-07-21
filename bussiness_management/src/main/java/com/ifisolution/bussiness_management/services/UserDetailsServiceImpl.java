//package com.ifisolution.bussiness_management.services;
//
//import com.ifisolution.bussiness_management.models.User;
//import com.ifisolution.bussiness_management.repositories.UserRepo;
//import lombok.AllArgsConstructor;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.Collection;
//import java.util.Optional;
//
//import static java.util.Collections.singletonList;
//
//@Service
//@AllArgsConstructor
////viết lại interface này để nó lấy người dùng từ database
//public class UserDetailsServiceImpl implements UserDetailsService {
//
//    private final UserRepo userRepo;
//
//    @Override
//    @Transactional(readOnly = true)
//    public UserDetails loadUserByUsername(String username) {
//        Optional<User> userOptional = userRepo.findByUsername(username);
//        User user = userOptional.orElseThrow(() -> new UsernameNotFoundException("No user " +
//                "Found with username : " + username));
//
//        //xong trả về kiểu User spring security hiểu
//        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
//                true, true, true,
//                true, getAuthorities());
//    }
//
//    private Collection<? extends GrantedAuthority> getAuthorities() {
//        return singletonList(new SimpleGrantedAuthority("User"));
//    }
//}
