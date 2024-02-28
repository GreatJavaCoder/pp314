package ru.komm.pp314.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.komm.pp314.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
}
