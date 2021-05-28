package ru.kpfu.itis.termtaskmanager.services;

import ru.kpfu.itis.termtaskmanager.dto.TaskDto;
import ru.kpfu.itis.termtaskmanager.models.Task;

import java.util.List;

public interface TaskService {
    void createTask(TaskDto taskDto, String username);
    void updateTask(TaskDto taskDto);
    List<Task> getAll(String username);
    Task getById(Long id);
}
