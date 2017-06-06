package com.company.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "user")
public class User {
    @Id
    @Column(name = "user_name", unique = true, nullable = false, length = 45)
    private String login;
    @Column(nullable = false, length = 60)
    private String password;
    @Column(nullable = false)
    private Boolean enabled;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private Set<Url> urls;
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Role role;

    public User() {
    }

    public User(String login, String password, Boolean enabled, Set<Url> urls, Role role) {
        this.login = login;
        this.password = password;
        this.enabled = enabled;
        this.urls = urls;
        this.role = role;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Url> getUrls() {
        return urls;
    }

    public void setUrls(Set<Url> urls) {
        this.urls = urls;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", enabled=" + enabled +
                ", urls=" + urls +
                ", role=" + role +
                '}';
    }
}
