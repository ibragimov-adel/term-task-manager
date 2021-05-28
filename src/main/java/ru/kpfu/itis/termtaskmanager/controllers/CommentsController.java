package ru.kpfu.itis.termtaskmanager.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import ru.kpfu.itis.termtaskmanager.dto.CommentDto;
import ru.kpfu.itis.termtaskmanager.security.details.UserDetailsImpl;
import ru.kpfu.itis.termtaskmanager.services.CommentService;

@RestController
public class CommentsController {

    @Autowired
    private CommentService commentService;

    @PostMapping("/comments")
    public ResponseEntity<CommentDto> createComment(
            @RequestBody CommentDto commentDto,
            @AuthenticationPrincipal UserDetailsImpl user
    ) {
        return ResponseEntity.ok(commentService.createComment(commentDto, user.getUsername()));
    }

    @DeleteMapping("/comments/{comment-id}")
    public ResponseEntity<CommentDto> deleteComment(
            @AuthenticationPrincipal UserDetailsImpl user,
            @PathVariable("comment-id") Long commentId
    ) {
        return ResponseEntity.ok(commentService.deleteComment(commentId, user.getUsername()));
    }

}
