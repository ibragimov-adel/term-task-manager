package ru.kpfu.itis.termtaskmanager.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.kpfu.itis.termtaskmanager.dto.TaskDto;
import ru.kpfu.itis.termtaskmanager.models.Task;
import ru.kpfu.itis.termtaskmanager.security.details.UserDetailsImpl;
import ru.kpfu.itis.termtaskmanager.services.TaskService;
import ru.kpfu.itis.termtaskmanager.services.UsersService;

@Controller
public class TasksController {

    @Autowired
    private TaskService taskService;

    @Autowired
    private UsersService usersService;

    @GetMapping(value = "/tasks")
    public String getTasksPage(Model model, @AuthenticationPrincipal UserDetailsImpl user) {
        String username = user.getUsername();
        model.addAttribute("title", "Задачи");
        model.addAttribute("users", usersService.getUsersFromGroup(username));
        model.addAttribute("tasks", taskService.getAll(username));
        return "tasks";
    }

    @PostMapping(value = "/tasks")
    public String createTask(TaskDto taskDto, @AuthenticationPrincipal UserDetailsImpl user) {
        taskService.createTask(taskDto, user.getUsername());
        return "redirect:/tasks";
    }

    @GetMapping(value = "/tasks/{task-id}")
    public String getTaskPage(
            Model model,
            @PathVariable("task-id") Long taskId,
            @AuthenticationPrincipal UserDetailsImpl user
    ) {
        Task task = taskService.getById(taskId);
        model.addAttribute("title", task.getTitle());
        model.addAttribute("task", task);
        model.addAttribute("formValue", !task.getFinished());
        model.addAttribute("user", usersService.getUserByUsername(user.getUsername()));
        return "task";
    }

    @PostMapping(value = "/tasks/{task-id}")
    public String updateTask(
            TaskDto taskDto,
            @PathVariable("task-id") Long taskId
    ) {
        taskDto.setId(taskId);
        taskService.updateTask(taskDto);
        return "redirect:/tasks";
    }

}
