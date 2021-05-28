package ru.kpfu.itis.termtaskmanager.services;

import ru.kpfu.itis.termtaskmanager.dto.UserDto;
import ru.kpfu.itis.termtaskmanager.models.User;

import java.util.List;

public interface UsersService {
    void updateUser(String username, UserDto userDto);
    User getUserByUsername(String username);
    List<User> getUsersFromGroup(String username);
}
