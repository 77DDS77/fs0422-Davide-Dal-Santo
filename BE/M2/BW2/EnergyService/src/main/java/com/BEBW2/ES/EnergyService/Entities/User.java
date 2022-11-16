package com.BEBW2.ES.EnergyService.Entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String username;
    @Column(unique = true, nullable = false)
    private String email;

    private String password;
    private String nome;
    private String cognome;

    private Boolean active = true;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles = new HashSet<Role>();

    public User(String username, String email, String nome, String cognome, String password) {
        this.username = username;
        this.email = email;
        this.nome = nome;
        this.cognome = cognome;
        this.password = password;
    }

    public void addRole(Role r){
        this.roles.add(r);
    }

    public void removeRole(Role r){
        this.roles.remove(r);
    }
}
