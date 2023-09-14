package com.example.jobPortal.service;

import com.example.jobPortal.payload.application.ApplicationDto;
import com.example.jobPortal.payload.company.CompanyDto;

import java.util.List;

public interface ApplicationService {

    public ApplicationDto applyForJob(Integer userId, Integer jobId);
    ApplicationDto getApplicationById(int id);

    public List<ApplicationDto> getApplicationsByUser(Integer userId);

    public List<ApplicationDto> getApplicationsByJob(Integer jobId);

    public boolean withdrawApplication(Integer id);

    public boolean rejectApplication(Integer id);
}
