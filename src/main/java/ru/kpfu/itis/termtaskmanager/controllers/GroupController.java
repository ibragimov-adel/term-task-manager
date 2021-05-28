package ru.kpfu.itis.termtaskmanager.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import ru.kpfu.itis.termtaskmanager.dto.GroupDto;
import ru.kpfu.itis.termtaskmanager.security.details.UserDetailsImpl;
import ru.kpfu.itis.termtaskmanager.services.GroupService;

@Controller
public class GroupController {

    @Autowired
    private GroupService groupService;

    @PostMapping(value = "/group/create")
    public String createGroup(GroupDto groupDto, @AuthenticationPrincipal UserDetailsImpl user) {
        groupService.createGroup(groupDto, user.getUsername());
        return "redirect:/profile";
    }

    @PostMapping(value = "/group/join")
    public String joinGroup(GroupDto groupDto, @AuthenticationPrincipal UserDetailsImpl user) {
        groupService.joinGroup(groupDto, user.getUsername());
        return "redirect:/profile";
    }
}
