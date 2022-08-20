package com.dvi.app.security.securitypackage.service;

import com.dvi.app.security.securitypackage.models.Role;
import com.dvi.app.security.securitypackage.models.User;
import com.dvi.app.security.securitypackage.repository.RoleRepository;
import com.dvi.app.security.securitypackage.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService, UserDetailsService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if(user == null){
            throw new UsernameNotFoundException("User "+user.getUsername()+" was not found");
        }else{
            Collection<GrantedAuthority> authorities = new ArrayList<>();
            user.getRoles().stream().forEach(role -> authorities.add(new SimpleGrantedAuthority(role.getName())));
            return new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(),authorities);
        }
    }

    @Override
    public User findUserByUsername(String unsername) {
        return userRepository.findByUsername(unsername);
    }

    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User createUser(String username, String password) {
        User user = new User(username,password,true,true,new ArrayList<>());

        return user;
    }

    @Override
    public Role createRole(String roleName) {
        Role role = new Role();
        role.setName(roleName);
        return role;
    }

    @Override
    public User addRoleToUser(String username, String role) {
        return null;
    }

    @Override
    public Role findRobeByName(String name) {
        return roleRepository.findByName(name);
    }

    @Override
    public Role saveRole(Role role) {
        return roleRepository.save(role);
    }
}
