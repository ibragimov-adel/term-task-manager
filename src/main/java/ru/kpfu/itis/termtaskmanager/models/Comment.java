package ru.kpfu.itis.termtaskmanager.models;

import lombok.*;

import javax.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String message;

    @ManyToOne
    @JoinColumn(name = "creator")
    @ToString.Exclude
    private User creator;

    @ManyToOne
    @JoinColumn(name = "task_id")
    @ToString.Exclude
    private Task task;

}
