package ru.kpfu.itis.termtaskmanager.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.kpfu.itis.termtaskmanager.dto.GroupDto;
import ru.kpfu.itis.termtaskmanager.models.Group;
import ru.kpfu.itis.termtaskmanager.models.User;
import ru.kpfu.itis.termtaskmanager.repositories.GroupsRepository;
import ru.kpfu.itis.termtaskmanager.repositories.UsersRepository;

@Component
public class GroupServiceImpl implements GroupService {

    @Autowired
    private GroupsRepository groupsRepository;

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private UtilsService utilsService;

    @Override
    public void createGroup(GroupDto groupDto, String username) {
        Group group = Group.builder()
                .title(groupDto.getTitle())
                .code(utilsService.generateRandomString(8))
                .build();
        group = groupsRepository.save(group);

        User user = usersRepository.findByUsername(username).get();
        user.setGroup(group);
        user.setRoleInGroup(User.RoleInGroup.CREATOR);
        usersRepository.save(user);
    }

    @Override
    public void joinGroup(GroupDto groupDto, String username) {
        Group group = groupsRepository.findByCode(groupDto.getCode())
                .orElseThrow(IllegalArgumentException::new);

        User user = usersRepository.findByUsername(username).get();
        user.setGroup(group);
        user.setRoleInGroup(User.RoleInGroup.MEMBER);
        usersRepository.save(user);
    }
}
