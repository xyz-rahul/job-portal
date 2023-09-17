package com.example.jobPortal.service.implementation;

import com.example.jobPortal.entity.Job;
import com.example.jobPortal.payload.job.JobCreateDto;
import com.example.jobPortal.payload.job.JobDto;
import com.example.jobPortal.payload.job.JobUpdateDto;
import com.example.jobPortal.repository.JobRepository;
import com.example.jobPortal.service.JobService;
import com.example.jobPortal.utils.CompanyType;
import com.example.jobPortal.utils.Education;
import com.example.jobPortal.utils.Industry;
import com.example.jobPortal.utils.WorkMode;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class JobServiceImpl implements JobService {

    @Autowired
    private  JobRepository jobRepository;
    @Autowired
    private  ModelMapper modelMapper;


    public JobDto createJob(JobCreateDto jobCreateDto) {
        Job jobToCreate = modelMapper.map(jobCreateDto, Job.class);
        Job savedJob = jobRepository.save(jobToCreate);
        return modelMapper.map(savedJob, JobDto.class);
    }

    public List<JobDto> getAllJobs() {
        List<Job> jobs = jobRepository.findAll();
        return jobs.stream()
                .map(job -> modelMapper.map(job, JobDto.class))
                .collect(Collectors.toList());
    }

    public JobDto getJobById(int jobId) {
        Job job = jobRepository.findById(jobId).orElse(null);
        return this.modelMapper.map(job, JobDto.class);
    }

    public JobDto updateJob(JobUpdateDto jobUpdateDto) {
        Integer jobId = jobUpdateDto.getId(); // Get the ID from the DTO
        Job existingJob = jobRepository.findById(jobId).orElse(null);
        if (existingJob == null) {
            return null;
        }

        // Map only the fields you want to update
        modelMapper.map(jobUpdateDto, existingJob);

        Job updatedJob = jobRepository.save(existingJob);
        return modelMapper.map(updatedJob, JobDto.class);
    }

    public boolean deleteJob(int jobId) {
        if (jobRepository.existsById(jobId)) {
            jobRepository.deleteById(jobId);
            return true;
        }
        return false;
    }


    public Page<JobDto> getAll(
            int pageNumber,
            int pageSize,
            String sortBy,
            String sortDirection,
            List<WorkMode> workMode,
            List<Industry> industry,
            List<Education> educationRequired,
            List<CompanyType> companyType
    ){

        Sort sort = Sort.by(
                sortDirection.equalsIgnoreCase("asc")
                        ? Sort.Direction.ASC:Sort.Direction.DESC,
                sortBy);
        Pageable pageable = PageRequest.of(pageNumber, pageSize, sort);

        Page<Job> jobPage = jobRepository.findByWorkModeInAndIndustryInAndEducationRequiredInAndCompanyCompanyTypeIn(
                workMode,
                industry,
                educationRequired,
                companyType,
                pageable
        );
        System.out.println(jobPage);

        return jobPage.map(job -> modelMapper.map(job, JobDto.class));
    }
}
