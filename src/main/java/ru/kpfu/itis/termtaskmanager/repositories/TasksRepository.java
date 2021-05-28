package ru.kpfu.itis.termtaskmanager.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.kpfu.itis.termtaskmanager.models.Task;

import java.util.List;

public interface TasksRepository extends JpaRepository<Task, Long> {
    @Query(nativeQuery = true, value =
            "WITH _task_user AS (" +
                    "SELECT * " +
                    "FROM task_user tu " +
                    "LEFT JOIN task t on tu.task_id = t.id)" +
                    "SELECT * " +
                    "FROM _task_user _tu INNER JOIN account a ON _tu.task_id = a.id")
    List<Task> findAllByDoers_Username(String username);
}
