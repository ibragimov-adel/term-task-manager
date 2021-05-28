package ru.kpfu.itis.termtaskmanager.models;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "party")
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String code;

    @OneToMany(mappedBy = "group")
    @ToString.Exclude
    private List<User> users;

}
