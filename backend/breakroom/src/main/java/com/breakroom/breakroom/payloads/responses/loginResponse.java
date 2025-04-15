package com.breakroom.breakroom.payloads.responses;

import java.util.List;

public class loginResponse {
    private String username;
    private String email;
    private Long id;
    private List<String> roles;

    public loginResponse(String username, String email, Long id, List<String> roles){
        this.id=id;
        this.email=email;
        this.username=username;
        this.roles=roles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }
}
