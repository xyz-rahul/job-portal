package com.example.jobPortal.Config;

import com.example.jobPortal.entity.Application;
import com.example.jobPortal.entity.Job;
import com.example.jobPortal.payload.application.ApplicationDto;
import com.example.jobPortal.payload.job.JobDto;
import lombok.Builder;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.addMappings(new PropertyMap<Job, JobDto>() {
            @Override
            protected void configure() {
                map().setCompanyId(source.getCompany().getId());
            }
        });

        modelMapper.addMappings(new PropertyMap<Application, ApplicationDto>() {
            @Override
            protected void configure() {
                map().setUserId(source.getJob().getId());
                map().setJobId(source.getJob().getId());
            }
        });

        return modelMapper;
    }
}
