package com.dvi.app.security.securitypackage.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.Collection;

@Entity@Data
@Table(name="tbl_role")
@AllArgsConstructor
@NoArgsConstructor
public class Role extends BaseEntity{
    private String name;
    @ManyToMany(mappedBy = "roles",cascade = CascadeType.ALL)
    private Collection<User> users = new ArrayList<>();
}
