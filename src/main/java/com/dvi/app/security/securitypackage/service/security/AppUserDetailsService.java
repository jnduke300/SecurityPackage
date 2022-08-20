//package com.dvi.app.security.securitypackage.service.security;
//
////import com.dvi.app.security.securitypackage.models.User;
//import com.dvi.app.security.securitypackage.models.User;
//import com.dvi.app.security.securitypackage.models.security.AppUserDetails;
//import com.dvi.app.security.securitypackage.repository.UserRepository;
//import lombok.AllArgsConstructor;
//import lombok.RequiredArgsConstructor;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//@Service
//@AllArgsConstructor
//public class AppUserDetailsService implements UserDetailsService {
//
//    UserRepository userRepository;
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        User user = userRepository.findByUsername(username);
//        if(user == null){
//            throw new UsernameNotFoundException("User "+user.getUsername()+" was not found");
//        }else{
//          return new AppUserDetails(user);
//        }
//    }
//}
