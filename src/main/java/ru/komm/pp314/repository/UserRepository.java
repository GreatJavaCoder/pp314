package ru.komm.pp314.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.komm.pp314.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    @Query(" select u from User u left join fetch u.roles where u.name = :name ")
    User findByUsername(@Param("name") String name);

}
