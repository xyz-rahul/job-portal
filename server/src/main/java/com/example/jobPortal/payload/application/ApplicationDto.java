package com.example.jobPortal.payload.application;

import com.example.jobPortal.entity.Job;
import com.example.jobPortal.entity.User;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ApplicationDto {
    private Integer id;

    @JsonProperty("user_id")
    private Integer userId;

    @JsonProperty("job_id")
    private Integer jobId;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss") // Customize date format
    private Date createdAt;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss") // Customize date format
    private Date updatedAt;

}