package com.dame_mansour.app_spring_security.repository;

import com.dame_mansour.app_spring_security.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);


}
