package com.example.jobPortal.controller;

import com.example.jobPortal.payload.job.JobCreateDto;
import com.example.jobPortal.payload.job.JobDto;
import com.example.jobPortal.payload.job.JobUpdateDto;
import com.example.jobPortal.service.JobService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

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
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sortField,
            @RequestParam(defaultValue = "ASC") String sortDirection,
            @RequestParam Map<String, String> filters) {

        Page<JobDto> jobs = jobService.getAll(page,size,sortField,sortDirection,filters);

        return ResponseEntity.ok(jobs);
    }


}


