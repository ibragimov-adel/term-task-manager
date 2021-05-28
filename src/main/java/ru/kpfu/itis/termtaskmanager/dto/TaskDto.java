package ru.kpfu.itis.termtaskmanager.dto;

import lombok.Data;

import java.util.List;

@Data
public class TaskDto {
    private Long id;

    private String title;

    private String description;

    private List<Long> doers;

    private Boolean finished;
}
