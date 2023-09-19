package com.example.miniprojectdelivery.model;

import com.example.miniprojectdelivery.enums.UserRoleEnum;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Entity
@Getter
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username", nullable = false, unique = true)
    @NotBlank(message = "이름은 필수 값 입니다.")
    private String username;

    @Column(name = "password", nullable = false)
    @NotBlank(message = "비밀번호는 필수 값 입니다. ")
    private String password;

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private UserRoleEnum role;

    @Column
    @NotBlank(message = "이메일은 필수 값입니다.")
    private String email;

    @Column
    private Long point;

    public User(String username, String password, UserRoleEnum role, String email) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.email = email;
        this.point = 0L;
    }
}

