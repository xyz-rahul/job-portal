package com.example.jobPortal.repository;

import com.example.jobPortal.entity.Company;
import com.example.jobPortal.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Integer> {


}
