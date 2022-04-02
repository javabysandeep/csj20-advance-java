package com.example.serveltjdbc;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class User {
    private Integer id;
    private String name;
    private String email;
    private String phone;
    private String username;
    private String password;
}
