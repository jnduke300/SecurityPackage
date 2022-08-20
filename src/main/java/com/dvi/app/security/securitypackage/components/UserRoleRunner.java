//package com.dvi.app.security.securitypackage.components;
//
//import com.dvi.app.security.securitypackage.models.Role;
//import com.dvi.app.security.securitypackage.models.User;
//import com.dvi.app.security.securitypackage.service.UserServiceImpl;
//import lombok.AllArgsConstructor;
//import lombok.RequiredArgsConstructor;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.stereotype.Component;
//
//@AllArgsConstructor
//@Component
//public class UserRoleRunner implements CommandLineRunner {
//    UserServiceImpl userService;
//    private final BCryptPasswordEncoder bCryptPasswordEncoder;
//    @Override
//    public void run(String... args) throws Exception {
//
//        User user= userService.createUser("jackson", bCryptPasswordEncoder.encode("1234"));
//        Role role_1 = userService.createRole("ROLE_ADMIN");
//        Role role_2= userService.createRole("ROLE_USER");
//
//        user.getRoles().add(role_1);
//        user.getRoles().add(role_2);
//
//        role_1.getUsers().add(user);
//        role_2.getUsers().add(user);
//
//        userService.saveUser(user);
//
//
//    }
//}
