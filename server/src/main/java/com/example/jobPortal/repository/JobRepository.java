package com.example.jobPortal.repository;

import com.example.jobPortal.entity.Application;
import com.example.jobPortal.entity.Company;
import com.example.jobPortal.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Repository
public interface JobRepository extends JpaRepository<Job, Integer> , JpaSpecificationExecutor{
    Optional<List<Job>> findByTitle(String title);
    Optional<List<Job>> findByIndustry(String industry);
    Optional<List<Job>> findBySalaryRange(String salaryRange);
    Optional<List<Job>> findByWorkMode(String workMode);
    Optional<List<Job>> findByExperienceRequired(String experienceRequired);
    Optional<Job> findByCompany(Company company);

}
