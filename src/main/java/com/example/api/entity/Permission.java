package com.example.api.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "permission")
public class Permission {
    private static final Long serialVersionUID = 1L;
    @Id
    @NotEmpty(message = "permission cannot be empty")
    @Column(name = "permission_name")
    private String permission;
}
