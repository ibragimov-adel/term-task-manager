package ru.kpfu.itis.termtaskmanager.services;

import ru.kpfu.itis.termtaskmanager.dto.GroupDto;

public interface GroupService {

    void createGroup(GroupDto groupDto, String username);

    void joinGroup(GroupDto groupDto, String username);

    void leaveGroup(String username);

}
