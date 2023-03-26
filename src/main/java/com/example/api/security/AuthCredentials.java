package com.example.api.security;

import lombok.Data;

@Data
public class AuthCredentials {
    private String id;
    private String password;
}
