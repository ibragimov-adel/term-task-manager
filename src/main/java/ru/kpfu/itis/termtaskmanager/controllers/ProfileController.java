package ru.kpfu.itis.termtaskmanager.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.kpfu.itis.termtaskmanager.dto.UserDto;
import ru.kpfu.itis.termtaskmanager.security.details.UserDetailsImpl;
import ru.kpfu.itis.termtaskmanager.services.UsersService;

@Controller
public class ProfileController {

    @Autowired
    private UsersService usersService;

    @GetMapping(value = "/profile")
    public String getProfilePage(@AuthenticationPrincipal UserDetailsImpl user, Model model) {
        model.addAttribute("title", "Профиль");
        model.addAttribute("user", usersService.getUserByUsername(user.getUsername()));
        return "profile";
    }

    @PostMapping(value = "/profile")
    public String updateProfile(UserDto userDto, @AuthenticationPrincipal UserDetailsImpl user) {
        usersService.updateUser(user.getUsername(), userDto);
        return "redirect:/profile";
    }

}
