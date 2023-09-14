package com.example.jobPortal.payload.job;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class JobCreateDto {
    private String title;

    private String description;

    private List<String> requirement;

    @JsonProperty("experience_required")
    private String experienceRequired;

    @JsonProperty("work_mode")
    private String workMode;

    private String industry;

    @JsonProperty("salary_range")
    private String salaryRange;

    @JsonProperty("company_id")
    private Integer companyId; // Use the company's ID to associate with the job
}


