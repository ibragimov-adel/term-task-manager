package ru.kpfu.itis.termtaskmanager.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kpfu.itis.termtaskmanager.models.Comment;

import java.util.List;

public interface CommentsRepository extends JpaRepository<Comment, Long> {
    List<Comment> getAllByCreator_Username(String username);
}
