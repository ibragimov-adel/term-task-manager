package ru.kpfu.itis.termtaskmanager.services;

import ru.kpfu.itis.termtaskmanager.dto.CommentDto;
import ru.kpfu.itis.termtaskmanager.models.Comment;

import java.util.List;

public interface CommentService {
    CommentDto createComment(CommentDto commentDto, String username);
    List<Comment> getAllComments(String username);
    CommentDto deleteComment(Long commentId, String username);
}
