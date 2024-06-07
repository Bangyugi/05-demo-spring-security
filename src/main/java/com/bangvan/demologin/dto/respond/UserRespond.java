package com.bangvan.demologin.dto.respond;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRespond {
    private Long id;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private LocalDate birthday;
    private String email;

}
