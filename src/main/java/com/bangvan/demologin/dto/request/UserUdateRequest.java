package com.bangvan.demologin.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserUdateRequest {
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private LocalDate birthday;
    private String email;

    public String getPassword() {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);
        return passwordEncoder.encode(password);
    }
}
