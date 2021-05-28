package ru.kpfu.itis.termtaskmanager.services;

import ru.kpfu.itis.termtaskmanager.dto.UserForm;

public interface AuthService {
    void register(UserForm userForm);
}
