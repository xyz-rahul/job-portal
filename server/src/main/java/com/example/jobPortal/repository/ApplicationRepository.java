package com.example.jobPortal.repository;

import com.example.jobPortal.entity.Application;
import com.example.jobPortal.entity.Job;
import com.example.jobPortal.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApplicationRepository extends JpaRepository<Application, Integer> {
    List<Application> findByUser(User user);

    List<Application> findByJob(Job job);
}
