package com.example.jobPortal.repository;

import com.example.jobPortal.entity.Application;
import com.example.jobPortal.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByUsername(String username);
    Optional<List<User>> findByName(String name);
    Optional<List<User>> findBySkillsContaining(String skill);
    Optional<List<User>> findByEducationContaining(String education);
    Optional<User> findByPhoneNumber(String phoneNumber);
    Optional<User> findByUsernameAndPassword(String username, String password);
}
