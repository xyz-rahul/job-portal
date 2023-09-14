package com.example.jobPortal.payload.job;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class JobUpdateDto {
    private Integer id;

    private String title;

    private String description;

    private List<String> requirement;

    @JsonProperty("experience_required")
    private String experienceRequired;

    @JsonProperty("work_mode")
    private String workMode;

    @JsonProperty("industry")
    private String industry;

    @JsonProperty("salary_range")
    private String salaryRange;
}
