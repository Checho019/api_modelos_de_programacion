package com.example.api.dto;

import com.example.api.entity.Role;
import lombok.Value;

import java.util.Set;

public record UserDTO(long age, String name, String lastname, String pass,
                      Set<Role> roles) {
}
