package com.example.jobPortal.payload.application;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ApplicationCreateDto {
    @JsonProperty("user_id")
    private Integer userId;

    @JsonProperty("job_id")
    private Integer jobId;
}


