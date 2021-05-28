package ru.kpfu.itis.termtaskmanager.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import ru.kpfu.itis.termtaskmanager.dto.UserForm;
import ru.kpfu.itis.termtaskmanager.models.User;
import ru.kpfu.itis.termtaskmanager.repositories.UsersRepository;

@Component
public class AuthServiceImpl implements AuthService {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void register(UserForm userForm) {
        User user = User.builder()
                .username(userForm.getUsername())
                .hashedPassword(passwordEncoder.encode(userForm.getPassword()))
                .firstName(userForm.getFirstName())
                .lastName(userForm.getLastName())
                .telegramChatId("")
                .build();

        usersRepository.save(user);
    }
}
