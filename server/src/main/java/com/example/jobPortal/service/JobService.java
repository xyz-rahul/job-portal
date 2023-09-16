package com.example.jobPortal.service;

import com.example.jobPortal.payload.job.JobCreateDto;
import com.example.jobPortal.payload.job.JobDto;
import com.example.jobPortal.payload.job.JobUpdateDto;
import com.example.jobPortal.utils.CompanyType;
import com.example.jobPortal.utils.Education;
import com.example.jobPortal.utils.Industry;
import com.example.jobPortal.utils.WorkMode;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

public interface JobService {

    JobDto createJob(JobCreateDto JobCreateDto);

    JobDto getJobById(int id);


    JobDto updateJob(JobUpdateDto job);

    boolean deleteJob(int id);

    public Page<JobDto> getAll(
            int pageNumber,
            int pageSize,
            String sortBy,
            String sortDirection,
            List<WorkMode> workMode,
            List<Industry> industry,
            List<Education> educationRequired,
            List<CompanyType> companyType
    );
}
