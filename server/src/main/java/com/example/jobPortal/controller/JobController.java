package com.example.jobPortal.controller;

import com.example.jobPortal.payload.job.JobCreateDto;
import com.example.jobPortal.payload.job.JobDto;
import com.example.jobPortal.payload.job.JobUpdateDto;
import com.example.jobPortal.service.JobService;
import com.example.jobPortal.utils.*;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.deser.std.EnumDeserializer;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.EnumSet;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/jobs")
public class JobController {
    @Autowired
    JobService jobService;

    @Autowired
    ModelMapper modelMapper;


    @GetMapping("/{id}")
    public ResponseEntity<JobDto> getJob(@PathVariable("id") int id) {
        JobDto job = jobService.getJobById(id);
        if (job != null) {
            JobDto jobDto = modelMapper.map(job, JobDto.class);
            return new ResponseEntity<>(jobDto, HttpStatus.OK);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/create")
    public ResponseEntity<JobDto> createJob(@RequestBody JobCreateDto jobCreateDto) {
        JobDto createdJob = this.jobService.createJob(jobCreateDto);
        if (createdJob != null) {
            JobDto createdJobDto = modelMapper.map(createdJob, JobDto.class);
            return new ResponseEntity<>(createdJobDto, HttpStatus.CREATED);
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/update")
    public ResponseEntity<JobDto> updateJob(@RequestBody JobUpdateDto jobUpdateDto) {
        JobDto updatedJob = jobService.updateJob(jobUpdateDto);
        if (updatedJob != null) {
            JobDto updatedJobDto = modelMapper.map(updatedJob, JobDto.class);
            return new ResponseEntity<>(updatedJobDto, HttpStatus.OK);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteJob(@PathVariable("id") int id) {
        boolean deleted = jobService.deleteJob(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/all")
    public ResponseEntity<Page<JobDto>> getAllJobs(
            @RequestParam(value = "page number",defaultValue = "0",required = false) int page,
            @RequestParam(value = "page size",defaultValue = "10",required = false) int size,
            @RequestParam(value = "sort field",defaultValue = "id",required = false) String sortField,
            @RequestParam(value = "sort direction",defaultValue = "ASC",required = false) String sortDirection,
            @RequestParam(value = "education required",required = false)  List<Education> educationRequired,
            @RequestParam(value = "work mode",required = false) List<WorkMode> workMode,
            @RequestParam(value = "industry",required = false) List<Industry> industry,
            @RequestParam(value = "company type",required = false) List<CompanyType> companyType
            ) {

            //null are not allowed in repo function
            if(workMode == null || workMode.isEmpty()) workMode = Arrays.stream(WorkMode.values()).toList();
            if(industry == null || industry.isEmpty()) industry = Arrays.stream(Industry.values()).toList();
            if(educationRequired == null || educationRequired.isEmpty()) educationRequired = Arrays.stream(Education.values()).toList();
            if(companyType == null || companyType.isEmpty()) companyType = Arrays.stream(CompanyType.values()).toList();


            Page<JobDto> jobs = jobService.getAll(
                    page,
                    size,
                    sortField,
                    sortDirection,
                    workMode,
                    industry,
                    educationRequired,
                    companyType
            );

        return ResponseEntity.ok(jobs);
        }

    @GetMapping("/getJobFilterOptions")
    public ResponseEntity<JobFilterOptions> getJobFilterOptions() {
        JobFilterOptions jobFilterOptions = new JobFilterOptions();
        if (jobFilterOptions != null) {
            return new ResponseEntity<>(jobFilterOptions, HttpStatus.OK);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}


