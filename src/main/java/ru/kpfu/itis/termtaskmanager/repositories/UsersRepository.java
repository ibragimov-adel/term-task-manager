package ru.kpfu.itis.termtaskmanager.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kpfu.itis.termtaskmanager.models.Group;
import ru.kpfu.itis.termtaskmanager.models.User;

import java.util.List;
import java.util.Optional;

public interface UsersRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
    List<User> findAllByGroup(Group group);
}
