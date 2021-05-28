package ru.kpfu.itis.termtaskmanager.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.kpfu.itis.termtaskmanager.models.Comment;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CommentDto {
    private long id;
    private String message;
    private Long task;
    private String creator;

    public static CommentDto from(Comment comment) {
        CommentDto result = CommentDto.builder()
                .id(comment.getId())
                .message(comment.getMessage())
                .task(comment.getTask().getId())
                .creator(comment.getCreator().getFirstName() + " " + comment.getCreator().getLastName())
                .build();
        return result;
    }
}
