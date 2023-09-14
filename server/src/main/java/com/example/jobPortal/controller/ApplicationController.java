package com.example.jobPortal.controller;

import com.example.jobPortal.payload.application.ApplicationCreateDto;
import com.example.jobPortal.payload.application.ApplicationDto;
import com.example.jobPortal.payload.job.JobDto;
import com.example.jobPortal.service.ApplicationService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/applications")
public class ApplicationController {
    @Autowired
    private ApplicationService applicationService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/{id}")
    public ResponseEntity<ApplicationDto> getJob(@PathVariable("id") int id) {
        ApplicationDto applicationDto = applicationService.getApplicationById(id);
        if (applicationDto != null) {
            return new ResponseEntity<>(applicationDto, HttpStatus.OK);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/apply")
    public ResponseEntity<ApplicationDto> applyForJob(@RequestBody ApplicationCreateDto applicationCreateDto) {
        ApplicationDto createdApplication = applicationService.applyForJob(applicationCreateDto.getUserId(), applicationCreateDto.getJobId());

        if (createdApplication != null) {
            ApplicationDto createdApplicationDto = modelMapper.map(createdApplication, ApplicationDto.class);
            return new ResponseEntity<>(createdApplicationDto, HttpStatus.CREATED);
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<ApplicationDto>> getApplicationsByUser(@PathVariable("userId") Integer userId) {
        List<ApplicationDto> applications = applicationService.getApplicationsByUser(userId);
        if (applications != null) {
            return new ResponseEntity<>(applications, HttpStatus.OK);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    @GetMapping("/job/{jobId}")
    public ResponseEntity<List<ApplicationDto>> getApplicationsByJob(@PathVariable("jobId") Integer jobId) {
        List<ApplicationDto> applications = applicationService.getApplicationsByJob(jobId);
        if (applications != null) {
            return new ResponseEntity<>(applications, HttpStatus.OK);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    @DeleteMapping("/withdraw/{id}")
    public ResponseEntity<Void> withdrawApplication(@PathVariable("id") Integer id) {
        boolean withdrawn = applicationService.withdrawApplication(id);
        if (withdrawn) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
