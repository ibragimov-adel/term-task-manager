package ru.kpfu.itis.termtaskmanager.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.kpfu.itis.termtaskmanager.dto.UserForm;
import ru.kpfu.itis.termtaskmanager.services.AuthService;

import javax.annotation.security.PermitAll;

@Controller
public class AuthController {

    @Autowired
    private AuthService authService;

    @PermitAll
    @GetMapping(value = "/auth")
    public String getAuthPage(Model model) {
        model.addAttribute("title", "Вход / Регистрация");
        return "auth";
    }

    @PermitAll
    @PostMapping(value = "/auth/register")
    public String register(UserForm userForm) {
        authService.register(userForm);
        return "redirect:/auth";
    }

}
