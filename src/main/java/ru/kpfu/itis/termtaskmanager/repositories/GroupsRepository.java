package ru.kpfu.itis.termtaskmanager.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kpfu.itis.termtaskmanager.models.Group;

import java.util.Optional;

public interface GroupsRepository extends JpaRepository<Group, Long> {
    Optional<Group> findByCode(String code);
}
