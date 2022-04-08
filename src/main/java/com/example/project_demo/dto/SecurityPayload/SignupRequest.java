package com.example.project_demo.dto.SecurityPayload;

public class SignupRequest {
    private String username;
    private String password;
    private Integer typeOfUser;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getTypeOfUser() {
        return typeOfUser;
    }

    public void setTypeOfUser(Integer typeOfUser) {
        this.typeOfUser = typeOfUser;
    }
}
