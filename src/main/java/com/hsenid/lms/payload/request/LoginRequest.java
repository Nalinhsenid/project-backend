package com.security.training.payload.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class LoginRequest {
//    @NotBlank
//    @Size(min = 2, max = 40)
    private String username;
//    @NotBlank
//    @Size(min = 2, max = 40)
    private String password;

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
