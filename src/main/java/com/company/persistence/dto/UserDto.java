package com.company.persistence.dto;

import com.company.validation.PasswordMatches;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@PasswordMatches
public class UserDto {
    @NotNull(message = "Enter your login")
    @NotEmpty
    private String login;
    @NotNull(message = "Enter you password")
    @NotEmpty
    @Size(min = 6)
    private String password;
    @NotNull(message = "Repeat your password")
    @NotEmpty
    @Size(min = 6)
    private String matchingPassword;

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

    public String getMatchingPassword() {
        return matchingPassword;
    }

    public void setMatchingPassword(String matchingPassword) {
        this.matchingPassword = matchingPassword;
    }
}
