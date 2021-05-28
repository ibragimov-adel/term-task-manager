package ru.kpfu.itis.termtaskmanager.controllers;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import ru.kpfu.itis.termtaskmanager.security.details.UserDetailsImpl;

import javax.annotation.security.PermitAll;

@Controller
public class IndexController {

    @PermitAll
    @GetMapping(value = "/")
    public String getIndexPage(@AuthenticationPrincipal UserDetailsImpl user) {
        if (user == null) {
            return "redirect:/auth";
        } else {
            return "redirect:/profile";
        }
    }

}
