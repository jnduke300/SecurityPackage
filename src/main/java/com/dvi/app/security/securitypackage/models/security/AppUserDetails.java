//package com.dvi.app.security.securitypackage.models.security;
//
//import com.dvi.app.security.securitypackage.models.Role;
//import com.dvi.app.security.securitypackage.models.User;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.List;
//
//public class AppUserDetails implements UserDetails {
//    private Collection<? extends GrantedAuthority> authorities;
//    private String password;
//    private String username;
//    private boolean isenabled = false;
//
//    public AppUserDetails(User user) {
//        this.password = user.getPassword();
//        this.username = user.getUsername();
//        this.isenabled = user.isEnabled();
//        this.authorities = getAuthorities(user.getRole());
//    }
//
//
//    public Collection<? extends GrantedAuthority> getAuthorities(Collection<Role> roles) {
//        Collection<GrantedAuthority> authority = new ArrayList<>();
//        roles.stream().forEach(role -> authority.add(new SimpleGrantedAuthority(role.getName())));
//        return authority;
//    }
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return authorities;
//    }
//
//    @Override
//    public String getPassword() {
//        return password;
//    }
//
//    @Override
//    public String getUsername() {
//        return username;
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return true;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return isenabled;
//    }
//}
