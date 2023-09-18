package com.management.platform.dto;


import com.management.platform.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisteredRequest {

    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Role role;
}
