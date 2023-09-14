package com.example.jobPortal.service;

import com.example.jobPortal.payload.job.JobCreateDto;
import com.example.jobPortal.payload.job.JobDto;
import com.example.jobPortal.payload.job.JobUpdateDto;
import org.springframework.data.domain.Page;

import java.util.Map;

public interface JobService {

    JobDto createJob(JobCreateDto JobCreateDto);

    JobDto getJobById(int id);


    JobDto updateJob(JobUpdateDto job);

    boolean deleteJob(int id);

    public Page<JobDto> getAll(int pageNumber, int pageSize, String sortBy, String sortDirection, Map<String, String> filters);
}
