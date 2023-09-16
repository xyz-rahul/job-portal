package com.example.jobPortal.Config;

import com.example.jobPortal.entity.Application;
import com.example.jobPortal.entity.Company;
import com.example.jobPortal.entity.Job;
import com.example.jobPortal.payload.application.ApplicationDto;
import com.example.jobPortal.payload.job.JobCreateDto;
import com.example.jobPortal.payload.job.JobDto;
import com.example.jobPortal.payload.job.JobUpdateDto;
import com.example.jobPortal.repository.CompanyRepository;
import com.example.jobPortal.service.CompanyService;
import com.example.jobPortal.service.UserService;
import jakarta.annotation.PostConstruct;
import lombok.Builder;
import org.modelmapper.AbstractConverter;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.print.attribute.standard.Destination;

@Configuration
public class AppConfig {
    @Autowired
    CompanyRepository companyRepository;
    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.addMappings(new PropertyMap<Job, JobDto>() {
            @Override
            protected void configure() {
                map().setCompanyId(source.getCompany().getId());
                map().setCompanyType(source.getCompany().getCompanyType());
            }
        });

        modelMapper.addMappings(new PropertyMap<JobCreateDto, Job>() {
            @Override
            protected void configure() {
                Converter<JobCreateDto, Company> converter = new AbstractConverter<JobCreateDto, Company>() {
                    @Override
                    protected Company convert(JobCreateDto jobCreateDto) {
                        return companyRepository.findById(jobCreateDto.getCompanyId()).orElse(null);
                    }
                };

                using(converter).map(source, destination.getCompany());

                //DTO obj maps companyId to id
                map().setId(null);
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
