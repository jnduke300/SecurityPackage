package com.dvi.app.security.securitypackage.models;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Data
@Table(name = "USERS")
@NoArgsConstructor
public class User extends BaseEntity{
    @NotNull
    @Column(name = "username", unique = true)
    private String username;
    @NotNull
    private String password;
    private boolean enabled;
    private boolean accountNonLocked;
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "ROLES",
    joinColumns = @JoinColumn(name = "user_id"),
    inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Collection<Role> roles = new ArrayList<>();

    public User(String username, String password, boolean enabled, boolean accountNonLocked, Collection<Role> roles) {
        this.username = username;
        this.password = password;
        this.enabled = enabled;
        this.accountNonLocked = accountNonLocked;
        this.roles = roles;
    }
}
