package ru.kpfu.itis.termtaskmanager.models;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String description;

    @ManyToOne
    @JoinColumn(name = "creator")
    @ToString.Exclude
    private User creator;

    @ManyToMany
    @JoinTable(
            name = "task_user",
            joinColumns = {@JoinColumn(name = "task_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")})
    @ToString.Exclude
    private List<User> doers;

    private Boolean finished;

    @OneToMany(mappedBy = "task")
    @ToString.Exclude
    private List<Comment> comments;
}
