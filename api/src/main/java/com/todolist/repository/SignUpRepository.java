package com.todolist.repository;

import com.todolist.entity.SignUp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SignUpRepository extends JpaRepository<SignUp, Long> {

    Optional<SignUp> findByDisplayName(String displayName);

    Optional<SignUp> findByName(String name);
}
