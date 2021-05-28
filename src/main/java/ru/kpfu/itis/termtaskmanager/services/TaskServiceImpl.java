package ru.kpfu.itis.termtaskmanager.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.kpfu.itis.termtaskmanager.dto.TaskDto;
import ru.kpfu.itis.termtaskmanager.models.Task;
import ru.kpfu.itis.termtaskmanager.repositories.TasksRepository;
import ru.kpfu.itis.termtaskmanager.repositories.UsersRepository;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TaskServiceImpl implements TaskService {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private TasksRepository tasksRepository;

    @Autowired
    private TelegramService telegramService;

    @Override
    public void createTask(TaskDto taskDto, String username) {
        Task task = Task.builder()
                .title(taskDto.getTitle())
                .description(taskDto.getDescription())
                .finished(false)
                .creator(usersRepository.findByUsername(username).get())
                .doers(taskDto.getDoers().stream()
                        .map((t) -> usersRepository.findById(t).orElseThrow(IllegalArgumentException::new))
                        .collect(Collectors.toList()))
                .build();
        tasksRepository.save(task);

        String telegramMessage = generateTelegramMessage(task.getTitle());
        task.getDoers().forEach(user -> telegramService.sendMessage(user.getTelegramChatId(), telegramMessage));
    }

    @Override
    public void updateTask(TaskDto taskDto) {
        Task task = tasksRepository.findById(taskDto.getId()).orElseThrow(IllegalArgumentException::new);
        task.setFinished(taskDto.getFinished());
        tasksRepository.save(task);
    }

    @Override
    public List<Task> getAll(String username) {
        return tasksRepository.findAllByDoers_Username(username);
    }

    @Override
    public Task getById(Long id) {
        return tasksRepository.findById(id).orElseThrow(IllegalArgumentException::new);
    }

    private String generateTelegramMessage(String title) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<u>Новая задача</u>");
        stringBuilder.append("%0A");
        stringBuilder.append("%0A");
        stringBuilder.append("<b>").append(title).append("</b>");
        return stringBuilder.toString();
    }
}
