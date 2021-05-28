package ru.kpfu.itis.termtaskmanager.dto;

import lombok.Data;

@Data
public class UserDto {
    private String firstName;
    private String lastName;
    private String telegramChatId;
}
