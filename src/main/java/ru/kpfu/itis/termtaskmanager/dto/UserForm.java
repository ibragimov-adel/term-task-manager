package ru.kpfu.itis.termtaskmanager.dto;

import lombok.Data;

@Data
public class UserForm {
    private String firstName;
    private String lastName;
    private String username;
    private String password;
}
