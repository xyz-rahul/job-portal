package com.example.jobPortal.payload.job;

import com.example.jobPortal.utils.Education;
import com.example.jobPortal.utils.Industry;
import com.example.jobPortal.utils.WorkMode;
import com.fasterxml.jackson.annotation.JsonFormat;
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

    @JsonFormat(shape = JsonFormat.Shape.OBJECT)
    @JsonProperty("education_required")
    private Education educationRequired;

    @JsonFormat(shape = JsonFormat.Shape.OBJECT)
    @JsonProperty("work_mode")
    private WorkMode workMode;

    @JsonFormat(shape = JsonFormat.Shape.OBJECT)
    private Industry industry;

    @JsonProperty("salary_range")
    private String salaryRange;

    @JsonProperty("company_id")
    private Integer companyId; // Use the company's ID to associate with the job
}


