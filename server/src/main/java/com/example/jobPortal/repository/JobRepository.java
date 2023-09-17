package com.example.jobPortal.repository;

import com.example.jobPortal.entity.Company;
import com.example.jobPortal.entity.Job;
import com.example.jobPortal.utils.CompanyType;
import com.example.jobPortal.utils.Education;
import com.example.jobPortal.utils.Industry;
import com.example.jobPortal.utils.WorkMode;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface JobRepository extends JpaRepository<Job, Integer> , JpaSpecificationExecutor{
    Optional<List<Job>> findByTitle(String title);

    Optional<Job> findByCompany(Company company);

    Page<Job> findByWorkModeInAndIndustryInAndEducationRequiredInAndCompanyCompanyTypeIn(
            List<WorkMode> workMode,
            List<Industry> industry,
            List<Education> educationRequired,
            List<CompanyType> companyType,
            Pageable pageable
    );
}
