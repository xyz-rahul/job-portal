package com.example.jobPortal.payload.job;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class JobDto {
    private Integer id;

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
    private Integer companyId;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss") // Customize date format
    private Date createdAt;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss") // Customize date format
    private Date updatedAt;
}