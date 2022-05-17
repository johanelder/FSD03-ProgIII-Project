package com.example.SpringProject.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;


@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 45)
    @Email(message = "{validation.email.Type}")
    private String email;

    @Column(nullable = false, length = 64)
    @NotEmpty(message = "Name can not be empty!!")
    private String password;

    @Column(name = "firstName", nullable = false, length = 20)
    @NotEmpty(message = "First name can not be empty!!")
    @Size(min = 2, max = 20, message = "First name must be between 2 and 20 characters long!")
    private String firstName;

    @Column(name = "lastName", nullable = false, length = 20)
    @NotEmpty(message = "Last name can not be empty!!")
    @Size(min = 2, max = 20, message = "Last name must be between 2 and 20 characters long!")
    private String lastName;

    @Column(name = "enabled", nullable = false)
    private boolean enabled = true;

    @Transient
    @NotEmpty(message = "retypePassword can not be empty!!")
    private String retypePassword;

    public enum Role {
        USER,
        ADMIN
    }
    @Enumerated(EnumType.STRING)
    private Role role = Role.USER;


}
