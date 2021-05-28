package ru.kpfu.itis.termtaskmanager.models;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "account")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String hashedPassword;

    private String firstName;

    private String lastName;

    private String telegramChatId;

    @Enumerated(value = EnumType.STRING)
    private RoleInGroup roleInGroup;

    @ManyToOne
    @JoinColumn(name = "group_id")
    @ToString.Exclude
    private Group group;

    @ManyToMany(mappedBy = "doers")
    @ToString.Exclude
    private List<Task> tasks;

    @OneToMany(mappedBy = "creator")
    @ToString.Exclude
    private List<Task> createdTasks;

    public enum RoleInGroup {
        CREATOR, MEMBER
    }

    public boolean isCreator() {
        return this.roleInGroup == RoleInGroup.CREATOR;
    }

}
