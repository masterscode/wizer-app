package com.library.payloads.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRegistrationResponse implements Serializable {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private Boolean isAccountNonExpired;
    private Boolean isAccountNonLocked;
    private Boolean isCredentialsNonExpired ;
    private Boolean isEnabled;
    private List<String> roles;
}
