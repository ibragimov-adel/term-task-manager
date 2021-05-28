package ru.kpfu.itis.termtaskmanager.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.kpfu.itis.termtaskmanager.dto.CommentDto;
import ru.kpfu.itis.termtaskmanager.models.Comment;
import ru.kpfu.itis.termtaskmanager.models.User;
import ru.kpfu.itis.termtaskmanager.repositories.CommentsRepository;
import ru.kpfu.itis.termtaskmanager.repositories.TasksRepository;
import ru.kpfu.itis.termtaskmanager.repositories.UsersRepository;

import static ru.kpfu.itis.termtaskmanager.dto.CommentDto.from;

import java.util.List;

@Component
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentsRepository commentsRepository;

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private TasksRepository tasksRepository;

    @Override
    public CommentDto createComment(CommentDto commentDto, String username) {
        User user = usersRepository.findByUsername(username).get();

        Comment comment = Comment.builder()
                .message(commentDto.getMessage())
                .task(tasksRepository.findById(commentDto.getTask()).orElseThrow(IllegalArgumentException::new))
                .creator(user)
                .build();
        commentsRepository.save(comment);
        return from(comment);
    }

    @Override
    public List<Comment> getAllComments(String username) {
        return commentsRepository.getAllByCreator_Username(username);
    }

    @Override
    public CommentDto deleteComment(Long commentId, String username) {
        Comment comment = commentsRepository.findById(commentId).orElseThrow();
        if (comment.getCreator().getUsername().equals(username)) {
            commentsRepository.deleteById(commentId);
            return from(comment);
        }
        throw new IllegalArgumentException();
    }
}
