package ru.kpfu.itis.termtaskmanager.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.kpfu.itis.termtaskmanager.dto.UserDto;
import ru.kpfu.itis.termtaskmanager.models.User;
import ru.kpfu.itis.termtaskmanager.repositories.UsersRepository;

import java.util.List;

@Component
public class UsersServiceImpl implements UsersService {
    @Autowired
    private UsersRepository usersRepository;

    @Override
    public void updateUser(String username, UserDto userDto) {
        User userForUpdate = usersRepository.findByUsername(username).orElseThrow(IllegalArgumentException::new);
        userForUpdate.setFirstName(userDto.getFirstName());
        userForUpdate.setLastName(userDto.getLastName());
        userForUpdate.setTelegramChatId(userDto.getTelegramChatId());
        usersRepository.save(userForUpdate);
    }

    @Override
    public User getUserByUsername(String username) {
        return usersRepository.findByUsername(username).get();
    }

    @Override
    public List<User> getUsersFromGroup(String username) {
        User user = getUserByUsername(username);
        return usersRepository.findAllByGroup(user.getGroup());
    }
}
